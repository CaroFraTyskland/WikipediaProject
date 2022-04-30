package places.municipalities;

import articleTypes.ArticleFragment;
import basics.norway.Language;
import basics.norway.NorwegianProvince;
import person.famouspeople.Personensuche;
import places.municipalities.area.AreaConverter;
import places.municipalities.language.CitizenName;
import places.municipalities.language.LanguageForm;
import places.municipalities.population.PopulationOverTime;
import places.norwegianGeography.MountainObject;
import places.norwegianGeography.Mountains;
import templates.Weblinks;
import templates.sources.*;
import places.tettsted.BeftettLine;
import places.tettsted.TettstedPopulation;

import java.util.ArrayList;

public class NorwegianMunicipalityObject implements ArticleFragment {

    private NorwegianMunicipality municipality;
    private String municipalityNumber;
    private String municipalityName;
    private MountainObject highestMountain;
    private String adminCenter;
    private String citizenName;
    private Language language;

    public void setMunicipality(NorwegianMunicipality municipality) {
        this.municipality = municipality;
        this.municipalityName = municipality.getName();

        municipalityNumber = municipality.getMunicipalityNumber();

        highestMountain = Mountains.getHighestMountain(municipalityName);
        citizenName = CitizenName.getCitizenName(municipality);
        language = LanguageForm.getLanguageForm(municipality);
    }

    /**
     * Checks if a mountain was found. Mountains are not found if the name in the fjelltopper.csv is not the same
     * as the enum. This is the case if a municipality also has a Sámi name.
     *
     * @return if a mountain could be found
     */
    public boolean foundMountain() {
        if (highestMountain == null) {
            return false;
        }

        return !highestMountain.getMountain().equals("?");
    }

    /**
     * Checks if a citizen name was found. Not every municipality has a name for its citizens on
     * https://www.sprakradet.no/sprakhjelp/Skriverad/navn-pa-steder-og-personer/Innbyggjarnamn/
     *
     * @return if a name was found or not
     */
    public boolean foundPopulationName() {
        return !(citizenName == null || citizenName.trim().isEmpty());
    }

    public void setHighestMountain(String name, String height) {
        highestMountain = new MountainObject(name, height);
    }

    public void setAdminCenter(String adminCenter) {
        this.adminCenter = adminCenter;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public String getName() {
        return municipality.getName();
    }

    public String writeFirstParagraph() {
        String text = "'''" + municipalityName + "'''" + " ist eine [[Kommune (Norwegen)|]] im [[Norwegen|norwegischen]] [[Fylke]] [[" + municipality.getProvince().getLink() + "]]. " +
                "Die Kommune hat {{EWZ|NO|" + municipalityNumber + "}} Einwohner (Stand: {{EWD|NO|" + municipalityNumber + "}}). Verwaltungssitz ist ";

        if (adminCenter.equals(municipalityName)) {
            text += "der gleichnamige Ort " + adminCenter + ".";
        } else {
            text += "die Ortschaft [[" + adminCenter + "]].";
        }

        return text;
    }

    public String writeBasicStructure() {
        return writeGeographySection() +
                "\n\n" + writePopulationSection() +
                "\n\n" + writeHistorySection() +
                "\n\n" + writeEconomyInfrastructureSection() +
                "\n\n" + writeNameAndCoatOfArmsSection() +
                "\n\n== Persönlichkeiten ==" + Personensuche.getBorn(municipalityName);
    }

    public String writeSources() {
        return Weblinks.getWeblinksWithCommonscat() + "\n" +
                SNLsource.getSNL(municipalityName) + "\n" +
                SSBsource.getSSBMunicipalityWeblink(municipalityName);
    }

    /**
     * Writest the projects.geography section.
     *
     * @return the text
     */
    private String writeGeographySection() {
        return "== Geografie ==\n" +
                writeNeighbourMunicipalities() +
                KartverketSource.getNorgesKartSource(municipalityName + " kommune") + " " +
                writeAreaTypes() + "\n\n" +
                writeHighestPoint();
    }

    /**
     * Writes the text about the neighbouring municipalities.
     *
     * @return the text
     */
    private String writeNeighbourMunicipalities() {
        String[] neighbours = MunicipalityAPI.getNeighbourMunicipalities(municipalityNumber);

        if (neighbours == null) {
            return "";
        }

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < neighbours.length; i++) {
            if (i == 0) {
                text.append("[[").append(neighbours[i]).append("]]");
            } else if (i < neighbours.length - 1) {
                text.append(", [[").append(neighbours[i]).append("]]");
            } else {
                text.append(" und [[").append(neighbours[i]).append("]]");
            }
        }

        return "Die Gemeinde grenzt an " + text + ".";
    }

