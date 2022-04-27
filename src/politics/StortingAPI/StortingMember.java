package politics.StortingAPI;

import basics.Gender;
import basics.Month;
import basics.norway.Party;

public class StortingMember {

    private String lastName;
    private String firstName;
    private Gender gender;
    private Month birthMonth;
    private int birthYear;
    private int birthDay;
    private String birthPlace;
    private Party party;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Month getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Month birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}