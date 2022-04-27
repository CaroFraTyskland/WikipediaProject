package person;

import basics.Gender;
import basics.Job;
import basics.Month;
import basics.Nation;
import templates.Categories;
import templates.PD;

public class Person {

    protected PD pd;

    protected String firstNames;
    protected String lastName;
    protected Gender gender;
    protected Nation nationality;
    protected Job job;
    private int birthday;
    private Month birthMonth;
    private int birthyear;
    private String birthplace;

    /**
     * Sets the last name of the person.
     *
     * @param lastName the last name
     * @return whether or not the name was accepted
     */
    public boolean setLastName(String lastName) {
        if (lastName.isEmpty()) {
            return false;
        }

        this.lastName = lastName;
        return true;
    }

    /**
     * Sets the first names of the person.
     *
     * @param firstNames the last name
     * @return whether or not the name was accepted
     */
    public boolean setFirstNames(String firstNames) {
        if (firstNames.isEmpty()) {
            return false;
        }

        this.firstNames = firstNames;
        return true;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    /**
     * Sets the month if the name of the month is accepted and returns whether or
     * not the month is accepted.
     *
     * @param month the name of the month
     * @return whether it is accepted
     */
    public boolean setBirthMonth(String month) {
        Month myMonth = Month.getMonthByName(month);

        if (myMonth != null) {
            this.birthMonth = myMonth;
            return true;
        }

        return false;
    }

    public void setBirthMonth(Month month) {
        this.birthMonth = month;
    }

    public boolean setBirthday(int birthday) {
        if (birthMonth == null) {
            throw new IllegalStateException("set birthday before month is set");
        }

        if (Month.acceptDay(birthMonth, birthday)) {
            this.birthday = birthday;
            return true;
        }

        return false;
    }

    /**
     * Returns the full name of a person
     *
     * @return the full name
     */
    public String getName() {
        return firstNames + " " + lastName;
    }

    /**
     * Returns the text for the PD template.
     *
     * @return the text
     */
    public String getPDText() {
        return getPD().getPersonendaten();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Gets the pronoun for the person (if person is non-binary, the last name is used)
     *
     * @return the pronoun
     */
    public String getPronoun() {
        return gender.getPronoun(lastName);
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    /**
     * If a general person is created has no job assigned, so it gets it manually assigned.
     */
    public void setGeneralJob() {
        if (job == null) {
            job = Job.OTHER;
        }
    }

    public String getFirstNames() {
        return firstNames;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthday() {
        return birthday;
    }

    public Month getBirthMonth() {
        return birthMonth;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public Nation getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality of the person.
     *
     * @param nationality the nation
     */
    public void setNationality(Nation nationality) {
        this.nationality = nationality;
    }

    public Job getJob() {
        return job;
    }

    /**
     * Returns the Personendaten of the person. If they aren't yet created it creates new ones.
     *
     * @return Personendaten
     */
    public PD getPD() {
        setGeneralJob();
        String description = nationality.getAdjective(gender) + " " + job.getName(gender);

        if (pd == null) {
            pd = new PD(this, description);
        }

        return pd;
    }

    /**
     * Returns the default sort value for the person.
     *
     * @return the text
     */
    public String getDefaultSort() {
        return Categories.getDefaultSort(getPD().getNameWithComma());
    }

    /**
     * Returns the three last categories of a article (nationality, birth year, gender)
     *
     * @return the text
     */
    public String getPersonCategories() {
        return Categories.createCategory(nationality.getCategory()) +
                Categories.createBirthCategory(birthyear) +
                Categories.createCategory(gender.getWikipediaCategory());
    }
}
