package templates.sources;

import politics.StortingAPI.StortingMember;
import politics.StortingAPI.StortingMemberInfo;
import templates.Weblinks;

public class StortingSource {

    private static final String STORTING_LINK_NO =
            "https://www.stortinget.no/no/Representanter-og-komiteer/Representantene/Representant/?perid=";
    private static final String STORTING_LINK_EN =
            "https://www.stortinget.no/en/In-English/Members-of-the-Storting/current-members-of-parliament/representative/?perid=";

    /**
     * Returns the weblink for a given politician.
     *
     * @param id   the id of the politician
     * @param name the politician's name
     * @return the link
     */
    public static String getStortingWeblink(String id, String name) {
        id = id.toUpperCase();

        return "* [" + STORTING_LINK_NO + id + " " + name + "] beim [[Storting]] " +
                "(norwegisch, [" + STORTING_LINK_EN + id + " englisch])";
    }

    /**
     * Returns the Storting reference for a given Storting id.
     *
     * @param id the id
     * @return the reference
     */
    public static String getStortingReferencesById(String id) {
        StortingMember data = StortingMemberInfo.getDataByID(id);

        if (data != null) {
            return getStortingReference(id, data.getLastName(), data.getFirstName());
        }

        return getEmptySource(id);
    }

    /**
     * Returns the reference for a Storting biography.
     *
     * @param id        the id
     * @param lastName  the last name
     * @param firstName the first name(s)
     * @return the reference
     */
    private static String getStortingReference(String id, String lastName, String firstName) {
        id = id.toUpperCase();

        return "<ref name=\"storting\">{{Internetquelle |url=" + STORTING_LINK_NO + id + " |titel=Biografi: " + lastName + ", " + firstName + " |werk=Stortinget |sprache=no |abruf=" + Weblinks.getTodaysDate() + "}}</ref>";
    }


    /**
     * Returns a reference without the title (useful when the politician's name is not known).
     *
     * @param id the id
     * @return the source
     */
    private static String getEmptySource(String id) {
        return getStortingReference(id.toUpperCase(), "", "");
    }
}
