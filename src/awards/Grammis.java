package awards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Prints all nominees of the Swedish music award Grammis onto the console. The output can be used as a CSV file.
 * Can be used to find out whether a certain artist has ever been nominated in a certain time span.
 */
public class Grammis {

    private final static int START = 2021;
    private final static int END = 2022;

    public static void main(String[] args) {
        for (int i = START; i <= END; i++) {
            //up to three pages
            for (int j = 1; j < 4; j++) {
                getHTML("" + i, j);
            }
        }
    }

    private static void getHTML(String year, int page) {
        BufferedReader reader;
        StringBuilder builder = new StringBuilder();

        try {
            String urlText = "https://grammis.se/nominated_year/" + year + "/";

            if (page > 1) {
                urlText = "https://grammis.se/nominated_year/" + year + "/page/" + page + "/";
            }

            URL url = new URL(urlText);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));


            String line;

            while ((line = reader.readLine()) != null) {

                builder.append(line);
            }
        } catch (IOException e) {
            return;
        }

        String html = builder.toString();
        printCSV(html);
    }

    private static void printCSV(String html) {
        int indexStart = html.indexOf("<div class=\"u-block\">");
        int indexEnd = html.indexOf("</main");

        html = html.substring(indexStart, indexEnd);
        html = html.replaceAll("<article", "\n<article>");

        String[] categoryParts = html.split("\n");

        for (String categoryPart : categoryParts) {
            printCategory(categoryPart);
        }
    }

    private static void printCategory(String part) {
        if (part.contains("<li>")) {
            String category = part.substring(part.indexOf("<h2 class=\"u-flush--bottom\">") + 30, part.indexOf("</h2>")).trim();

            String[] nominees = part.split("</li>");

            if (part.contains("<ul ")) {
                nominees = part.split("</ul>");
            }

            for (String nominee : nominees) {
                printNominee(category, nominee);
            }
        }
    }

    private static void printNominee(String category, String nominee) {
        if (nominee.contains("<li>")) {
            try {
                String singer = nominee.substring(nominee.indexOf("<li>") + 4, nominee.indexOf("</li>")).trim();

                if (!singer.isEmpty()) {
                    System.out.println(category.toLowerCase() + ";" + singer.toLowerCase());
                }
            } catch (Exception ignored){

            }
        }
    }
}
