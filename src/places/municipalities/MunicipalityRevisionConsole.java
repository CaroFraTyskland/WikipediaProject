package places.municipalities;

import console.ConsoleDialog;
import console.NorwegianConsole;
import templates.sources.KartverketSource;
import templates.sources.SSBsource;

import java.util.Scanner;

public class MunicipalityRevisionConsole extends NorwegianConsole {

    private static NorwegianMunicipalityObject municipality;

    private static Scanner scanner;
    private static Scanner intScanner;

    public static void runThrough() {
        scanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);

        municipality = new NorwegianMunicipalityObject();

        municipality.setMunicipality(promptMunicipalityNumber());
        municipality.setAdminCenter(getNonEmptyString("administrative center"));

        if (!municipality.foundMountain()) {
            String mountainName = getNonEmptyString("highest point (name)");
            String height = Double.toString(promptDouble("highest point (height)"));

            municipality.setHighestMountain(mountainName, height);
        }

        if (!municipality.foundPopulationName()) {
            municipality.setCitizenName(getNonEmptyString("name of citizens"));
        }
        municipality.printArticleFragment();
    }

    public static void runThroughPopulation() {
        scanner = new Scanner(System.in);

        municipality = new NorwegianMunicipalityObject();
        municipality.setMunicipality(promptMunicipalityNumber());

        municipality.printPopulation();
    }

    private static void keepDialogOpen() {
        boolean quit = false;

        ConsoleDialog consoleDialog = new ConsoleDialog();

        while (!quit) {
            promptEmpty();
            String command = scanner.nextLine();

            String[] text = command.trim().split("\\s+");

            switch (text[0].toLowerCase()) {
                case "beftett" -> System.out.println(SSBsource.befTettSource());
                case "faktaark", "fakta" -> faktaarkDialog();
                case "kirkesok", "kirke" -> ConsoleDialog.kirkeDialog();
                case "help" -> printHelp();
                case "norgeskart" -> System.out.println(KartverketSource.getNorgesKartSource(municipality.getName()));
                case "quit" -> quit = true;
                default -> printError();
            }
        }
    }

    private static void printHelp() {
        String text = "avi:        get the Avinor projects.general.source for an airport" + "\n" +
                "bane:       get the BaneNOR projects.general.source for a train station" + "\n" +
                "beftett:    get the SSB projects.general.source for the tettsteder" + "\n" +
                "fakta:      get the Faktaark projects.general.source for a location" + "\n" +
                "kirke:      get the Kirkesøk projects.general.source for a church" + "\n" +
                "norgeskart: get the SSB projects.general.source for the tettsteder" + "\n" +
                "quit:       close the projects.general.console";

        printHelpText(text);

        promptEmpty();
    }

    /**
     * Asks about the necessary information for faktaark projects.general.source.
     */
    private static void faktaarkDialog() {
        prompt2("id of the faktaark");
        int id = intScanner.nextInt();

        System.out.println(KartverketSource.getFaktaarkSource(id, municipality.getName()));
    }
}