package templates.sources;

import templates.Weblinks;

public class Lovdata {

    private final static String OFFICIAL_LANGUAGE_URL = "https://lovdata.no/dokument/SF/forskrift/2019-12-20-2114";

    public static String getLanguageSource() {
        return writeLovdataSource(OFFICIAL_LANGUAGE_URL, "Forskrift om målvedtak i kommunar og fylkeskommunar (målvedtaksforskrifta)", "2020-01-06");
    }

    /**
     * Returns the reference for a lovdata page.
     *
     * @param url  the url
     * @param name the name of the law
     * @param date the date the law was published
     * @return the reference
     */
    public static String writeLovdataSource(String url, String name, String date) {
        return "<ref>{{Internetquelle |url=" + url + " |titel=" + name + " |werk=Lovdata |datum=" + date + " |abruf=" + Weblinks.getTodaysDate() + " |sprache=no}}</ref>";
    }

}