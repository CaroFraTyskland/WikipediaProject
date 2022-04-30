package console;

import awards.SpellemannList;
import politics.NorwegianPoliticianConsole;
import politics.Storting.StortingMPConsole;
import templates.sources.KartverketSource;
import templates.sources.NorwegianSource;
import templates.sources.SNLsource;
import templates.sources.StortingSource;
import wiki.WrittenArticles;

import java.util.Scanner;

public class ConsoleDialog extends Console {

    private final Scanner scanner;
    private final Scanner intScanner;

    public ConsoleDialog() {
        scanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);
    }

    /**
     * Asks about the necessary information for kirkesøk source.
     */
    public static void kirkeDialog() {
        String name = getNonEmptyString("name of church");
        int id = promptPositiveNumber("id of church");

        System.out.println("\n" + NorwegianSource.getKirkesokSource(id, name));
    }

    /**
     * Asks about the necessary information for Norgeskart source.
     */
    public static void norgeskartDialog() {
        String name = getNonEmptyString("name of location");

        System.out.println(KartverketSource.getNorgesKartSource(name));
    }

    /**
     * Handles the input for a snl references. If the article name was not already given the snl-dialog is opened,
     * otherwise the reference is printed.
     *
     * @param inputData the input
     */
    public static void handleSNL(String[] inputData) {
        String article;

        if (inputData.length < 3) {
            article = getNonEmptyString("name of SNL article");
        } else {
            article = inputData[2];
        }

        System.out.println("\n" + SNLsource.getSNLRef(article));
    }

    /**
     * Handles the input for a Storting reference.
     *
     * @param inputData the user's input
     */
    public static void handleStortingRef(String[] inputData) {
        if (inputData.length < 3) {
            StortingMPConsole.runThroughReference();
        } else {
            System.out.println("\n" + StortingSource.getStortingReferencesById(inputData[2]));
        }
    }

    /**
     * Handles the input for a Storting reference.
     *
     * @param inputData the user's input
     */
    public static void handleGovermentRef(String[] inputData) {
        if (inputData.length < 3) {
            NorwegianPoliticianConsole.runThroughReference();
        } else {
            System.out.println("\n" + StortingSource.getStortingReferencesById(inputData[2]));
        }
    }

    /**
     * Handles the input for the Spellemann list.
     *
     * @param inputData the user's input
     */
    public static void handleSpellemann(String[] inputData) {
        int year;

        try {
            year = Integer.parseInt(inputData[2]);
        } catch (Exception e) {
            year = promptYear("year");
        }

        SpellemannList.printArticle(year);
    }

    /**
     * Prints the list of articles written by a certain user.
     *
     * @param inputData the user's input
     */
    public static void printUserArticles(String[] inputData) {
        String name;

        if (inputData.length < 2) {
            name = getNonEmptyString("user name");
        } else {
            name = inputData[1];
        }

        WrittenArticles.printArticlesOfUser(name);
    }

    public static String getUserName(String[] inputData) {
        StringBuilder name = new StringBuilder();

        if (inputData.length < 2) {
            name = new StringBuilder(getNonEmptyString("user name"));
        } else {
            name.append(inputData[1]);
            for (int i = 2; i < inputData.length; i++) {
                name.append(" ").append(inputData[i]);
            }
        }

        return name.toString();

    }

    /**
     * Asks about the necessary information for Avinor source.
     */
    public void avinorDialog() {
        String name = getNonEmptyString("airport name");
        String id = getNonEmptyString("url id of the airport");

        System.out.println("\n" + NorwegianSource.getAvinorAiportInfoSource(id, name));
    }

    /**
     * Asks about the necessary information for faktaark source.
     */
    public void faktaarkDialog() {
        prompt2("id of the faktaark");
        int id = intScanner.nextInt();

        prompt2("name of the location");
        String name = scanner.nextLine();

        System.out.println(KartverketSource.getFaktaarkSource(id, name));
    }
}