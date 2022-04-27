package templates;

import java.util.Calendar;

public class Weblinks {

    private static final String WEBLINKS_TITLE = "== Weblinks ==";
    private static final String REFERENCES_TITLE = "== Einzelnachweise ==";

    /**
     * Returns the title for the link section.
     *
     * @return the title
     */
    public static String getWeblinksWithCommonscat() {
        return WEBLINKS_TITLE + "\n{{Commonscat}}";
    }

    public static String getReferencesSection() {
        return REFERENCES_TITLE + "\n" + "<references />";
    }

    /**
     * Returns today's date in the YYYY-MM-DD format.
     *
     * @return the date
     */
    public static String getTodaysDate() {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);

        String dayString = formatNumber(day);
        String monthString = formatNumber(month);

        return year + "-" + monthString + "-" + dayString;
    }

    /**
     * Ensures that the number has a leading 0 if necessary.
     *
     * @param number the number
     * @return the text
     */
    private static String formatNumber(int number) {
        String numberString = Integer.toString(number);

        if (number < 10) {
            numberString = "0" + number;
        }

        return numberString;
    }
}
