package places.tettsted;

import articleTypes.ArticleWithInfobox;
import places.municipalities.NorwegianMunicipality;
import places.norwegianGeography.NorwegianPlace;
import templates.Categories;
import templates.sources.KartverketSource;
import templates.sources.SNLsource;

public class Tettsted extends NorwegianPlace implements ArticleWithInfobox {

    private String tettstedNumber;
    private boolean isCity;
    private boolean isAdminCentre;

    /**
     * Sets the municipality of the tettsted.
     *
     * @param municipality the municipality
     */
    public void setMunicipality(NorwegianMunicipality municipality) {
        super.setMunicipality(municipality);

        retrievePopulationAndSize();
    }

    /**
     * Uses the name and the municipality to retrieve the size and population of the tettsed.
     */
    private void retrievePopulationAndSize() {
        if (name == null || municipality == null) {
            throw new IllegalStateException("cannot retrieve population/size: name or municipality of tettsted missing");
        }

        BeftettLine line = TettstedPopulation.getTettstedByName(name, municipality);

        tettstedNumber = line.getTettstedNumber();
    }

    /**
     * Sets whether or not the place is a city.
     *
     * @param isCity if it is a city
     */
    public void setIsCity(boolean isCity) {
        this.isCity = isCity;
    }

    /**
     * Sets whether or not the place is the administrative center.
     *
     * @param isAdminCentre if it is the administrative center
     */
    public void setIsAdminCentre(boolean isAdminCentre) {
        this.isAdminCentre = isAdminCentre;
    }

    /**
     * Returns the text for the infobox.
     *
     * @return the text
     */
    @Override
    public String writeInfobox() {
        return "\n{{Infobox Ort in Norwegen\n" +
                "| Fylke = " + getProvinceNumber() + "\n" +
                "| Kommune = " + getMunicipalityLink() + "\n" +
                "| lat_deg = //\n" +
                "| lon_deg = //\n" +
                "| Einwohner = {{Metadaten Einwohnerzahl Ort NO|" + tettstedNumber + "}}\n" +
                "| Stand = {{EWD|Ort NO|}}\n" +
                "| Fläche = {{Metadaten Fläche Ort NO|" + tettstedNumber + "}}\n" +
                "| Höhe = \n" +
                "| Straßen = \n" +
                "| Schienen = \n" +
                "| Flughafen = \n" +
                "| Bild = \n" +
                "| Bildunterschrift = \n" +
                "}}";
    }

    /**
     * Writes the first paragraph based on the given information.
     *
     * @return the first paragraph
     */
    @Override
    public String writeFirstParagraph() {
        String text = "'''" + name + "''' ist eine ";

        if (isCity) {
            text += "Stadt";
        } else {
            text += "Ortschaft";
        }

        text += " in der [[Norwegen|norwegischen]] Kommune " + getMunicipalityLink() + " " +
                "in der Provinz ([[Fylke]]) [[" + getProvinceLink() + "]]. " +
                "Der Ort ";

        if (isAdminCentre) {
            text += "stellt das Verwaltungszentrum von " + getMunicipalityName() + " dar und ";
        }

        text += "hat {{EWZ|Ort NO|" + tettstedNumber + "}} Einwohner (Stand: {{EWD|Ort NO|}}).<ref name=\"ssb\">{{Metadaten Einwohnerzahl Ort NO||QUELLE}}</ref>";

        return text;
    }

    @Override
    public String writeBasicStructure() {
        return "== Geografie ==\n" + name +
                " ist ein sogenannter [[Tettsted]], also eine Ansiedlung, die für statistische Zwecke als eine Ortschaft gewertet wird.<ref name=\"ssb\" />\n\n" +
                KartverketSource.getNorgesKartSource(name) +
                "\n\n== Geschichte ==" +
                "\n\n== Wirtschaft ==";
    }

    @Override
    public String writeSources() {
        return SNLsource.getWeblinksCommonsSNLReferences(name);
    }

    @Override
    public String writeEnding() {
        String text = "";

        if (Categories.needsDefaultSort(name)) {
            text += Categories.getDefaultSort(name) + "\n";
        }
        text += getMunicipalityCategory();

        return text;
    }
}
