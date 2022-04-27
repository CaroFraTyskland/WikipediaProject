package templates.weblinks;

public class SNLsource {

    public static String getWeblinksCommonsSNLReferences(String snlName) {
        return Weblinks.getWeblinksWithCommonscat() + "\n" +
                getSNL(snlName) +
                "\n\n" + Weblinks.getReferencesSection();
    }

    public static String getSNLPerson(String firstNames, String lastName) {
        String urlFirstNames = firstNames.replaceAll(" ", "_");
        String urlName = urlFirstNames + "_" + lastName;
        String fullName = firstNames + " " + lastName;

        return getSNL(urlName, fullName);
    }

    public static String getSNL(String urlName, String articleName) {
        return "* [https://snl.no/" + urlName + " " + articleName + "] im [[Store norske leksikon]] (norwegisch)";
    }

    public static String getSNL(String name) {
        return "* [https://snl.no/" + createSNLURL(name) + " " + name + "] im [[Store norske leksikon]] (norwegisch)";
    }

    private static String createSNLURL(String name) {
        return name.replaceAll(" ", "_");
    }

    public static String getSNLURL(String name) {
        return "https://snl.no/" + createSNLURL(name);
    }

    public static String getSNLRefTag() {
        return "<ref name=\"snl\" />";
    }

    public static String getSNLRef(String name) {
        return "<ref name=\"snl\">{{Internetquelle |autor= |url=" + SNLsource.getSNLURL(name) + " |titel=" + name + " |abruf=" + Weblinks.getTodaysDate() + " |werk=Store norske leksikon |sprache=no}}</ref>";
    }

}
