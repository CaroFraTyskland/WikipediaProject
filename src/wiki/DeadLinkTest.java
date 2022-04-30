package wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//03.03.22: completed

public class DeadLinkTest {

    private final static String alreadyTested = "";


    public static void testArticle() {
        ArrayList<String> articles = new ArrayList<>();

        System.out.print(">> article: ");
        Scanner scanner = new Scanner(System.in);
        String articleName = scanner.nextLine();

        articles.add(articleName);

        testArticles(articles);
    }

    public static void testArticles(ArrayList<String> articles) {
        testArticles(articles, "-");
    }

    public static void testArticles(ArrayList<String> articles, String startArticle) {
        boolean start = startArticle.equals("-");

        startArticle = startArticle.replaceAll(" ", "_");


        for (String article : articles) {
            article = article.replaceAll(" ", "_");


            if (article.equals(startArticle)) {
                start = true;
            }

            if (!alreadyTested.contains(article) && start) {
                System.out.println(article);

                article = URLEncoder.encode(article);

                String urlString = "https://de.wikipedia.org/w/api.php?action=query&prop=revisions&titles=" + article + "&rvslots=%2A&rvprop=content&format=json";

                ArrayList<String> urls = getUrls(urlString);

                if (urls != null) {

                    for (String url : urls) {
                        url = WrittenArticles.replaceUnicode(url);

                        if (!check(url)) {
                            System.out.println(url + " : " + "<ref>{{Webarchiv |url=" + url + " |text= |wayback=}} In: . ()</ref>");
                        }
                    }
                }


                System.out.println();
            }

        }
    }

    public static void testMyArticles() {
        System.out.print(">> first article: ");
        Scanner scanner = new Scanner(System.in);
        String articleName = scanner.nextLine();

        testMyArticles(articleName);
    }

    public static void testMyArticles(String firstArticle) {
        ArrayList<String> articles = WrittenArticles.getArticles("CaroFraTyskland", true);
        testArticles(articles, firstArticle);
    }

    public static void main(String[] args) {
        //testArticle("Camilla Stoltenberg");
        ArrayList<String> articles = WrittenArticles.getArticles("CaroFraTyskland", true);


        //ArrayList<String> articles = new ArrayList<String>();
        //articles.add("Wikipedia:WikiProjekt_Norwegen/Recherche");

        testArticles(articles);
    }


    private static ArrayList<String> getUrls(String urlString) {
        String text;

        try {
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            text = br.readLine();

            conn.disconnect();
        } catch (IOException e) {
            System.out.println("IO Exception");
            return null;
        }

        return extractURLs(text);
    }


    /**
     * Takes the wiki code of an projects.general.article and looks for the urls within it.
     *
     * @param wikiCode the wiki code
     * @return the list of urls
     */
    private static ArrayList<String> extractURLs(String wikiCode) {
        ArrayList<String> list = new ArrayList<>();

        String copy = wikiCode;

        while (copy.contains("{{Internetquelle")) {
            int startIndex = copy.indexOf("{{Internetquelle") + 2;

            int endIndex = -1;
            while (endIndex < startIndex) {
                endIndex = copy.indexOf("}}");
                copy = copy.replaceFirst("}}", "");
            }

            String source = copy.substring(startIndex, endIndex);

            if (source.contains("archiv-url")) {
                wikiCode = wikiCode.substring(0, wikiCode.indexOf(source)) + wikiCode.substring(wikiCode.indexOf(source) + source.length());
            }

            copy = copy.replaceFirst("\\{\\{Internetquelle", "");

        }


        //ignoring web archive links
        wikiCode = wikiCode.replaceAll("/htt", " ");
        wikiCode = wikiCode.replaceAll("Webarchiv \\|url=htt", "");


        /*
            Goes through the text looking for https or http
         */
        while (wikiCode.contains("https://") || wikiCode.contains("http://")) {
            String nextURL = getNextURL(wikiCode);
            list.add(nextURL);

            wikiCode = wikiCode.substring(wikiCode.indexOf("http") + 10);
        }

        return list;
    }

    /**
     * Takes the wiki code and extracts the first url within it.
     *
     * @param wikiCode the code
     * @return the url
     */
    private static String getNextURL(String wikiCode) {
        int indexStart = 0;

        Pattern p = Pattern.compile("https?://");
        Matcher m = p.matcher(wikiCode);

        if (m.find()) {
            indexStart = m.start();
        }

        wikiCode = wikiCode.substring(indexStart);

        //checking if the url ends at }} or with an empty space
        int indexEnd = Math.min(wikiCode.indexOf(" "), wikiCode.indexOf("}}"));

        return wikiCode.substring(0, indexEnd);
    }


    /**
     * Checks the response for a given url.
     *
     * @param urlString the url
     * @return whether or not the url was ok
     */
    private static boolean check(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();

            int responseCode = huc.getResponseCode();

            return (responseCode == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            return false;
        }
    }
}