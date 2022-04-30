package places.municipalities.population;

import templates.Weblinks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class PopulationOverTime {

    private static final String text = getTextFromWebsite();

    public static void main(String[] args) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            int input = scanner.nextInt();

            if (input == 0) {
                quit = true;
            } else {
                System.out.println(getPopulationTable(input) + "\n");
            }
        }
    }


    private static String getTextFromWebsite() {
        try {
            URL url = new URL("https://data.ssb.no/api/v0/dataset/26975.csv?lang=en");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String line;
            StringBuilder text = new StringBuilder();

            while ((line = br.readLine()) != null) {
                text.append("\n").append(line);
            }


            return text.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getPopulationTable(int municipalityNumber) {
        return getPopulationTable(String.valueOf(municipalityNumber));
    }

    public static String getPopulationTable(String municipalityNumber) {
        String cutText = cutToMunicipality(text, "K-" + municipalityNumber);

        ArrayList<PopulationYear> list = getList(cutText);
        ArrayList<PopulationYear> cutlist = cutList(list);

        return listToText(cutlist);
    }

    /**
     * Returns the important section of the given text, being only the information about a certain municipality.
     *
     * @param text               the website text
     * @param municipalityNumber the number
     * @return the info about the municipality
     */
    private static String cutToMunicipality(String text, String municipalityNumber) {
        int startIndex = text.indexOf(municipalityNumber);
        text = text.substring(startIndex);

        StringBuilder municipalityText = new StringBuilder();

        String line = text.substring(0, text.indexOf("\n"));

        while (line.contains(municipalityNumber)) {
            municipalityText.append(text, 0, text.indexOf("\n"));
            municipalityText.append("\n");

            text = text.substring(text.indexOf("\n") + 1);
            line = text.substring(0, text.indexOf("\n"));
        }

        return municipalityText.toString();
    }

    /**
     * Returns a list of entries extracted from the given text.
     *
     * @param text the text
     * @return list of entries
     */
    private static ArrayList<PopulationYear> getList(String text) {
        ArrayList<PopulationYear> list = new ArrayList<>();

        while (text.length() != 0) {
            int indexStart = text.indexOf("\",\"") + 3;
            int indexEnd = text.indexOf("\",\"Persons");

            String year = text.substring(indexStart, indexEnd);

            indexStart = text.indexOf("\",\"Persons") + 12;
            indexEnd = text.indexOf("\n");

            String population = text.substring(indexStart, indexEnd);

            list.add(new PopulationYear(year, population));

            text = text.substring(indexEnd + 1);
        }

        return list;
    }

    /**
     * Takes a list of entries and only returns a certain part of them.
     *
     * @param list the list
     * @return the modified list
     */
    private static ArrayList<PopulationYear> cutList(ArrayList<PopulationYear> list) {
        ArrayList<PopulationYear> newList = new ArrayList<>();

        for (PopulationYear year : list) {
            int yearNumber = year.getYearNumber();
            if (yearNumber == 1986 || yearNumber % 5 == 0) {
                newList.add(year);
            }
        }

        return newList;
    }

    /**
     * Creates the wiki text for the table of entries in the list.
     *
     * @param list list of municipalities
     * @return the wiki syntax
     */
    private static String listToText(ArrayList<PopulationYear> list) {
        StringBuilder text = new StringBuilder("{| class=\"wikitable\"\n! Jahr");

        for (PopulationYear year : list) {
            text.append(" !! ").append(year.getYear());
        }

        text.append("\n|-\n");
        text.append("| '''Einwohnerzahl'''<ref>{{Internetquelle |url=https://data.ssb.no/api/v0/dataset/26975.csv?lang=en |titel=Population. Municipalities, pr. 1.1., 1986 - latest year |abruf=").append(Weblinks.getTodaysDate()).append(" |werk=ssb.no |sprache=en}}</ref>");


        for (PopulationYear year : list) {
            text.append(" || ").append(year.getPopulation());
        }

        text.append("\n|}");

        return text.toString();
    }


    private static void listToDiagram(ArrayList<PopulationYear> list) {
        System.out.println("<div class=\"hintergrundfarbe1\" style=\"border:1px solid darkgray; float:left; margin:0.5em 2em 1em 0; padding:5px; text-align:center;\">\n" +
                "'''Bevölkerungsentwicklung'''<ref>{{Internetquelle |url=https://data.ssb.no/api/v0/dataset/26975.csv?lang=en |titel=Population. Municipalities, pr. 1.1., 1986 - latest year |abruf=" + Weblinks.getTodaysDate() + " |werk=ssb.no |sprache=en}}</ref>");

        System.out.println("{{Graph:Chart|width=1000|height=150|type=rect");
        System.out.print("|x=");
        System.out.print(list.get(0).getYear());

        for (int i = 1; i < list.size(); i++) {
            System.out.print(", ’" + list.get(i).getYear().substring(2));
        }

        System.out.print("\n|y=");

        System.out.print(list.get(0).getPopulation());

        for (int i = 1; i < list.size(); i++) {
            System.out.print("," + list.get(i).getPopulation());
        }
        System.out.print("|showValues=}}\n</div>");
    }


    /**
     * Stores a combination of year and population.
     */
    private static class PopulationYear {
        String year;
        String population;

        PopulationYear(String year, String population) {
            this.population = population;
            this.year = year;
        }

        public String getYear() {
            return year;
        }

        public int getYearNumber() {
            return Integer.parseInt(year);
        }

        public String getPopulation() {
            return population;
        }
    }

}