package places.municipalities;

import basics.norway.NorwegianProvince;

/**
 * Contains the data about a Norwegian municipality that can be accessed through
 * https://ws.geonorge.no/kommuneinfo/v1//kommuner/{kommunenummer}
 */

public class MunicipalityData {

    private final NorwegianProvince province;
    private String municipalityName;
    private boolean samiPlace;

    public MunicipalityData(String fylkesnummer) {
        province = NorwegianProvince.getProvinceByNumber(fylkesnummer);
    }

    /**
     * Sets the name of the municipality.
     *
     * @param name the name
     */
    void setMunicipalityName(String name) {
        municipalityName = name;
    }

    public NorwegianProvince getProvince() {
        return province;
    }

    public boolean isSamiPlace() {
        return samiPlace;
    }

    /**
     * Sets whether or not a place is "samisk forvaltninsområde".
     *
     * @param samiPlace whether or not it is Sámi
     */
    void setSamiPlace(boolean samiPlace) {
        this.samiPlace = samiPlace;
    }

    @Override
    public String toString() {
        return "MunicipalityData{" +
                "muniName='" + municipalityName + '\'' +
                ", province=" + province +
                ", samiPlace=" + samiPlace +
                '}';
    }
}
