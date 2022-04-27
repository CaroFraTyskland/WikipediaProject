package templates.sources;

public class RegjeringSource {

    private static final String werk = "regjeringen.no";
    private static final String baseURL = "regjeringen.no/no/";
    private static final String language = "no";

    /**
     * A reference for the municipalities that have Sámi as an official language.
     *
     * @return the reference
     */
    public static String getSamiSource() {
        return Websource.buildSource(null, baseURL + "tema/urfolk-og-minoriteter/samepolitikk/samiske-sprak/samelovens-sprakregler-og-forvaltningsom/id633281/", "Samelovens språkregler og forvaltningsområdet for samisk språk", werk, null, "2020-01-28", language);
    }

    /**
     * A reference for the regional reform of 2018-20 in Norway.
     *
     * @return the reference
     */
    public static String getRegionreformSource() {
        return Websource.buildSource("Kommunal- og moderniseringsdepartementet", baseURL + "aktuelt/nye-kommune--og-fylkesnummer-fra-2020/id2576659/", "Nye kommune- og fylkesnummer fra 2020", werk, null, "2017-10-27", language);
    }

    /**
     * The reference for a minister with a given id.
     *
     * @param id the politician's id
     * @return the reference
     */
    public static String getMinisterSource(String id) {
        return Websource.buildSource(null, baseURL + "om-regjeringa/tidligere-regjeringer-og-historie/sok-i-regjeringer-siden-1814/regjeringspolitiker/id2578016/?personId=PERSON_" + id, "", werk, null, null, language);
    }

}
