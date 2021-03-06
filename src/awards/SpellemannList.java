package awards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Used to create articles like [[Spellemannprisen 2005]]
 */
public class SpellemannList {

    private static ArrayList<Entry> entries;

    private static String htmlText;
    private static int year;

    public static void main(String[] args) {
        printArticle(1993);
    }

    /**
     * Retrieves the information of the html code.
     */
    private static void retrieveInformation() {
        fillMusicCategories();
        fillEntryList();
    }

    /**
     * Prints the wiki projects.general.article.
     */
    public static void printArticle(int spellemannYear) {
        year = spellemannYear;
        htmlText = getHTML(year);

        retrieveInformation();

        printFirstParagraph();
        printWinnerTable();
        printNomineeList();
        printEnding();
    }

    /**
     * Retrieves the html code with the list of winner of nominees at the Spellemannprisen for a given year.
     *
     * @param year the year
     * @return the html code
     */
    private static String getHTML(int year) {
        BufferedReader reader;
        StringBuilder builder = new StringBuilder();

        try {
            URL url = new URL("https://spellemann.no/arkiv/?aar=" + year + "&klasse=&artist-tittel=");
            reader = new BufferedReader(new InputStreamReader(url.openStream()));


            String line;

            while ((line = reader.readLine()) != null) {

                builder.append(line);
            }
        } catch (IOException e) {
            return "";
        }

        String html = builder.toString();

        /*
            Cuts unnecessary parts of the code.
         */
        int indexStart = html.indexOf("<td class=");
        int indexEnd = html.indexOf("</tbody");

        html = html.substring(indexStart, indexEnd);

        html = html.replaceAll("<tr>", "\n<tr>");
        html = html.replaceAll("<td class=\"column1\">" + year + "</td>", "");
        html = html.replaceAll("&amp;", "&");

        return html;
    }

    /**
     * Prints the first part of the projects.general.article.
     */
    private static void printFirstParagraph() {
        int edition = year - 1972 + 1;

        System.out.println("Der '''Spellemannpris " + year + "''' war die " + edition + ". Ausgabe des norwegischen Musikpreises [[Spellemannprisen]]. Die Nominierungen ber??cksichtigten Ver??ffentlichungen des Musikjahres " + year + ". Die Verleihung der Preise fand im Fr??hjahr " + (year + 1) + " statt. In der Kategorie ?????rets Spellemann??? wurde [[" + getSpellemann() + "]] ausgezeichnet, den Ehrenpreis (???Hedersprisen???) erhielt [[" + getHederspris() + "]].\n" +
                "\n== Verleihung ==\n\n");

        System.out.println("== Gewinner ==\n" +
                "{| class=\"wikitable\"\n" +
                "!Kategorie\n" +
                "!Gewinner\n" +
                "!Werk");
    }

    /**
     * Retrieves the winner of the category "??rets Spellemann".
     *
     * @return the winner
     */
    private static String getSpellemann() {
        for (Entry entry : entries) {
            if (entry.vinner && entry.nominationCategory.equals("??rets Spellemann")) {
                return entry.name;
            }
        }

        return "";
    }

    /**
     * Returns the winner of the category "Hederspris".
     *
     * @return the winner
     */
    private static String getHederspris() {
        for (Entry entry : entries) {
            if (entry.vinner && (entry.nominationCategory.equals("??rets Hederspris") || entry.nominationCategory.equals("Hederspris") || entry.nominationCategory.equals("Hedersprisen"))) {
                return entry.name;
            }
        }

        return "";
    }

    /**
     * Prints the table of winners.
     */
    private static void printWinnerTable() {
        Collections.sort(entries);
        for (Entry entry : entries) {
            if (entry.vinner) {
                System.out.print(entry.getTableEntry());
            }
        }

        System.out.println("|}");
    }

    /**
     * Prints list of nominees.
     */
    private static void printNomineeList() {
        System.out.println("\n== Nominierte ==");

        String currentCategory = "";
        Collections.sort(entries);
        for (Entry entry : entries) {

            if (!currentCategory.equals(entry.nominationCategory)) {
                currentCategory = entry.nominationCategory;
                System.out.println("\n'''" + currentCategory + "'''");
            }

            System.out.println(entry.getNomineeEntry());
        }
    }

    /**
     * Prints the ending of the projects.general.article (weblinks, references, Wiki categories).
     */
    private static void printEnding() {
        System.out.println("\n" +
                "== Weblinks ==\n" +
                "* [https://spellemann.no/arkiv/?aar=" + year + "&klasse=&artist-tittel= Spellemannprisen Archiv " + year + "] (norwegisch)\n" +
                "\n" +
                "== Einzelnachweise ==\n" +
                "<references />\n" +
                "\n{{Navigationsleiste Spellemannprisen}}\n" +
                "\n" +
                "[[Kategorie:Spellemannprisen]]\n" +
                "[[Kategorie:Preisverleihung " + (year + 1) + "]]\n" +
                "[[Kategorie:Musikveranstaltung (Norwegen)]]\n");
    }

