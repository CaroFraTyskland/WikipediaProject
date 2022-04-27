package basics.norway;

public enum NorwegianProvince {

    AKERSHUS("Akershus", "Akershus", false, 2),
    AUST_AGDER("Aust-Agder", "Aust-Agder", false, 9),
    BUSKERUD("Buskerud", "Buskerud", false, 6),
    FINNMARK("Finnmark", "Finnmark (Fylke)", false, 20),
    HEDMARK("Hedmark", "Hedmark", false, 4),
    HORDALAND("Hordaland", "Hordaland", false, 12),
    NORD_TROENDELAG("Nord-Trøndelag", "Nord-Trøndelag", false, 17),
    OESTFOLD("Østfold", "Østfold", false, 1),
    OPPLAND("Oppland", "Oppland", false, 5),
    SOER_TROENDELAG("Sør-Trøndelag", "Sør-Trøndelag", false, 16),
    SOGN_OG_FJORDANE("Sogn og Fjordane", "Sogn og Fjordane", false, 14),
    TELEMARK("Telemark", "Telemark", false, 8),
    TROMS("Troms", "Troms", false, 19),
    VEST_AGDER("Vest-Agder", "Vest-Agder", false, 10),
    VESTFOLD("Vestfold", "Vestfold", false, 7),

    AGDER("Agder", "Agder", true, 42),
    INNLANDET("Innlandet", "Innlandet", true, 34),
    MOERE_OG_ROMSDAL("Møre og Romsdal", "Møre og Romsdal", true, 15),
    NORDLAND("Nordland", "Nordland", true, 18),
    OSLO("Oslo", "Oslo", true, 3),
    ROGALAND("Rogaland", "Rogaland", true, 11),
    TROMS_OG_FINNMARK("Troms og Finnmark", "Troms og Finnmark", true, 54),
    TROENDELAG("Trøndelag", "Trøndelag", true, 50),
    VESTFOLD_OG_TELEMARK("Vestfold og Telemark", "Vestfold og Telemark", true, 38),
    VESTLAND("Vestland", "Vestland", true, 46),
    VIKEN("Viken", "Viken", true, 30);


    private final String name;
    private final String link;
    private final boolean stillExists;
    private final int number;

    NorwegianProvince(String name, String link, boolean stillExists, int number) {
        this.name = name;
        this.link = link;
        this.stillExists = stillExists;
        this.number = number;
    }

    /**
     * Return the province that fits to a certain given name.
     *
     * @param name the name
     * @return the province
     */
    public static NorwegianProvince getProvinceByName(String name) {
        switch (name.toLowerCase()) {
            case "akershus":
            case "ak":
                return AKERSHUS;
            case "aust-agder":
            case "aa":
                return AUST_AGDER;
            case "buskerud":
            case "bus":
                return BUSKERUD;
            case "finnmark":
            case "finn":
                return FINNMARK;
            case "hedmark":
            case "hed":
                return HEDMARK;
            case "hordaland":
            case "hor":
                return HORDALAND;
            case "møre og romsdal":
            case "möre og romsdal":
            case "møre":
            case "möre":
            case "mr":
                return MOERE_OG_ROMSDAL;
            case "nordland":
                return NORDLAND;
            case "nord-trøndelag":
            case "nt":
            case "nord-tröndelag":
                return NORD_TROENDELAG;
            case "oppland":
            case "opp":
                return OPPLAND;
            case "oslo":
                return OSLO;
            case "østfold":
            case "östfold":
            case "öst":
            case "øst":
            case "ost":
                return OESTFOLD;
            case "rogaland":
            case "roga":
                return ROGALAND;
            case "sør-trøndelag":
            case "sør":
            case "sör-tröndelag":
            case "sör":
            case "st":
                return SOER_TROENDELAG;
            case "sogn og fjordane":
            case "sogn":
                return SOGN_OG_FJORDANE;
            case "telemark":
            case "tele":
                return TELEMARK;
            case "troms":
                return TROMS;
            case "vest-agder":
                return VEST_AGDER;
            case "vestfold":
                return VESTFOLD;
            case "agder":
                return AGDER;
            case "innlandet":
            case "inn":
                return INNLANDET;
            case "tof":
            case "troms og finnmark":
            case "troms og finn":
                return TROMS_OG_FINNMARK;
            case "tröndelag":
            case "trönd":
            case "trønd":
            case "trøndelag":
                return TROENDELAG;
            case "vestfold og telemark":
            case "vot":
            case "vest og tele":
                return VESTFOLD_OG_TELEMARK;
            case "vestland":
                return VESTLAND;
            case "viken":
                return VIKEN;
            default:
                return null;
        }
    }

    /**
     * Checks whether or not a given name can be attributed to an existing province.
     *
     * @param name the name
     * @return whether or not it is an ok name
     */
    public static boolean isProvinceCurrentProvince(String name) {
        NorwegianProvince province = getProvinceByName(name);

        return province != null && !province.isFormerProvince();
    }

    /**
     * Returns whether or not a province was founded after 2018.
     *
     * @param province the given province
     * @return whether or not it was founded after 2018
     */
    public static boolean isNew(NorwegianProvince province) {
        switch (province) {
            case AGDER:
            case INNLANDET:
            case TROMS_OG_FINNMARK:
            case TROENDELAG:
            case VESTFOLD_OG_TELEMARK:
            case VESTLAND:
            case VIKEN:
                return true;
            default:
                return false;
        }
    }

    /**
     * Returns the province with a certain fylkesnummer.
     *
     * @param number the fylkesnummer
     * @return the province or null
     */
    public static NorwegianProvince getProvinceByNumber(int number) {
        for (NorwegianProvince province : NorwegianProvince.values()) {
            if (province.getNumber() == number) {
                return province;
            }
        }

        return null;
    }

    /**
     * Returns the province with a certain fylkesnummer.
     *
     * @param number the fylkesnummer as a String
     * @return the province or null
     */
    public static NorwegianProvince getProvinceByNumber(String number) {
        int convertedNumber;

        try {
            convertedNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return null;
        }

        return getProvinceByNumber(convertedNumber);
    }

    /**
     * Returns the name of the province.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the link to the wikipedia article of the province.
     *
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * Returns whether or not the province still exists or not.
     *
     * @return whether it exists
     */
    public boolean isFormerProvince() {
        return !stillExists;
    }

    /**
     * Return the "fylkesnummer" of the province.
     *
     * @return the number
     */
    public String getFylkesnummerAsString() {

        if (number < 10) {
            return "0" + number;
        }

        return Integer.toString(number);
    }

    /**
     * Returns the fylkesnummer (without leading 0) as an int.
     *
     * @return the fylkesnummer
     */
    public int getNumber() {
        return number;
    }


    /**
     * Returns the successor province of an old province.
     *
     * @param province the province
     * @return the successor
     */
    public static NorwegianProvince getSuccessor(NorwegianProvince province) {
        switch (province) {
            case AUST_AGDER:
            case VEST_AGDER:
                return AGDER;
            case NORD_TROENDELAG:
            case SOER_TROENDELAG:
                return TROENDELAG;
            case FINNMARK:
            case TROMS:
                return TROMS_OG_FINNMARK;
            case HORDALAND:
            case SOGN_OG_FJORDANE:
                return VESTLAND;
            case HEDMARK:
            case OPPLAND:
                return INNLANDET;
            case TELEMARK:
            case VESTFOLD:
                return VESTFOLD_OG_TELEMARK;
            case OESTFOLD:
            case BUSKERUD:
            case AKERSHUS:
                return VIKEN;
            default:
                return province;
        }
    }
}