    /**
     * Write about the area and the area covered by water.
     *
     * @return the text
     */
    private String writeAreaTypes() {
        String waterArea = AreaConverter.getWaterArea(municipalityNumber).replaceAll("\\.", ",");

        return "Die Gesamtfläche der Kommune beträgt {{FL|NO|" + municipalityNumber + "|2}}&nbsp;km², " +
                "wobei [[Binnengewässer]] zusammen " + waterArea + "&nbsp;km² ausmachen." +
                SSBsource.getAreaTypeSource();
    }

    /**
     * Write a sentence about the highest mountain in the municipality.
     *
     * @return the text
     */
    private String writeHighestPoint() {
        String highestPoint = highestMountain.getMountain();

        /*
            Checking if two names are given in the csv-file and changing the information by adding
            that one name is Sámi.
         */
        if (highestPoint.contains(",")) {
            String[] names = highestPoint.split(",");

            highestPoint = names[0] + " (samisch: " + names[1] + ")";
        }

        String heightString = highestMountain.getHeight().replaceAll(",", ".");

        return "Die Erhebung " + highestPoint + " stellt mit einer Höhe von {{Höhe|" + heightString + "|NO}}" +
                " den höchsten Punkt der Kommune " + municipalityName + " dar." + KartverketSource.getHighestMountainSource();
    }

    public static String writeTettsteder(NorwegianMunicipality municipality) {
        ArrayList<BeftettLine> list = TettstedPopulation.getTettstederInMunicipality(municipality);

        if (list.size() == 0) {
            return "In der gesamten Gemeinde liegen keine [[Tettsted]]er, also keine Ansiedlungen, die für statistische Zwecke als eine Ortschaft gewertet werden.<ref>{{Metadaten Einwohnerzahl Ort NO||QUELLE}}</ref>";
        }

        if (list.size() == 1) {
            BeftettLine object = list.get(0);

            return object.getTettstedName() + " ist der einzige sogenannte [[Tettsted]], also die einzige " +
                    "Ansiedlung, die für statistische Zwecke als eine Ortschaft gewertet wird. Zum {{EWD|Ort NO|" +
                    object.getFakeNumber() + "}} lebten dort {{EWZ|Ort NO|" + object.getFakeNumber() + "}} Einwohner.<ref>{{Metadaten Einwohnerzahl Ort NO||QUELLE}}</ref>";
        }

        if (list.size() == 2) {
            BeftettLine object1 = list.get(0);
            BeftettLine object2 = list.get(1);

            return "In der Gemeinde liegen zwei sogenannte [[Tettsted]]er, also zwei " +
                    "Ansiedlungen, die für statistische Zwecke als eine Ortschaft gewertet werden. Diese sind " +
                    object1.getTettstedName() + " mit {{EWZ|Ort NO|" + object1.getFakeNumber() + "}} und " +
                    object2.getTettstedName() + " mit {{EWZ|Ort NO|" + object2.getFakeNumber() + "}} Einwohnern (Stand: {{EWD|Ort NO|" +
                    object1.getFakeNumber() + "}}).<ref>{{Metadaten Einwohnerzahl Ort NO||QUELLE}}</ref>";
        }

        StringBuilder text = new StringBuilder("In der Gemeinde liegen mehrere sogenannte [[Tettsted]]er, also mehrere " +
                "Ansiedlungen, die für statistische Zwecke als eine Ortschaft gewertet werden. Diese sind ");


        for (int i = 0; i < list.size(); i++) {
            BeftettLine object = list.get(i);

            if (i < list.size() - 2) {
                text.append(object.getTettstedName()).append(" mit Tw, ");
            } else if (i < list.size() - 1) {
                text.append(object.getTettstedName()).append(" mit {{EWZ|Ort NO|").append(object.getFakeNumber()).append("}} und ");
            } else {
                text.append(object.getTettstedName()).append(" mit {{EWZ|Ort NO|").append(object.getFakeNumber()).append("}} Einwohnern (Stand: {{EWD|Ort NO|").append(object.getFakeNumber()).append("}}).<ref>{{Metadaten Einwohnerzahl Ort NO||QUELLE}}</ref>");
            }
        }


        return text.toString();
    }

