package templates.sources;

public class NVE {

    private static final String hrsg = "NVE";
    private static final String refNameNedbor = "nedbor";

    /**
     * Returns the reference for the "Temakart Nedbør".
     *
     * @return the reference
     */
    public static String getSourceNedbor() {
        return Websource.buildSourceWithRefName(refNameNedbor, null, "temakart.nve.no/tema/nedborfelt", "Nedbørfelt", null, hrsg, null, "no");
    }

    /**
     * The short reference for the "Temakart Nedbør".
     *
     * @return the reference
     */
    public static String getShortRefNedbor() {
        return Websource.getRefName(refNameNedbor);
    }
}