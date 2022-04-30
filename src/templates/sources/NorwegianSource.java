package templates.sources;

import templates.Weblinks;

public class NorwegianSource {

    private static final String LANG_NORWEGIAN = "no";
    private static final String LANG_NYNORSK = "nn";
    private static final String LANG_BOKMAAL = "nb";
    private static final String LANG_ENGLISH = "en";

    private static final String hrsgAVINOR = "Avinor";
    private static final String hrsgBANENOR = "Bane NOR";
    private static final String hrsgSprakradet = "Språkrådet";

    private static final String werkeKirkesok = "Kirkesøk";

    private static final String baseURLavinor = "avinor.no";
    private static final String baseURLkirkesok = "kirkesok.no/kirke/";


    public static String getBaneNORSource() {
        return Websource.buildSource(null, "", "", null, hrsgBANENOR, null, LANG_NORWEGIAN);
    }

    public static String getStadnamnSource(String name) {
        return "<ref>{{Internetquelle |url=http://www.norskstadnamnleksikon.no/?deeplink= |titel=" + name + " |abruf=" + Weblinks.getTodaysDate() + " |werk=Norsk stadnamnleksikon |sprache=no}}</ref>";
    }

    public static String getAvinorSource(String link, String name) {
        String url = baseURLavinor + "/en/airport/" + link;

        return Websource.buildSource(null, url, name, null, hrsgAVINOR, null, "en");
    }

    /**
     * Link to the info page for airports.
     *
     * @param airportID id of the airport (from the url)
     * @param name      website title / name of the airport
     * @return the reference
     */
    public static String getAvinorAiportInfoSource(String airportID, String name) {
        String url = baseURLavinor + "/avinors-flyplasser/" + airportID + "/";

        return Websource.buildSource(null, url, name, null, hrsgAVINOR, null, LANG_NORWEGIAN);
    }

    public static String getCitizenSprakradetSource() {
        return "<ref>{{Internetquelle |url=https://www.sprakradet.no/sprakhjelp/Skriverad/navn-pa-steder-og-personer/Innbyggjarnamn/ |titel=Innbyggjarnamn |hrsg=" + hrsgSprakradet + " |abruf=" + Weblinks.getTodaysDate() + " |sprache=" + LANG_NYNORSK + "}}</ref>";
    }

    public static String getKirkesokSource(int id, String name) {
        return Websource.buildSource(null, baseURLkirkesok + id, name, werkeKirkesok, null, null, LANG_NORWEGIAN);
    }

}
