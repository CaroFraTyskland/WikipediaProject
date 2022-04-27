package politics.StortingAPI;

import basics.norway.Constituency;
import basics.norway.Party;
import templates.Categories;

/**
 * Information of a member of Storting needed for the list of members of a certain period.
 */
public class StortingMemberListData implements Comparable<StortingMemberListData> {

    private String lastName;
    private String firstName;
    private String birthYear;
    private int representantNumber;
    private Constituency constituency;
    private Party party;

    public int getRepresentantNumber() {
        return representantNumber;
    }

    public void setRepresentantNumber(int representantNumber) {
        this.representantNumber = representantNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public Constituency getConstituency() {
        return constituency;
    }

    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "StortingRepData{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthYear=" + birthYear +
                ", number=" + representantNumber +
                ", constituency=" + constituency +
                ", party=" + party +
                '}';
    }

    /**
     * Returns the entry for the list of the person.
     *
     * @return the entry
     */
    public String getListEntry() {
        return "|-\n" +
                "| \n" +
                "| {{SortKey|" + Categories.defaultSortText(lastName) + ", " + Categories.defaultSortText(firstName) + "}}[[" + firstName + " " + lastName + "]]\n" +
                "| " + birthYear + "\n" +
                "| style=\"border-left:5px solid #{{Wahldiagramm/Partei|" + party.getAbbreviation() + "|dunkel|NO}};\"| " + party.getAbbreviationList() + "\n" +
                "| [[" + constituency.getConstituencyLink() + "]]\n" +
                "| \n" +
                "| ";
    }

    /**
     * Returns the full name of the person.
     *
     * @return the name
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(StortingMemberListData o) {
        return lastName.compareTo(o.getLastName());
    }
}
