package politics.Storting;

import articleTypes.ArticleBasic;
import politics.NorwegianPoliticianConsole;
import templates.sources.StortingSource;

import java.util.Scanner;

public class StortingMPConsole extends NorwegianPoliticianConsole {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Runs through the routine for a Storting MP.
     */
    public static void runThrough() {
        StortingMP mp = new StortingMP();
        promptStortingId(mp);

        ArticleBasic.printArticle(new StortingMPArticle(mp));
    }

    /**
     * Prints the reference for a member of the Storting (based on the id the user types in).
     */
    public static void runThroughReference() {
        String id = getNonEmptyString("Storting ID");

        System.out.println("\n" + StortingSource.getStortingReferencesById(id));
    }

    /**
     * Asks for the Storting ID and creates the MP object out of the information.
     *
     * @param mp the MP object
     */
    public static void promptStortingId(StortingMP mp) {
        prompt2("Storting ID");
        String stortingId = scanner.nextLine();

        mp.setStortingInformation(stortingId);
    }

    /**
     * Returns the Storting MP object for a member based on the user input.
     *
     * @return the MP
     */
    public static StortingMP getStortingMpFromConsole() {
        StortingMP mp = new StortingMP();

        promptStortingId(mp);

        return mp;
    }
}