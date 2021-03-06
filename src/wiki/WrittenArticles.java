package wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class WrittenArticles {

    public static void main(String[] args) {
        printArticlesOfUser("CaroFraTyskland");
    }

    /**
     * Returns a random article of the given user
     *
     * @param userName the user name
     * @return the article
     */
    public static String getRandomArticle(String userName) {
        ArrayList<String> articles = getArticles(userName, true);

        int random = (int) (Math.random() * articles.size());

        return articles.get(random).replaceAll("_", " ");
    }

    /**
     * Returns a random article of the given list.
     *
     * @param articles the articles
     * @return the article
     */
    public static String getRandomArticle(ArrayList<String> articles) {
        int random = (int) (Math.random() * articles.size());

        return articles.get(random);
    }

    /**
     * Prints the edit count of a given user.
     *
     * @param user the user's name
     */
    public static void printEditCount(String user) {
        System.out.println(user + ": " + getEditCount(user));
    }

    /**
     * Prints out a list of all pages created by a user.
     *
     * @param userName the user name
     */
    public static void printArticlesOfUser(String userName) {
        ArrayList<String> articles = getArticles(userName, true);

        for (String article : articles) {
            System.out.println(article.replaceAll("_", " "));
        }
    }

    /**
     * Reads in the code of the API with information about all pages created by a certain user.
     *
     * @param userName the user name
     * @return the code
     */
    private static String getApiCodeAllArticles(String userName) {
        userName = userName.replaceAll(" ", "+");

        try {
            URL url = new URL("https://pageviews.toolforge.org/userviews/api.php?username=" + userName + "&project=de.wikipedia.org&redirects=0&namespace=0&format=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            return br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * Returns a list of articles by a certain user.
     *
     * @param userName         the user name
     * @param withReplacements whether or not certains letter should be replaced
     * @return the list of articles
     */
    public static ArrayList<String> getArticles(String userName, boolean withReplacements) {
        ArrayList<String> articles = new ArrayList<>();
        String text = getApiCodeAllArticles(userName);

        while (text.contains("title")) {
            int sub1 = text.indexOf("title\":") + 8;
            int sub2 = text.indexOf("\",\"timestamp\"");

            String articleName = text.substring(sub1, sub2);

            if (withReplacements) {
                articleName = replaceUnicode(articleName);
            }

            articles.add(articleName);

            int next = text.indexOf("}") + 1;
            text = text.substring(next);
        }

        return articles;
    }

    public static String replaceUnicode(String text) {
        text = text.replaceAll("\\\\u00e5", "??");
        text = text.replaceAll("\\\\u00f8", "??");
        text = text.replaceAll("\\\\u00f6", "??");
        text = text.replaceAll("\\\\u00e4", "??");
        text = text.replaceAll("\\\\u00e6", "??");
        text = text.replaceAll("\\\\u00c5", "??");
        text = text.replaceAll("\\\\u00d8", "??");
        text = text.replaceAll("\\\\u00e1", "??");
        text = text.replaceAll("\\\\u00c1", "??");
        text = text.replaceAll("\\\\u0161", "??");
        text = text.replaceAll("\\\\u00e9", "??");
        text = text.replaceAll("\\\\u2013", "???");
        text = text.replaceAll("\\\\u00fc", "??");
        text = text.replaceAll("\\\\u00f3", "??");
        text = text.replaceAll("\\\\u00df", "??");
        text = text.replaceAll("\\\\u00c4", "??");
        text = text.replaceAll("\\\\u0113", "??");
        text = text.replaceAll("\\\\u014d", "??");
        text = text.replaceAll("\\\\u2019", "???");
        text = text.replaceAll("\\\\u1e6d", "???");
        text = text.replaceAll("\\\\u2026", "???");
        text = text.replaceAll("\\\\u00d6", "??");
        text = text.replaceAll("\\\\u1e24", "??");
        text = text.replaceAll("\\\\u012b", "???");
        text = text.replaceAll("\\\\u0101", "??");
        text = text.replaceAll("\\\\u014d", "??");
        text = text.replaceAll("\\\\u0131", "??");
        text = text.replaceAll("\\\\u00e7", "??");
        text = text.replaceAll("\\\\u015a", "??");
        text = text.replaceAll("\\\\u0119", "??");
        text = text.replaceAll("\\\\u011f", "??");
        text = text.replaceAll("\\\\u0160", "??");
        text = text.replaceAll("\\\\u1e2b", "???");
        text = text.replaceAll("\\\\u0107", "??");
        text = text.replaceAll("\\\\u0151", "??");
        text = text.replaceAll("\\\\u0130", "??");
        text = text.replaceAll("\\\\u015f", "??");
        text = text.replaceAll("\\\\u00eb", "??");
        text = text.replaceAll("\\\\u00dc", "??");
        text = text.replaceAll("\\\\u0146", "??");
        text = text.replaceAll("\\\\u010d", "??");
        text = text.replaceAll("\\\\u00e3", "??");
        text = text.replaceAll("\\\\u00ed", "??");
        text = text.replaceAll("\\\\u0159", "??");
        text = text.replaceAll("\\\\u011b", "??");
        text = text.replaceAll("\\\\u0142", "??");
        text = text.replaceAll("\\\\u017e", "??");
        text = text.replaceAll("\\\\u00e8", "??");
        text = text.replaceAll("\\\\u0141", "??");
        text = text.replaceAll("\\\\u017c", "??");
        text = text.replaceAll("\\\\u00c9", "??");
        text = text.replaceAll("\\\\u016b", "??");
        text = text.replaceAll("\\\\u00fa", "??");
        text = text.replaceAll("\\\\u0144", "??");
        text = text.replaceAll("\\\\u014c", "??");
        text = text.replaceAll("\\\\u201c", "???");
        text = text.replaceAll("\\\\u201e", "???");
        text = text.replaceAll("\\\\u0117", "??");
        text = text.replaceAll("\\\\u017d", "??");
        text = text.replaceAll("\\\\u015b", "??");
        text = text.replaceAll("\\\\u017a", "??");
        text = text.replaceAll("\\\\u0148", "??");
        text = text.replaceAll("\\\\u00ef", "??");
        text = text.replaceAll("\\\\u00fd", "??");
        text = text.replaceAll("\\\\u0103", "??");
        text = text.replaceAll("\\\\u02bf", "??");
        text = text.replaceAll("\\\\u1e33", "???");
        text = text.replaceAll("\\\\u010c", "??");
        text = text.replaceAll("\\\\u00e2", "??");
        text = text.replaceAll("\\\\u021a", "??");
        text = text.replaceAll("\\\\u021b", "??");
        text = text.replaceAll("\\\\u0218", "??");
        text = text.replaceAll("\\\\u0137", "??");
        text = text.replaceAll("\\\\u0219", "??");
        text = text.replaceAll("\\\\u00f5", "??");
        text = text.replaceAll("\\\\u00f4", "??");
        text = text.replaceAll("\\\\u00fe", "??");
        text = text.replaceAll("\\\\u0153", "??");
        text = text.replaceAll("\\\\u013d", "??");
        text = text.replaceAll("\\\\u0105", "??");
        text = text.replaceAll("\\\\u00ee", "??");
        text = text.replaceAll("\\\\u0110", "??");
        text = text.replaceAll("\\\\u0111", "??");
        text = text.replaceAll("\\\\u0106", "??");
        text = text.replaceAll("\\\\u015e", "??");
        text = text.replaceAll("\\\\u02bb", "??");
        text = text.replaceAll("\\\\u00f1", "??");
        text = text.replaceAll("\\\\u013c", "??");
        text = text.replaceAll("\\\\u016f", "??");
        text = text.replaceAll("\\\\u00e0", "??");
        text = text.replaceAll("\\\\u1ead", "???");
        text = text.replaceAll("\\\\u00c7", "??");
        text = text.replaceAll("\\\\u00d3", "??");
        text = text.replaceAll("\\\\u017b", "??");
        text = text.replaceAll("\\\\u0259", "??");
        text = text.replaceAll("\\\\u018f", "??");
        text = text.replaceAll("\\\\u00ea", "??");
        text = text.replaceAll("\\\\u00da", "??");
        text = text.replaceAll("\\\\u00cd", "??");
        text = text.replaceAll("\\\\u00b0", "??");
        text = text.replaceAll("\\\\u0136", "??");
        text = text.replaceAll("\\\\u00d7", "??");
        text = text.replaceAll("\\\\u0171", "??");


        return text;
    }

    /**
     * returns the edit count of a given user.
     *
     * @param user the user
     * @return the amount of edits
     */
    private static int getEditCount(String user) {
        //user = user.replaceAll(" ", "_");
        user = URLEncoder.encode(user);

        String text;

        try {
            URL url = new URL("https://de.wikipedia.org/w/api.php?action=query&list=users&ususers=" + user + "&usprop=groups%7Ceditcount%7Cgender&format=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            text = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        int indexLastName = text.indexOf("editcount\":") + 11;
        int indexLastName2 = text.indexOf(",\"groups");

        if (indexLastName2 < indexLastName) {
            return 0;
        }

        text = text.substring(indexLastName, indexLastName2);

        return Integer.parseInt(text);
    }
}