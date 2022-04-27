package templates.sources;

import templates.Categories;
import templates.Weblinks;

public class SSBsource {

    /**
     * Returns the reference for the population/area statistics for the tettsteder of 2019.
     *
     * @return the reference
     */
    public static String befTettSource2019() {
        return "<ref>{{Internetquelle |url=https://www.ssb.no/befolkning/statistikker/beftett/aar/2019-11-04?fane=tabell&sort=nummer&tabell=407816 |titel=Tettsteders befolkning og areal, 1. januar 2019 |hrsg=Statistisk sentralbyrå |datum=2019-12-04 |abruf=" + Weblinks.getTodaysDate() + " |sprache=no}}</ref>";
    }

    /**
     * Returns the reference for the population/area statistics for the tettsteder.
     *
     * @return the reference
     */
    public static String befTettSource() {
        return "<ref>{{Internetquelle |url=https://www.ssb.no/en/befolkning/folketall/statistikk/tettsteders-befolkning-og-areal |titel=Population and land area in urban settlements, 1 January 2020 |hrsg=Statistisk sentralbyrå |datum=2020-10-06 |abruf=" + Weblinks.getTodaysDate() + " |sprache=en}}</ref>";
    }

    /**
     * Returns the link for the SSB fact sheet for a given municipality.
     *
     * @param municipality the name of the municipality
     * @return the link
     */
    public static String getSSBMunicipalityWeblink(String municipality) {
        String lowerCaseName = Categories.replaceLetters(municipality.toLowerCase()).replaceAll(" ", "-");

        return "* [https://www.ssb.no/kommunefakta/" + lowerCaseName + " Fakten über " + municipality + "] beim [[Statistisk sentralbyrå]] (norwegisch)";
    }

    /**
     * Returns the reference for the 1999 SSB report about the changes in municipalities and provinces.
     *
     * @return the reference
     */
    public static String getKommuneHistorieSource() {
        return "<ref>{{Internetquelle |autor=Dag Juvkam |url=https://www.ssb.no/a/histstat/rapp/rapp_199913.pdf |titel=Historisk oversikt over endringer i kommune- og fylkesinndelingen |werk=Statistisk sentralbyrå |datum=1999 |abruf=" + Weblinks.getTodaysDate() + " |format=PDF |sprache=no}}</ref>";
    }


    /**
     * Returns the reference for the commuters.
     *
     * @return the reference
     */
    public static String pendlingSource() {
        return "<ref>{{Internetquelle |url=https://statisticsnorway.shinyapps.io/pendling/ |titel=Pendlingsstrømmer |hrsg=Statistics Norway |abruf=" + Weblinks.getTodaysDate() + " |sprache=no}}</ref>";
    }

    /**
     * Returns the reference for the areal types.
     * until 2022-02-22: https://www.ssb.no/statbank/sq/10062710
     *
     * @return the reference
     */
    public static String getAreaTypeSource() {
        return "<ref>{{Internetquelle |url=https://www.ssb.no/statbank/sq/10064050 |titel=09280: Areal (km²), etter arealtype, statistikkvariabel, år og region |abruf=" + Weblinks.getTodaysDate() + " |werk=Statistisk sentralbyrå |sprache=no}}</ref>";
    }

}
