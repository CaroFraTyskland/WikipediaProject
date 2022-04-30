package politics;

import basics.Job;
import basics.Nation;
import basics.norway.NorwegianProvince;
import basics.norway.Party;
import person.Person;
import templates.Categories;

public abstract class NorwegianPolitician extends Person {

    protected Party party;

    public NorwegianPolitician() {
        super.job = Job.POLITICIAN;
        super.nationality = Nation.NORWAY;
    }

    public Party getParty() {
        return party;
    }

    /**
     * Get the category for membership of the fykesting of the given province.
     *
     * @param province the province
     * @return the category
     */
    public String getFylkestingCategory(NorwegianProvince province) {
        return Categories.createCategory("Fylkesting-Abgeordneter (" + province.getName() + ")");
    }

    /**
     * Return the basic categories for a politican (party, nationality, birth year, gender)
     *
     * @return the text
     */
    public String getBasicCategories() {
        return Categories.createCategory(party.getMemberName()) +
                getPersonCategories();
    }

    /**
     * Takes a given party abbreviation and identifies the correct party enum. If it does not exist
     * it will return false.
     *
     * @param party the abbreviation
     * @return whether the enum was found
     */
    public boolean setParty(String party) {
        Party foundParty = Party.getPartyByAbbreviationNO(party);

        if (foundParty == null) {
            return false;
        }

        this.party = foundParty;
        return true;
    }

    /**
     * Takes a given party abbreviation and identifies the correct party enum. If it does not exist
     * it will return false.
     *
     * @param party the party
     */
    public void setParty(Party party) {
        this.party = party;
    }

}