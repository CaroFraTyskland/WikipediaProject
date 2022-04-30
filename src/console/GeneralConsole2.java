package console;

import places.municipalities.MunicipalityRevisionConsole;
import places.municipalities.NorwegianMunicipality;
import places.municipalities.NorwegianMunicipalityObject;
import places.tettsted.TettstedConsole;
import politics.Storting.StortingMemberLists;
import politics.Storting.StortingMPConsole;
import templates.sources.NorwegianSource;
import templates.sources.SSBsource;
import wiki.DeadLinkTest;
import wiki.WrittenArticles;

import java.util.Scanner;

public class GeneralConsole2 extends Console {

    private static final ConsoleDialog consoleDialog = new ConsoleDialog();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            promptEmpty();
            String input = scanner.nextLine();

            if (checkForQuit(input)) {
                System.out.println("\nquit console\n");
                break;
            }

            handleInput(input);

            System.out.println();
        }
    }

    private static void handleInput(String input) {
        if (input.isEmpty()) {
            return;
        }

        String[] inputData = input.split(" ");

        switch (inputData[0].toLowerCase()) {
            case "articles" -> WrittenArticles.printArticlesOfUser(ConsoleDialog.getUserName(inputData));
            case "bev", "pop" -> MunicipalityRevisionConsole.runThroughPopulation();
            case "dead", "dl" -> DeadLinkTest.testArticle();
            case "dli" -> DeadLinkTest.testMyArticles();
            case "ec", "editcount" -> WrittenArticles.printEditCount(ConsoleDialog.getUserName(inputData));
            case "lsstor", "liststorting" -> StortingMemberLists.printListOfMembers();
            case "mr", "muni" -> MunicipalityRevisionConsole.runThrough();
            case "mp", "stor", "storting" -> StortingMPConsole.runThrough();
            case "randomarticle", "rdmart" -> System.out.println(WrittenArticles.getRandomArticle(ConsoleDialog.getUserName(inputData)));
            case "rdmstor", "randomstorting" -> System.out.println(StortingMemberLists.getRandomMember());
            case "ref" -> handleRef(inputData);
            case "spelle", "spellemann" -> ConsoleDialog.handleSpellemann(inputData);
            case "tett" -> TettstedConsole.runThrough();
            case "tetts" -> {
                String text = NorwegianMunicipalityObject.writeTettsteder(NorwegianMunicipality.getMunicipalityByNumber(inputData[1]));
                System.out.println(text);
            }
        }
    }

    /**
     * If the user input is asking for a reference.
     *
     * @param inputData the input
     */
    private static void handleRef(String[] inputData) {
        if (inputData.length < 2) {
            return;
        }

        switch (inputData[1].toLowerCase()) {
            case "storting", "stor" -> ConsoleDialog.handleStortingRef(inputData);
            case "reg", "minister" -> ConsoleDialog.handleGovermentRef(inputData);
            case "snl" -> ConsoleDialog.handleSNL(inputData);
            case "avinor", "avi" -> consoleDialog.avinorDialog();
            case "bane", "banenor" -> System.out.println(NorwegianSource.getBaneNORSource());
            case "kirke", "ks" -> ConsoleDialog.kirkeDialog();
            case "beftett" -> System.out.println(SSBsource.befTettSource());
        }
    }
}