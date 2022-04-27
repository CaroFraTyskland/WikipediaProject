package basics.norway;

public enum Constituency {

    NO_AKERSHUS("Akershus", "Akershus"),
    NO_AUST_AGDER("Aust-Agder", "Aust-Agder"),
    NO_BUSKERUD("Buskerud", "Buskerud"),
    NO_FINNMARK("Finnmark", "Finnmark (Fylke)"),
    NO_HEDMARK("Hedmark", "Hedmark"),
    NO_HORDALAND("Hordaland", "Hordaland"),
    NO_MOERE_OG_ROMSDAL("Møre og Romsdal", "Møre og Romsdal"),
    NO_NORDLAND("Nordland", "Nordland"),
    NO_NORD_TROENDELAG("Nord-Trøndelag", "Nord-Trøndelag"),
    NO_OESTFOLD("Østfold", "Østfold"),
    NO_OPPLAND("Oppland", "Oppland"),
    NO_OSLO("Oslo", "Oslo"),
    NO_ROGALAND("Rogaland", "Rogaland"),
    NO_SOER_TROENDELAG("Sør-Trøndelag", "Sør-Trøndelag"),
    NO_SOGN_OG_FJORDANE("Sogn og Fjordane", "Sogn og Fjordane"),
    NO_TELEMARK("Telemark", "Telemark"),
    NO_TROMS("Troms", "Troms"),
    NO_VEST_AGDER("Vest-Agder", "Vest-Agder"),
    NO_VESTFOLD("Vestfold", "Vestfold");


    private final String name;
    private final String wikipediaArticle;

    Constituency(String name, String wikipediaArticle) {
        this.name = name;
        this.wikipediaArticle = wikipediaArticle;
    }

    public static Constituency getByNameOrAbbreviation(String name) {
        return switch (name.toLowerCase()) {
            case "akershus", "ak" -> Constituency.NO_AKERSHUS;
            case "aust-agder", "aa" -> Constituency.NO_AUST_AGDER;
            case "buskerud", "bus" -> Constituency.NO_BUSKERUD;
            case "finnmark", "finn" -> Constituency.NO_FINNMARK;
            case "hedmark", "hed" -> Constituency.NO_HEDMARK;
            case "hordaland", "hor" -> Constituency.NO_HORDALAND;
            case "møre og romsdal", "möre og romsdal", "møre", "möre", "mr" -> Constituency.NO_MOERE_OG_ROMSDAL;
            case "nordland" -> Constituency.NO_NORDLAND;
            case "nord-trøndelag", "nt", "nord-tröndelag" -> Constituency.NO_NORD_TROENDELAG;
            case "oppland", "opp" -> Constituency.NO_OPPLAND;
            case "oslo" -> Constituency.NO_OSLO;
            case "østfold", "östfold", "öst", "øst", "ost" -> Constituency.NO_OESTFOLD;
            case "rogaland", "roga" -> Constituency.NO_ROGALAND;
            case "sør-trøndelag", "sør", "sör-tröndelag", "sör", "st" -> Constituency.NO_SOER_TROENDELAG;
            case "sogn og fjordane", "sogn" -> Constituency.NO_SOGN_OG_FJORDANE;
            case "telemark", "tele" -> Constituency.NO_TELEMARK;
            case "troms" -> Constituency.NO_TROMS;
            case "vest-agder" -> Constituency.NO_VEST_AGDER;
            case "vestfold" -> Constituency.NO_VESTFOLD;
            default -> null;
        };
    }

    /**
     * Returns the name of the constituency.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the correct wikipedia link for the constituency.
     *
     * @return the link
     */
    public String getConstituencyLink() {
        if (name.equals(wikipediaArticle)) {
            return name;
        }

        return wikipediaArticle + "|" + name;
    }

    @Override
    public String toString() {
        return name;
    }
}