    /**
     * Write about the name of the citizens.
     *
     * @return the text
     */
    private String writeCitizenName() {
        if (citizenName.equals("-")) {
            return "";
        }

        citizenName = citizenName.replaceAll(", ", "'' oder ''");

        return "Die Einwohner der Gemeinde werden ''" + citizenName + "'' genannt." + NorwegianSource.getCitizenSprakradetSource();
    }

    /**
     * Writes that a municipality is part of the "forvaltningsområdet for samisk språk".
     *
     * @return the text.
     */
    private String writeSami() {
        return "Da " + municipalityName + " Teil des samischen Verwaltungsgebiets ist, ist die norwegische Sprache dem [[Samische Sprachen|Samischen]] gleichgestellt. Die Einwohner haben folglich unter anderem einen Anspruch darauf, die Kommunikation mit öffentlichen Organen in einer samischen Sprache laufen zu lassen." + RegjeringSource.getSamiSource();
    }

    /**
     * Write the history section.
     *
     * @return the section
     */
    private String writeHistorySection() {
        String text = "== Geschichte ==\n" + SSBsource.getKommuneHistorieSource();

        if (NorwegianProvince.isNew(municipality.getProvince())) {
            text += "\n" + writeNewProvince();
        }

        return text;
    }

    /**
     * Writes the text for a municipality formerly belonging to another province.
     *
     * @return the text
     */
    private String writeNewProvince() {
        String text = "Bis zum ";

        if (municipality.getProvince() == NorwegianProvince.TROENDELAG) {
            text += "31. Dezember 2017 gehörte " + municipalityName + " der damaligen Provinz [[-Trøndelag]] an. Sie ging im Zuge der [[Regionalreform in Norwegen]] in die zum 1. Januar 2018 neu geschaffene Provinz " + municipality.getProvinceName() + " über.";
        } else {
            text += "31. Dezember 2019 gehörte " + municipalityName + " der damaligen Provinz [[]] an. Sie ging im Zuge der [[Regionalreform in Norwegen]] in die zum 1. Januar 2020 neu geschaffene Provinz " + municipality.getProvinceName() + " über.";
        }

        return text + RegjeringSource.getRegionreformSource();
    }

    /**
     * Writes the section about the economy and the infrastructure.
     *
     * @return the text
     */
    private String writeEconomyInfrastructureSection() {
        return "== Wirtschaft und Infrastruktur ==\n=== Verkehr ===\n<ref name=\"norgeskart\" />\n\n=== Wirtschaft ===\n" +
                SNLsource.getSNLRef(municipalityName) + " " + writeCommuters();
    }

    /**
     * Write the beginning of the sentence about how many people commute.
     *
     * @return the text
     */
    private String writeCommuters() {
        return "Im Jahr 2020 arbeiteten von x Arbeitstätigen x in " + municipalityName + " selbst, ." + SSBsource.pendlingSource();
    }

    /**
     * Writes the section about the name and the coat of arms.h
     *
     * @return the text
     */
    private String writeNameAndCoatOfArmsSection() {
        return "== Name und Wappen ==\n" +
                "Das seit x offizielle Wappen der Kommune zeigt ... " +
                writeName();
    }

    /**
     * Writes some basic text about the etymology of the name.
     *
     * @return the text
     */
    private String writeName() {
        return municipalityName + " wurde im Jahr ... als ''...'' erwähnt. " +
                "Der Name setzt sich aus den beiden Bestandteilen „...“ und „...“ zusammen, erster leitet sich von ... ab, „...“ steht hingegen für „...“."
                + NorwegianSource.getStadnamnSource(municipalityName);
    }

    /**
     * Writes the population section.
     *
     * @return the text
     */
    private String writePopulationSection() {
        String text = "== Einwohner ==\n" + SNLsource.getSNLRefTag() + " " + writeTettsteder() + "\n\n";

        String citizenNameText = writeCitizenName();
        if (!citizenNameText.equals("")) {
            text += citizenNameText + " ";
        }

        text += language.writeLanguage(municipality.getProvince(), municipalityName);

        if (municipality.isSami()) {
            text += " " + writeSami();
        }

        text += "\n\n";
        text += PopulationOverTime.getPopulationTable(municipalityNumber);

        return text;
    }

    public void printPopulation() {
        System.out.println(writeTettsteder());
    }

    @Override
    public void printArticleFragment() {
        System.out.println(writeFirstParagraph() + "\n\n" + writeBasicStructure() + "\n\n" + writeSources());
    }

    private String writeTettsteder() {
        return writeTettsteder(municipality);
    }

}