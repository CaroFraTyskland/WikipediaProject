package console;

import basics.norway.NorwegianProvince;
import places.municipalities.NorwegianMunicipality;

public abstract class NorwegianConsole extends Console {

    /**
     * Asks for a current province and checks whether or not the input is accepted. Returns the province.
     *
     * @param promptText the text for the prompt
     * @return the province
     */
    protected static NorwegianProvince promptProvince(String promptText) {
        boolean inputAccepted = false;
        String province = "";

        while (!inputAccepted) {
            province = getNonEmptyString(promptText);
            inputAccepted = NorwegianProvince.isProvinceCurrentProvince(province);
        }

        return NorwegianProvince.getProvinceByName(province);
    }

    /**
     * Asks for a municipality and checks whether or not the input is accepted. Returns the municipality.
     *
     * @return the municipality
     */
    protected static NorwegianMunicipality promptMunicipality() {
        boolean inputAccepted = false;
        NorwegianMunicipality municipality = null;

        while (!inputAccepted) {
            municipality = NorwegianMunicipality.getMunicipalityByName(getNonEmptyString("municipality"));
            inputAccepted = municipality != null;
        }

        return municipality;
    }

    /**
     * Asks for a municipality and checks whether or not the input is accepted. Returns the municipality.
     *
     * @return the municipality
     */
    protected static NorwegianMunicipality promptMunicipalityNumber() {
        boolean inputAccepted = false;
        NorwegianMunicipality municipality = null;

        while (!inputAccepted) {
            municipality = NorwegianMunicipality.getMunicipalityByNumber(getNonEmptyString("municipality number"));
            inputAccepted = municipality != null;
        }

        return municipality;
    }

    /**
     * Asks for the Kartverket number of an object.
     *
     * @return the number
     */
    protected static int promptKartverketNumber() {
        return promptPositiveNumber("Kartverket number");
    }
}