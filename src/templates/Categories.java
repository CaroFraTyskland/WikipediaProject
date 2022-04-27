package templates;

public class Categories {

    private final static String DEFAULTSORT_NAME = "SORTIERUNG";
    private final static String CATEGORY_NAME = "Kategorie:";
    private final static String BIRTH_CATEGORY_NAME = "Geboren ";

    /**
     * Returns the default sort text for a given name of an article (replacing certain letters in it).
     *
     * @param name the name
     * @return the default sort text
     */
    public static String getDefaultSort(String name) {
        String sortName = defaultSortText(name);

        return "{{" + DEFAULTSORT_NAME + ":" + sortName + "}}";
    }

    /**
     * Checks whether or not a default sort has to be given (so whether some letters have to be replaced
     * for the default sort).
     *
     * @param name the name of the article
     * @return whether it needs default sort
     */
    public static boolean needsDefaultSort(String name) {
        return !name.equals(defaultSortText(name));
    }

    /**
     * Replaces certain letters as they are not supposed to occur in the defaultsort text.
     *
     * @param text the text of the person
     * @return the text without certain letters
     */
    public static String defaultSortText(String text) {
        text = replaceLetters(text);
        text = text.replaceAll("-", "");

        return text;
    }

    public static String replaceLetters(String text) {
        text = text.replaceAll("Ø", "O");
        text = text.replaceAll("ø", "o");
        text = text.replaceAll("å", "a");
        text = text.replaceAll("Å", "A");
        text = text.replaceAll("æ", "ae");
        text = text.replaceAll("Æ", "Ae");
        text = text.replaceAll("é", "e");
        text = text.replaceAll("è", "e");
        text = text.replaceAll("È", "E");
        text = text.replaceAll("É", "E");

        return text;
    }


    /**
     * Creates a category with a given text.
     *
     * @param categoryText the text
     * @return the category line
     */
    public static String createCategory(String categoryText) {
        return "[[" + CATEGORY_NAME + categoryText + "]]\n";
    }

    /**
     * Creates the birth category with a given birth year.
     *
     * @param year the year
     * @return the category line
     */
    public static String createBirthCategory(int year) {
        return createCategory(BIRTH_CATEGORY_NAME + year);
    }
}
