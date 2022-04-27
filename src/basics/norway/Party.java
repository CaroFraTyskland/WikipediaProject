package basics.norway;

/**
 * Modelling the Norwegian political parties.
 */
public enum Party {

    NO_H("Høyre", "H", "Høyre", "Høyre-Mitglied",
            "konservativen Partei [[Høyre]]"),
    NO_AP("Arbeiderpartiet", "Ap", "Ap", "Arbeiderpartiet-Mitglied",
            "sozialdemokratischen [[Arbeiderpartiet]] (Ap)"),
    NO_KRF("Kristelig Folkeparti", "KrF", "KrF", "Kristelig-Folkeparti-Mitglied",
            "christdemokratischen [[Kristelig Folkeparti]] (KrF)"),
    NO_V("Venstre", "V", "Venstre", "Venstre-Mitglied (Norwegen)",
            "sozialliberalen [[Venstre (Norwegen)|]]"),
    NO_FRP("Fremskrittspartiet", "FrP", "FrP", "Fremskrittspartiet-Mitglied",
            "rechten [[Fremskrittspartiet]] (FrP)"),
    NO_SV("Sosialistisk Venstreparti", "SV", "SV", "Sosialistisk-Venstreparti-Mitglied",
            "[[Sosialistisk Venstreparti]] (SV)"),
    NO_MDG("Miljøpartiet De Grønne", "MDG", "MDG", "Miljøpartiet-De-Grønne-Mitglied",
            "grünen [[Miljøpartiet De Grønne]] (MDG)"),
    NO_SP("Senterpartiet", "Sp", "Sp", "Senterpartiet-Mitglied",
            "[[Senterpartiet]] (Sp)"),
    NO_R("Rødt", "R", "Rødt", null,
            "linken Partei [[Rødt]]"),
    NO_FNB("Folkeaksjonen mot bompeger", "FNB", "FNB", null,
            "Folkeaksjonen mot bompeger (FNB)");

    private final String fullName;
    private final String abbreviation;
    private final String abbreviationList;
    private final String memberName;
    private final String description;

    Party(String fullName, String abbreviation, String abbreviationList, String memberName, String description) {
        this.fullName = fullName;
        this.abbreviation = abbreviation;
        this.abbreviationList = abbreviationList;
        this.memberName = memberName;
        this.description = description;
    }

    /**
     * Returns the fitting Norwegian political party or null.
     *
     * @param abbreviation the abbreviation of the party
     * @return the party
     */
    public static Party getPartyByAbbreviationNO(String abbreviation) {
        return switch (abbreviation.toLowerCase()) {
            case "a", "ap" -> Party.NO_AP;
            case "h" -> Party.NO_H;
            case "frp" -> Party.NO_FRP;
            case "r" -> Party.NO_R;
            case "sv" -> Party.NO_SV;
            case "sp" -> Party.NO_SP;
            case "fnb" -> Party.NO_FNB;
            case "mdg" -> Party.NO_MDG;
            case "krf" -> Party.NO_KRF;
            case "v" -> Party.NO_V;
            default -> null;
        };
    }

    /**
     * Checks if the name of a party is in the list of parties and returns
     * the party or null.
     *
     * @param nameOfParty the input party
     * @return the party or null
     */
    public static Party getPartyByName(String nameOfParty) {
        for (Party party : Party.values()) {
            if (party.getFullName().toLowerCase().equals(nameOfParty.toLowerCase())) {
                return party;
            }
        }

        return null;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getAbbreviationList() {
        return abbreviationList;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getDescription() {
        return description;
    }
}
