package politics;

import basics.norway.NorwegianProvince;
import person.PersonConsole;
import templates.sources.RegjeringSource;

import java.util.Scanner;

public abstract class NorwegianPoliticianConsole extends PersonConsole {

    private static NorwegianPolitician politician;
    private static NorwegianPoliticianArticle article;
    private static Scanner scanner;

    public static void getPoliticianInformation(NorwegianPolitician norwegianPolitician) {
        politician = norwegianPolitician;

        promptParty();
    }


    /**
     * Prints the reference for a minister (based on the id the user types in).
     */
    public static void runThroughReference() {
        String id = getNonEmptyString("Government ID");

        System.out.println("\n" + RegjeringSource.getMinisterSource(id));
    }


    /**
     * Asks for the party of the politician.
     */
    public static void promptParty() {
        boolean acceptParty = false;

        while (!acceptParty) {
            prompt2("Party");
            String party = scanner.nextLine();
            acceptParty = politician.setParty(party);
        }
    }

    /**
     * Tries to convert the given input for the membership of a fylkesting into a wikitext.
     *
     * @param text       the input
     * @param politician the politician
     * @return the text
     */
    protected static boolean checkFylkesting(String[] text, NorwegianPolitician politician) {
        if (text.length < 2 || text[1] == null) {
            return true;
        }

        NorwegianProvince province = NorwegianProvince.getProvinceByName(text[1].toLowerCase());

        if (province == null) {
            return true;
        }

        System.out.println(politician.getFylkestingCategory(province));

        if (text[2] != null && text[3] != null) {
            int start = Integer.parseInt(text[2]);
            int end = Integer.parseInt(text[3]);

            System.out.println(article.writeFylkestingText(province, start, end));

            return false;
        } else if (text[2] != null) {
            int start = Integer.parseInt(text[2]);

            System.out.println(article.writeFylkestingText(province, start));

            return false;
        }

        return true;
    }
}