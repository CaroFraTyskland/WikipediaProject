package templates.sources;

import templates.Weblinks;

public class Websource {

    public static String buildSource(String author, String url, String title, String werk, String hrsg, String date, String lang) {
        return buildSourceWithRefName(null, author, url, title, werk, hrsg, date, lang);
    }

    public static String buildSourceWithRefName(String refName, String author, String url, String title, String werk, String hrsg, String date, String lang) {
        String ref = "<ref";
        if (refName != null) {
            ref += " name=\"" + refName + "\"";
        }

        ref += ">{{Internetquelle";

        if (author != null) {
            ref += " |autor=" + author;
        }

        ref += " |url=https://www." + url + " |titel=" + title + " |abruf=" + Weblinks.getTodaysDate();

        if (werk != null) {
            ref += " |werk=" + werk;
        }

        if (hrsg != null) {
            ref += " |hrsg=" + hrsg;
        }

        if (date != null) {
            ref += " |datum=" + date;
        }

        ref += " |sprache=" + lang + "}}</ref>";

        return ref;
    }

    /**
     * Gets the short version of a reference with a given name.
     *
     * @param name the name of the reference
     * @return the reference
     */
    public static String getRefName(String name) {
        return "<ref name=\"" + name + "\" />";
    }
}
