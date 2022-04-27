package basics;

public enum Month {

    JANUARY("Januar", 31),
    FEBRUARY("Februar", 29),
    MARCH("März", 31),
    APRIL("April", 30),
    MAY("Mai", 31),
    JUNE("Juni", 30),
    JULY("Juli", 31),
    AUGUST("August", 31),
    SEPTEMBER("September", 30),
    OCTOBER("Oktober", 31),
    NOVEMBER("November", 30),
    DECEMBER("Dezember", 31);

    private final String name;
    private final int days;

    /**
     * Month with its name and the number of days is has at most.
     *
     * @param name the name of the month
     * @param days the maximum number of days
     */
    Month(String name, int days) {
        this.name = name;
        this.days = days;
    }

    /**
     * Checks if the number of a month is in the list of months and returns
     * the month or null.
     *
     * @param number the input month
     * @return the month or null
     */
    public static Month getMonthByNumber(String number) {
        return switch (number) {
            case "01", "1" -> JANUARY;
            case "02", "2" -> FEBRUARY;
            case "03", "3" -> MARCH;
            case "04", "4" -> APRIL;
            case "05", "5" -> MAY;
            case "06", "6" -> JUNE;
            case "07", "7" -> JULY;
            case "08", "8" -> AUGUST;
            case "09", "9" -> SEPTEMBER;
            case "10" -> OCTOBER;
            case "11" -> NOVEMBER;
            case "12" -> DECEMBER;
            default -> null;
        };

    }

    /**
     * Checks if the name of a month is in the list of months and returns
     * the month or null.
     *
     * @param nameOfMonth the input month
     * @return the month or null
     */
    public static Month getMonthByName(String nameOfMonth) {
        for (Month month : Month.values()) {
            if (month.getName().toLowerCase().equals(nameOfMonth.toLowerCase())) {
                return month;
            }
        }

        return null;
    }

    /**
     * Returns whether or not a given day is accepted (meaning it is an actual
     * day of the given month).
     *
     * @param month the month
     * @param day   the number of the day
     * @return whether the day is accepted
     */
    public static boolean acceptDay(Month month, int day) {
        return day <= month.getDays();
    }

    /**
     * Returns the name of a month.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns how many days the month has.
     *
     * @return the number of days
     */
    private int getDays() {
        return days;
    }

    @Override
    public String toString() {
        return name;
    }
}