    /**
     * Goes through the html code and fills the list of music categories.
     */
    private static void fillMusicCategories() {
        ArrayList<String> musicCategories = new ArrayList<>();

        Scanner scanner = new Scanner(htmlText);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            String category = getNominationCategory(line);
            if (!musicCategories.contains(category)) {
                musicCategories.add(category);
            }
        }
    }

    /**
     * Runs through the html text and fills the list of nominees.
     */
    private static void fillEntryList() {
        entries = new ArrayList<>();

        Scanner scanner = new Scanner(htmlText);

        /*
            As long as there are still entries left it collects the information from them and adds them to the list.
         */
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            String category = getNominationCategory(line);
            String name = getName(line);
            boolean isWinner = getIsWinner(line);
            String title = getTitle(line);

            entries.add(new Entry(name, isWinner, category, title));
        }
    }

    /**
     * Takes a line and returns the name of the category the nomination was made.
     *
     * @param line the line
     * @return the music category
     */
    private static String getNominationCategory(String line) {
        int indexStart = line.indexOf("column4\">") + 9;
        int indexEnd = line.indexOf("</td><td class=\"column5");


        return line.substring(indexStart, indexEnd);
    }

    /**
     * Takes a line and returns the name of the nominated piece of art (song/album...)
     *
     * @param line the line
     * @return the title
     */
    private static String getTitle(String line) {
        int indexStart = line.indexOf("column3\">") + 9;
        int indexEnd = line.indexOf("</td><td class=\"column4");

        return line.substring(indexStart, indexEnd);
    }

    /**
     * Takes a line and returns the name of the nominee (projects.person/band).
     *
     * @param line the line
     * @return the name of the nominee
     */
    private static String getName(String line) {
        int indexStart = line.indexOf("column2\">") + 9;
        int indexEnd = line.indexOf("</td><td class=\"column3");

        return line.substring(indexStart, indexEnd);
    }

    /**
     * Takes a line of the html text and reads whether or not it is an entry of a winner or only a nominee.
     *
     * @param line the line
     * @return whether it is a winner
     */
    private static boolean getIsWinner(String line) {
        int indexStart = line.indexOf("<span>") + 6;
        int indexEnd = line.indexOf("</span></td>");

        String isWinner = line.substring(indexStart, indexEnd);

        return isWinner.equals("Ja");
    }


    static class Entry implements Comparable<Entry> {
        private final boolean vinner;
        private final String nominationCategory;
        private final String title;
        private String name;

        public Entry(String name, boolean vinner, String category, String title) {
            this.name = name.replaceAll(", ", "]], [[").replaceAll(" / ", "]], [[").replaceAll("Oslo Philharmonic Orchestra", "Philharmonisches Orchester Oslo");
            this.name = this.name.replaceAll("Alan Walker", "Alan Walker (Musikproduzent)|");

            this.vinner = vinner;
            this.nominationCategory = category;
            this.title = title;
        }

        /**
         * Takes the music category and tries to add the German translation. Otherwise the category itself is returned.
         *
         * @return the text for the table
         */
        private String getCategoryForTable() {
            return switch (nominationCategory.toLowerCase()) {
                case "eksportprisen" -> "";
                case "elektronika/dancemusikk" -> "Elektronika/Dancemusikk<br />''(Elektronika/Dance-Musik)''";
                case "danseband" -> "[[Dansband|Danseband]]";
                case "juryens hederspris" -> "Juryens hederspris<br />''(Ehrenpreis der Jury)''";
                case "spesialpris" -> "Spesialpris<br />''(Spezialpreis)''";
                case "barneplate" -> "Barneplate<br />''(Kinderplatte)''";
                case "??rets barneplate" -> "??rets Barneplate<br />''(Kinderplatte des Jahres)''";
                case "??rets gruppe" -> "??rets Gruppe<br />''(Gruppe des Jahres)''";
                case "??rets kvinnelige artist" -> "??rets Kvinnelige Artist<br />''(K??nstlerin des Jahres)''";
                case "??rets mannlige artist" -> "??rets Mannlige Artist<br />''(K??nstler des Jahres)''";
                case "musikkvideo" -> "Musikkvideo<br />''(Musikvideo)''";
                case "??rets seri??se plate" -> "??rets seri??se plate<br />''(Seri??se Platte des Jahres)''";
                case "??rets viseplate" -> "??rets viseplate<br />''(Weisenplatte des Jahres)''";
                case "barnemusikk" -> "Barnemusikk<br />''(Kindermusik)''";
                case "kammermusikk" -> "Kammermusikk<br />''(Kammermusik)''";
                case "orkestermusikk" -> "Orkestermusikk<br />''(Orchestermusik)''";
                case "roots-musikk" -> "Roots-musikk<br />''(Rootsmusik)''";
                case "underholdning" -> "Underholdning<br />''(Unterhaltung)''";
                case "visesang" -> "Visesang<br />''(Weisengesang)''";
                case "folkemusikk/tradisjonsmusikk" -> "Folkemusikk/Tradisjonsmusikk<br />''(Volksmusik/Traditionsmusik)''";
                case "hederspris" -> "Hederspris<br />''(Ehrenpreis)''";
                case "barneplater" -> "Barneplater<br />''(Kinderplatten)''";
                case "klassisk" -> "Klassisk<br />''(Klassisch)''";
                case "popartist" -> "Popartist<br />''(Popk??nstler)''";
                case "samtid" -> "Samtid<br />''(Zeitgen??ssisches)''";
                case "tonos komponistpris" -> "Tonos komponistpris<br />''(Tonos Komponistenpreis)''";
                case "viser" -> "Viser<br />''(Weisen)''";
                case "??pen klasse" -> "??pen Klasse<br />''(Offene Klasse)''";
                case "??rets album" -> "??rets album<br />''(Album des Jahres)''";
                case "??rets hederspris" -> "??rets Hederspris<br />''(Ehrenpreis des Jahres)''";
                case "??rets gjennombrudd & gramostipend" -> "??rets Gjennombrudd og Gramostipend<br />''(Durchbruch des Jahres und Gramostipend)''";
                case "??rets nykommer & gramostipend" -> "??rets Nykommer & Gramostipend<br />''(Newcomer des Jahres und Gramostipend)''";
                case "??rets internasjonale suksess" -> "??rets Internasjonale Suksess<br />''(Internationaler Erfolg des Jahres)''";
                case "??rets l??t" -> "??rets L??t<br />''(Lied des Jahres)''";
                case "??rets l??tskriver" -> "??rets L??tskriver<br />''(Songwriter des Jahres)''";
                case "??rets musikkvideo" -> "??rets Musikkvideo<br />''(Musikvideo des Jahres)''";
                case "??rets produsent" -> "??rets Produsent<br />''(Produzent des Jahres)''";
                case "??rets spellemann" -> "??rets Spellemann<br />''(Spellemann des Jahres)''";
                case "tekstforfatter" -> "Tekstforfatter<br />''(Textautor)''";
                case "??rets tekstforfatter" -> "??rets Tekstforfatter<br />''(Textautor des Jahres)''";
                case "??rets komponist" -> "??rets Komponist<br />''(Komponist des Jahres)''";
                case "??rets takk" -> "??rets takk<br />''(Danke des Jahres)''";
                case "klassisk musikk" -> "Klassisk musikk<br />''(klassische Musik)''";
                case "hedersprisen" -> "Hedersprisen<br />''(Ehrenpreis)''";
                case "videoprisen" -> "Videoprisen<br />''(Videopreis)''";
                case "??rets artist" -> "??rets Artist<br />''(K??nstler des Jahres)''";
                case "viser/viserock" -> "Viser/Viserock<br />''(Weisen/Weisenrock)''";
                case "??rets hit" -> "??rets Hit<br />''(Hit des Jahres)''";
                case "??rets nykommer" -> "??rets Nykommer<br />''(Newcomer des Jahres)''";
                case "samtidsmusikk" -> "Samtidsmusikk<br />''(zeitgen??ssische Musik)''";
                case "bransjepris" -> "Bransjepris<br />''(Branchenpreis)''";
                case "mannlig artist" -> "Mannlig Artist<br />''(K??nstler)''";
                case "kvinnelig artist" -> "Kvinnelig Artist<br />''(K??nstlerin)''";
                case "folkemusikk/gammaldans" -> "Folkemusikk/Gammaldans<br />''(Volksmusik/Gammaldans)''";
                case "danseorkester" -> "Danseorkester<br />''(Tanzorchester)''";
                default -> nominationCategory;
            };
        }

        /**
         * Returns the information of the nominee for the table of nominees.
         *
         * @return the line
         */
        public String getNomineeEntry() {
            String titleForTable = title.equals("") ? "" : ": ''" + title + "''";

            return "* [[" + name + "]]" + titleForTable;
        }

        /**
         * Returns the table line for the winner table for a certain winner.
         *
         * @return the table syntax
         */
        public String getTableEntry() {
            String titleForTable = title.equals("") ? "???" : "''" + title + "''";

            return "|-\n" +
                    "|" + getCategoryForTable() + "\n" +
                    "|[[" + name + "]]\n" +
                    "|" + titleForTable + "\n";
        }


        @Override
        public String toString() {
            return nominationCategory + " - " + name + ": " + title + "\n";
        }

        @Override
        public int compareTo(Entry o) {
            String thisName = nominationCategory.toLowerCase().replaceAll("??", "z");
            String othername = o.nominationCategory.toLowerCase().replaceAll("??", "z");

            return thisName.compareTo(othername);
        }
    }
}
