package templates;

import basics.Month;
import person.Person;

/**
 * This class creates the template "Personendaten" which has to be used at the
 * end of every article about a person.
 */
public class PD {

    private final String firstNames;
    private final String lastName;
    private final int birthday;
    private final Month birthMonth;
    private final int birthyear;
    private final String shortDescription;
    private final String birthplace;

    /**
     * Personendaten for a person.
     *
     * @param person           the person object
     * @param shortDescription a short description of person
     */
    public PD(Person person, String shortDescription) {
        this.firstNames = person.getFirstNames();
        this.lastName = person.getLastName();
        this.birthday = person.getBirthday();
        this.birthplace = person.getBirthplace();
        this.birthMonth = person.getBirthMonth();
        this.birthyear = person.getBirthyear();
        this.shortDescription = shortDescription;
    }

    /**
     * returns the birthday of a person with the day and year not being linked
     *
     * @return the birthday
     */
    public String getBirthdayWithoutLinks() {
        if (birthday != 0) {
            return birthday + ". " + birthMonth + " " + birthyear;
        } else if (birthMonth != null) {
            return birthMonth + " " + birthyear;
        }

        return Integer.toString(birthyear);
    }

    /**
     * Returns the birthplace of a person with it being linked.
     *
     * @return the birth place
     */
    public String getBirthPlaceWithLinks() {
        if (birthplace.equals("")) {
            return "";
        } else {
            return "[[" + birthplace + "]]";
        }
    }

    /**
     * returns the birthday of a person with the day/month and year being linked
     *
     * @return the birthday
     */
    public String getBirthdayWithLinks() {
        if (birthday != 0) {
            return "[[" + birthday + ". " + birthMonth + "]]" + " [[" + birthyear + "]]";
        } else if (birthMonth != null) {
            return "[[" + birthMonth + "]]" + " [[" + birthyear + "]]";
        }

        return "[[" + birthyear + "]]";
    }

    /**
     * Returns the name with a comma separating the parts.
     *
     * @return the name
     */
    public String getNameWithComma() {
        return lastName + ", " + firstNames;
    }

    /**
     * Returns the pd of a living person.
     *
     * @return the text
     */
    public String getPersonendaten() {
        return
                "{{Personendaten" + "\n" +
                        "|NAME=" + getNameWithComma() + "\n" +
                        "|ALTERNATIVNAMEN=" + "\n" +
                        "|KURZBESCHREIBUNG=" + shortDescription + "\n" +
                        "|GEBURTSDATUM=" + getBirthdayWithoutLinks() + "\n" +
                        "|GEBURTSORT=" + getBirthPlaceWithLinks() + "\n" +
                        "|STERBEDATUM=" + "\n" +
                        "|STERBEORT=" + "\n}}";
    }
}