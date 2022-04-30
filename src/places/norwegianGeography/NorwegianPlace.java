package places.norwegianGeography;

import articleTypes.ArticleBasic;
import basics.norway.NorwegianProvince;
import places.municipalities.NorwegianMunicipality;

public abstract class NorwegianPlace implements ArticleBasic {

    protected NorwegianMunicipality municipality;
    protected String name;

    protected NorwegianMunicipality getMunicipality() {
        return municipality;
    }

    /**
     * Sets the name of the municipality of the place.
     *
     * @param municipality the municipality
     */
    public void setMunicipality(NorwegianMunicipality municipality) {
        this.municipality = municipality;
    }

    protected String getMunicipalityName() {
        return municipality.getName();
    }

    protected String getMunicipalityLink() {
        return municipality.getLink();
    }

    protected String getMunicipalityCategory() {
        return municipality.getMunicipalityCategory();
    }

    protected NorwegianProvince getProvince() {
        return municipality.getProvince();
    }

    protected String getProvinceName() {
        return municipality.getProvince().getName();
    }

    protected String getProvinceLink() {
        return municipality.getProvince().getLink();
    }

    protected String getProvinceNumber() {
        return municipality.getProvince().getFylkesnummerAsString();
    }

    /**
     * Sets the name of the place.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}