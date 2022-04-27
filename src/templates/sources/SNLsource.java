package templates.sources;

import templates.Weblinks;

/**
 * Used to generate weblinks and reference code for SNL (=Store norske leksikon) articles.
 */
public class SNLsource {

    /**
     * Returns the weblink and references section with the category for Wiki Commons and the SNL weblink.
     *
     * @param snlName the name of the snl article
     * @return the weblink section
     */
    public static String getWeblinksCommonsSNLReferences(String snlName) {
        return Weblinks.getWeblinksWithCommonscat() + "\n" +
                getSNL(snlName) +
                "\n\n" + Weblinks.getReferencesSection();
    }

    /**
     * A reference for a SNL article about a person.
     *
     * @param firstNames the first names of the person
     * @param lastName the last name of the person
     * @return the source
     */
    public static String getSNLPerson(String firstNames, String lastName) {
        String urlFirstNames = firstNames.replaceAll(" ", "_");
        String urlName = urlFirstNames + "_" + lastName;
        String fullName = firstNames + " " + lastName;

        return getSNL(urlName, fullName);
    }

    /**
     * A weblink for a SNL article.
     *
     * @param urlName the last part of the url
     * @param articleName the name of the article
     * @return the weblink
     */
    public static String getSNL(String urlName, String articleName) {
        return "* [https://snl.no/" + urlName + " " + articleName + "] im [[Store norske leksikon]] (norwegisch)";
    }

    /**
     * A weblink for a SNL article.
     *
     * @param name the name of the article
     * @return the weblink
     */
    public static String getSNL(String name) {
        return "* [https://snl.no/" + createSNLURL(name) + " " + name + "] im [[Store norske leksikon]] (norwegisch)";
    }

    /**
     * Turns the name of a SNL article into the correct url name.
     *
     * @param name the name
     * @return the url name
     */
    private static String createSNLURL(String name) {
        return name.replaceAll(" ", "_");
    }

    /**
     * Returns the url to a SNL article based on the article's name.
     *
     * @param name the name
     * @return the url
     */
    public static String getSNLURL(String name) {
        return "https://snl.no/" + createSNLURL(name);
    }

    /**
     * Returns the ref tag for the reference.
     *
     * @return the ref tag
     */
    public static String getSNLRefTag() {
        return "<ref name=\"snl\" />";
    }

    /**
     * Returns the reference based on the article's name.
     *
     * @param name the name of the article
     * @return the reference
     */
    public static String getSNLRef(String name) {
        return "<ref name=\"snl\">{{Internetquelle |autor= |url=" + SNLsource.getSNLURL(name) + " |titel=" + name + " |abruf=" + Weblinks.getTodaysDate() + " |werk=Store norske leksikon |sprache=no}}</ref>";
    }

}
