package console;

import basics.Month;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Console {

    /**
     * General prompt
     *
     * @param message the prompting message
     */
    protected static void prompt2(String message) {
        System.out.print(">> " + message + ": ");
    }

    /**
     * Empty promp indicating that the user can enter something.
     */
    protected static void promptEmpty() {
        System.out.print(">> ");
    }

    /**
     * Text printed after user input could not be read.
     */
    protected static void printError() {
        System.out.println("type \"help\" for more information");
        promptEmpty();
    }

    /**
     * Prompt after arguments were missing from the input.
     *
     * @param arguments the required arguments
     */
    protected static void printErrorArguments(String arguments) {
        System.out.println("needs more arguments: " + arguments);
        promptEmpty();
    }

    /**
     * Prints the accepted inputs.
     *
     * @param text the inputs
     */
    protected static void printHelpText(String text) {
        System.out.println("\n### Help ###");
        System.out.println(text);
        System.out.println("### #### ###\n");
    }

    /**
     * Asks for a month until the user input is accepted.
     *
     * @param promptMessage the prompting message
     * @return the accepted month
     */
    protected static Month promptMonth(String promptMessage) {
        Scanner scanner = new Scanner(System.in);

        prompt2(promptMessage);
        String answer = scanner.nextLine();

        Month month = Month.getMonthByName(answer);

        if (month != null) {
            return month;
        }

        return promptMonth(promptMessage);
    }

    /**
     * Asks for a year as long as the requirements are not met.
     *
     * @param promptText the prompt text
     * @return the year
     */
    protected static int promptYear(String promptText) {
        return promptIntMinMax(promptText, 1500, 2100);
    }

    /**
     * Asks for a positive number as long as the requirements are not met.
     *
     * @param promptText the prompt text
     * @return the number
     */
    protected static int promptPositiveNumber(String promptText) {
        return promptIntMinMax(promptText, 0, Integer.MAX_VALUE);
    }

    /**
     * Asks for a number as long as the requirements are not met.
     *
     * @param promptText the prompt text
     * @param min        the minimum value
     * @param max        the maximum value
     * @return the number
     */
    protected static int promptIntMinMax(String promptText, int min, int max) {
        Scanner scanner = new Scanner(System.in);

        boolean inputOk = false;
        int number = 0;

        while (!inputOk) {
            prompt2(promptText);
            number = 0;

            try {
                number = scanner.nextInt();
                inputOk = (number < max && number > min);
            } catch (InputMismatchException ignored) {
                scanner.next();
            }
        }

        return number;
    }

    /**
     * Asks for a number as long as the requirements are not met.
     *
     * @param promptText the prompt text
     * @return the number
     */
    protected static double promptDouble(String promptText) {
        Scanner scanner = new Scanner(System.in);

        boolean inputOk = false;
        double number = 0;

        while (!inputOk) {
            prompt2(promptText);
            number = 0;

            try {
                number = scanner.nextDouble();
                inputOk = true;
            } catch (InputMismatchException ignored) {
                scanner.next();
            }
        }

        return number;
    }

    /**
     * Asks for an input as long as the user does not enter yes or no.
     *
     * @param promptText the prompt text
     * @return true or false
     */
    protected static boolean promptYesNo(String promptText) {
        while (true) {
            String input = getNonEmptyString(promptText + " (yes/no)");

            switch (input) {
                case "yes":
                case "y":
                    return true;
                case "no":
                case "n":
                    return false;
            }
        }
    }

    /**
     * Prompt that only accepts non empty strings as answer.
     *
     * @param promptMessage the message
     * @return the accepted user input
     */
    protected static String getNonEmptyString(String promptMessage) {
        Scanner scanner = new Scanner(System.in);
        boolean isNotOk = true;
        String input = "";

        while (isNotOk) {
            /*
                Decides which type of prompting message is used.
             */
            prompt2(promptMessage);

            input = scanner.nextLine();

            isNotOk = input.trim().isEmpty();
        }

        return input;
    }

    /**
     * Checks whether or not the input is the command to quit.
     *
     * @param input the input
     * @return quit or not
     */
    protected static boolean checkForQuit(String input) {
        return input.toLowerCase().equals("q") || input.toLowerCase().equals("quit");
    }

}
