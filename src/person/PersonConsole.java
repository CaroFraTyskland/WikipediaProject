package person;

import articleTypes.ArticleBasic;
import basics.Gender;
import basics.Nation;
import console.Console;

import java.util.Scanner;

public abstract class PersonConsole extends Console {

    private static Scanner scanner;
    private static Scanner scannerInt;
    private static Person person;

    public static void main(String[] args) {
        person = new Person();

        getPersonInformation(person);
        person.setNationality(promptNationality());

        ArticleBasic.printArticle(new PersonArticle(person));
    }

    protected static void getPersonInformation(Person newPerson) {
        scanner = new Scanner(System.in);
        scannerInt = new Scanner(System.in);
        person = newPerson;

        firstNamePrompt();
        lastNamePrompt();
        genderPrompt();

        birthYearPrompt();
        birthMonthPrompt();
        birthdayPrompt();

        birthPlacePrompt();
    }

    protected static void getPersonInformationBirth(Person newPerson) {
        scanner = new Scanner(System.in);
        scannerInt = new Scanner(System.in);
        person = newPerson;

        birthYearPrompt();
        birthMonthPrompt();
        birthdayPrompt();

        birthPlacePrompt();
    }

    protected static void getPersonInformationBirthPlace(Person newPerson) {
        scanner = new Scanner(System.in);
        person = newPerson;

        birthPlacePrompt();
    }

    /**
     * Asks for the nationality of a projects.person.
     *
     * @return the nation
     */
    protected static Nation promptNationality() {
        prompt2("Nationality");

        scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        Nation nationality = Nation.getNationByAbbreviation(answer);

        while (nationality == null) {
            nationality = promptNationality();
        }

        return nationality;
    }


    /**
     * Asks for the gender of a person. Only accepts three different answers.
     */
    private static void genderPrompt() {
        boolean acceptGender = false;

        while (!acceptGender) {
            prompt2("Gender (m/f/n)");
            String gender = scanner.nextLine();
            switch (gender) {
                case "m" -> {
                    person.setGender(Gender.MALE);
                    acceptGender = true;
                }
                case "f" -> {
                    person.setGender(Gender.FEMALE);
                    acceptGender = true;
                }
                case "n" -> {
                    person.setGender(Gender.NON_BINARY);
                    acceptGender = true;
                }
                default -> acceptGender = false;
            }
        }
    }

    /**
     * Asks for the first name of a person.
     */
    private static void firstNamePrompt() {
        boolean acceptFirstNames = false;

        while (!acceptFirstNames) {
            prompt2("First names");
            String firstNames = scanner.nextLine();
            acceptFirstNames = person.setFirstNames(firstNames);
        }
    }

    /**
     * Asks for the last name of a person.
     */
    private static void lastNamePrompt() {
        boolean acceptLastName = false;

        while (!acceptLastName) {
            prompt2("Last name");
            String lastName = scanner.nextLine();
            acceptLastName = person.setLastName(lastName);
        }
    }

    /**
     * Asks for the birthday of a person.
     */
    protected static void birthdayPrompt() {
        boolean acceptBirthday = false;

        while (!acceptBirthday) {
            prompt2("Birthday (day)");
            int birthday = scannerInt.nextInt();
            acceptBirthday = person.setBirthday(birthday);
        }
    }

    /**
     * Asks for the month of birth of a person.
     */
    protected static void birthMonthPrompt() {
        boolean acceptBirthMonth = false;

        while (!acceptBirthMonth) {
            prompt2("Month of birth");

            String month = scanner.nextLine();
            acceptBirthMonth = person.setBirthMonth(month);
        }
    }

    /**
     * Asks for the year of birth of a person.
     */
    protected static void birthYearPrompt() {
        prompt2("Year of birth");

        int birthyear = scannerInt.nextInt();
        person.setBirthyear(birthyear);
    }

    /**
     * Asks for the place of birth of a person.
     */
    protected static void birthPlacePrompt() {
        prompt2("Place of birth");

        String birthplace = scanner.nextLine();
        person.setBirthplace(birthplace);
    }
}