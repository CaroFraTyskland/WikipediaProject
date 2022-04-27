package basics;

public enum Nation {

    NORWAY("Norwegen", "Norweger", "norwegische", "norwegischer", "norwegische/r"),
    DENMARK("Dänemark", "Däne", "dänische", "dänischer", "dänische/r"),
    GERMAN("Deutschland", "Deutscher", "deutsche", "deutscher", "deutsche/r"),
    UK("Vereinigtes Königreich", "Brite", "britische", "britischer", "britische/r"),
    USA("Vereinigte Staaten", "US-Amerikaner", "US-amerikanische", "US-amerikanischer", "US-amerikanische/r"),
    SWEDEN("Schweden", "Schwede", "schwedische", "schwedischer", "norwegische/r");

    private final String country;
    private final String category;
    private final String adjectiveFemale;
    private final String adjectiveMale;
    private final String adjectiveNB;

    Nation(String country, String category, String adjectiveFemale, String adjectiveMale, String adjectiveNB) {
        this.country = country;
        this.category = category;
        this.adjectiveFemale = adjectiveFemale;
        this.adjectiveMale = adjectiveMale;
        this.adjectiveNB = adjectiveNB;
    }

    /**
     * Returns the nation which belongs to a given abbreviation.
     *
     * @param abbr the abbreviation
     * @return the nation
     */
    public static Nation getNationByAbbreviation(String abbr) {
        return switch (abbr.toLowerCase()) {
            case "no", "norge", "norwegen" -> NORWAY;
            case "sw", "se", "schweden" -> SWEDEN;
            case "dänemark", "danmark", "dk", "dan", "däne" -> DENMARK;
            case "uk", "brite", "gb" -> UK;
            case "usa", "us" -> USA;
            case "deutsch", "de", "german" -> GERMAN;
            default -> null;
        };
    }

    /**
     * Returns the category for a person from the country.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the name of the country.
     *
     * @return the country
     */
    public String getCountryName() {
        return country;
    }

    /**
     * Returns the adjective based on the gender of the person.
     *
     * @param gender the gender
     * @return the adjective
     */
    public String getAdjective(Gender gender) {
        return switch (gender) {
            case NON_BINARY -> adjectiveNB;
            case FEMALE -> adjectiveFemale;
            case MALE -> adjectiveMale;
            default -> throw new IllegalStateException("unknown gender");
        };
    }
}