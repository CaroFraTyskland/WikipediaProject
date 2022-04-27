package templates.weblinks;

public class KartverketSource {

    private static final String language = "no";
    private static final String hrsg = "Kartverket";

    /**
     * Returns the faktaaark source for a certain item.
     *
     * @param itemNumber the item number
     * @param name       the name of the item
     * @return the source
     */
    public static String getFaktaarkSource(int itemNumber, String name) {
        return Websource.buildSource(null, "stadnamn.kartverket.no/fakta/" + itemNumber, "Faktaark: " + name, null, hrsg, null, language);
    }

    /**
     * Returns the source for the highest mountain list.
     *
     * @return the source
     */
    public static String getHighestMountainSource() {
        return Websource.buildSource(null, "kartverket.no/til-lands/fakta-om-norge/hoyeste-fjelltopp-i-kommunen", "Høgaste fjelltopp i kvar kommune", null, hrsg, "2022-01-06", "nn");
    }

    /**
     * Returns the source for the norgeskart without the URL.
     *
     * @param name the name of the place that is being shown
     * @return the source
     */
    public static String getNorgesKartSource(String name) {
        return Websource.buildSourceWithRefName("norgeskart", null, "", name, "Norgeskart", null, null, language);
    }
}