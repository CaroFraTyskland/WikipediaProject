package politics.Storting;

import politics.StortingAPI.StortingMemberListData;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StortingList {

    public static void main(String[] args) {
        writeList();
    }

    private static void writeList() {
        /*
            Get the list of MPs and sort them.
         */
        List<StortingMemberListData> list = StortingMemberLists.getList();

        if (list == null) {
            System.out.println("List of representants was null.");
            return;
        }

        Collections.sort(list);


        String firstParagraphs = "[[Datei:Storting Spring 2016.JPG|alt=Parlamentsgebäude in Oslo (2016)|mini|Parlamentsgebäude in Oslo (2016)]]\n" +
                "Diese Liste gibt einen Überblick über alle '''Mitglieder des [[Storting|Stortings]]'''," +
                " dem [[Norwegen|norwegischen]] Nationalparlament, die bei der [[Parlamentswahl in Norwegen 2013|Parlamentswahl 2013]] gewählt wurden. " +
                "Die [[Legislaturperiode]] dauerte bis Herbst 2017 an. Dem Parlament gehörten 169 Personen an.\n\n" +
                "== Zusammensetzung ==\n" +
                "Nach der Parlamentswahl vom xx.xx.xxxx setzte sich das Repräsentantenhaus wie folgt zusammen:\n" +
                "{| class=\"wikitable sortable\"\n" +
                "|-\n" +
                "! Fraktion\n" +
                "! Sitze\n" +
                "|-\n" +
                "| [[Arbeiderpartiet|Ap]]\n" +
                "| \n" +
                "|-\n" +
                "| [[Høyre]]\n" +
                "| \n" +
                "|-\n" +
                "| [[Fremskrittspartiet|FrP]]\n" +
                "| \n" +
                "|-\n" +
                "| [[Kristelig Folkeparti|KrF]]\n" +
                "| \n" +
                "|-\n" +
                "| [[Senterpartiet|Sp]]\n" +
                "| \n" +
                "|-\n" +
                "| [[Venstre (Norwegen)|Venstre]]\n" +
                "| {{0}}\n" +
                "|-\n" +
                "| [[Sosialistisk Venstreparti|SV]]\n" +
                "| {{0}}\n" +
                "|-\n" +
                "| [[Miljøpartiet De Grønne|MDG]]\n" +
                "| {{0}}\n" +
                "|-\n" +
                "! gesamt\n" +
                "! 169\n" +
                "|}";

        StringBuilder text = new StringBuilder("\n\n" +
                "== Abgeordnete ==\n" +
                "Dies ist die Liste aller direkt in das Parlament eingezogenen Personen. Mitglieder der Regierung etwa müssen ihr Mandat ruhen lassen und werden durch sogenannte [[Vararepresentant]]en, also nicht direkt ins Parlament eingezogene Parteikollegen aus dem gleichen Wahlkreis, vertreten.\n" +
                "\n" +
                "{{TOC}}\n" +
                "\n" +
                "{| class=\"wikitable sortable\"\n" +
                "|-\n" +
                "! Nr.\n" +
                "! Bild\n" +
                "! Name\n" +
                "! Geburtsjahr\n" +
                "! Fraktion\n" +
                "! Wahlkreis\n" +
                "! Vertretung\n" +
                "!class=\"unsortable\"| Bemerkungen");


        Map<String, String> pictureList = PersonToPicture.getPictureList();


        for (StortingMemberListData data : list) {
            text.append("\n" + "|-\n" + "| ");
            text.append(data.getRepresentantNumber()).append("\n");

            String personText = "{{PersonZelle|" + data.getFirstName() + "|" + data.getLastName() + "}}";
            String pictureText = "[[Datei:Placeholder staff photo.svg|120px]]";

            if (pictureList.containsKey(personText)) {
                pictureText = pictureList.get(personText);
            }

            text.append("| ").append(pictureText);
            text.append("\n| ").append(personText).append("\n").append("| ").append(data.getBirthYear()).append("\n");

            if (data.getParty() != null) {
                text.append("| style=\"border-left:5px solid #{{Wahldiagramm/Partei|").append(data.getParty().getAbbreviation()).append("|dunkel|NO}};\"| ").append(data.getParty().getAbbreviation()).append("\n");
            } else {
                text.append("| style=\"border-left:5px solid #{{Wahldiagramm/Partei|").append("|dunkel|NO}};\"| \n");
            }

            text.append("| ").append(data.getConstituency().getName()).append("\n").append("| \n").append("|");
        }

        System.out.println(firstParagraphs + text.toString() + "\n|}");
    }

}
