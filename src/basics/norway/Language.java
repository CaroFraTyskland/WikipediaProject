package basics.norway;

import templates.weblinks.Lovdata;

public enum Language {

    NYNORSK, BOKMAAL, NEUTRAL;

    /**
     * Returns the language for a given abbreviation or null if the abbreviation is not known.
     *
     * @param abbr the given abbreviation
     * @return the language
     */
    public static Language getLanguageByAbbreviation(String abbr) {
        switch (abbr.toLowerCase()) {
            case "b":
            case "bok":
            case "bm":
                return BOKMAAL;
            case "nn":
            case "ny":
            case "nynorsk":
                return NYNORSK;
            case "n":
            case "neutral":
                return NEUTRAL;
            default:
                return null;
        }
    }

    /**
     * Write the text about the official language form.
     *
     * @return the text
     */
    public String writeLanguage(NorwegianProvince province, String municipalityName) {
        String text = switch (this) {
            case BOKMAAL -> writeBokmaal(province);
            case NYNORSK -> writeNynorsk(province);
            case NEUTRAL -> writeNeutral(province, municipalityName);
            default -> throw new IllegalStateException("Unknown language");
        };

        return text + Lovdata.getLanguageSource();
    }

    /**
     * Writes the text for bokmål.
     *
     * @return the text
     */
    private String writeBokmaal(NorwegianProvince province) {
        return switch (province) {
            case VIKEN, INNLANDET, NORDLAND, TROMS_OG_FINNMARK ->
                    "Offizielle Schriftsprache ist wie in vielen Kommunen in " + province.getName() +
                            " [[Bokmål]], also die weiter verbreitete der beiden norwegischen Sprachformen.";
            case VESTFOLD_OG_TELEMARK, ROGALAND ->
                    "Offizielle Schriftsprache ist wie in nur wenigen Kommunen in " + province.getName() +
                            " [[Bokmål]], also die weiter verbreitete der beiden norwegischen Sprachformen.";
            case AGDER, TROENDELAG ->
                    "Offizielle Schriftsprache ist wie in einigen weiteren Kommunen in " + province.getName() +
                            " [[Bokmål]], also die weiter verbreitete der beiden norwegischen Sprachformen.";
            default -> throw new IllegalStateException("Unknown province");
        };
    }

    /**
     * Writes the text for nynorsk.
     *
     * @return the text
     */
    private String writeNynorsk(NorwegianProvince province) {
        return switch (province) {
            case VIKEN, INNLANDET ->
                    "Offizielle Schriftsprache ist wie in nur wenigen Kommunen in " + province.getName() +
                            " [[Nynorsk]], also die weniger weit verbreitete der beiden norwegischen Sprachformen.";
            case ROGALAND, VESTLAND, MOERE_OG_ROMSDAL ->
                    "Offizielle Schriftsprache ist wie in vielen Kommunen in " + province.getName() +
                            " [[Nynorsk]], also die weniger weit verbreitete der beiden norwegischen Sprachformen.";
            case AGDER, VESTFOLD_OG_TELEMARK ->
                    "Offizielle Schriftsprache ist wie in einigen weiteren Kommunen in " + province.getName() +
                            " [[Nynorsk]], also die weniger weit verbreitete der beiden norwegischen Sprachformen.";
            default -> throw new IllegalStateException("Unknown province");
        };
    }

    /**
     * Writes the text for neutral language.
     *
     * @return the text
     */
    private String writeNeutral(NorwegianProvince province, String municipalityName) {
        return switch (province) {
            case INNLANDET, VESTFOLD_OG_TELEMARK, AGDER, ROGALAND, TROENDELAG, NORDLAND, TROMS_OG_FINNMARK ->
                    municipalityName + " hat wie viele andere Kommunen der Provinz " + province.getName() +
                            " weder [[Nynorsk]] noch [[Bokmål]] als offizielle Sprachform, sondern ist in dieser Frage neutral.";
            case VIKEN, MOERE_OG_ROMSDAL ->
                    municipalityName + " hat wie einige weitere Kommunen der Provinz " + province.getName() +
                            " weder [[Nynorsk]] noch [[Bokmål]] als offizielle Sprachform, sondern ist in dieser Frage neutral.";
            case VESTLAND ->
                    "Im Gegensatz zu den meisten anderen Kommunen der Provinz " + province.getName() + " hat " + municipalityName +
                            " weder [[Nynorsk]] noch [[Bokmål]] als offizielle Sprachform, sondern ist in dieser Frage neutral.";
            case OSLO ->
                    municipalityName + " hat weder [[Nynorsk]] noch [[Bokmål]] als offizielle Sprachform, sondern ist in dieser Frage neutral.";
            default -> throw new IllegalStateException("Unknown province");
        };
    }
}