package places.tettsted;

import places.municipalities.NorwegianMunicipality;

public class BeftettLine {

    private final String tettstedNumber;
    private final String fakeNumber;
    private final String tettstedName;
    private final int population;
    private final double size;
    private final NorwegianMunicipality municipality;

    public BeftettLine(String name, String tettstedNumber, String fakeNumber, int population, double size, NorwegianMunicipality municipality) {
        this.tettstedName = name;
        this.tettstedNumber = tettstedNumber;
        this.fakeNumber = fakeNumber;
        this.population = population;
        this.size = size;
        this.municipality = municipality;
    }

    public static BeftettLine getLineFromData(String line) {
        return getLineFromData(line, retrieveTettstedName(line), retrieveTettstedNumber(line));
    }

    public static BeftettLine getLineFromData(String line, String tettstedName, String tettstedNumber) {
        String numbers = "012345678";

        boolean splitMunicipality = !numbers.contains("" + line.charAt(0));

        double size = Double.parseDouble(retrieveSize(line, splitMunicipality));
        int population = Integer.parseInt(retrievePopulation(line, splitMunicipality));

        String fakeNumber;

        if (!splitMunicipality) {
            tettstedName = retrieveTettstedName(line);
            tettstedNumber = retrieveTettstedNumber(line);
            fakeNumber = tettstedNumber;
        } else {
            fakeNumber = tettstedNumber + line.substring(2, 6);
        }

        NorwegianMunicipality municipality = retrieveMunicipality(line);

        return new BeftettLine(tettstedName, tettstedNumber, fakeNumber, population, size, municipality);
    }

    private static NorwegianMunicipality retrieveMunicipality(String line) {
        int indexStart = line.indexOf(";") + 1;
        int indexEnd = line.indexOf(";") + 5;

        return NorwegianMunicipality.getMunicipalityByNumber(line.substring(indexStart, indexEnd));
    }

    /**
     * Retrieves the size from the line.
     *
     * @param line              the line
     * @param splitMunicipality whether or not it is in only one municipality
     * @return the size
     */
    public static String retrieveSize(String line, boolean splitMunicipality) {
        return retrieveInfoFromSection(line, splitMunicipality, 5).replace(",", ".");
    }

    /**
     * Retrieves the population from the line.
     *
     * @param line              the line
     * @param splitMunicipality whether or not the line represents in only one of several municipalities
     * @return the population
     */
    public static String retrievePopulation(String line, boolean splitMunicipality) {
        return retrieveInfoFromSection(line, splitMunicipality, 3);
    }

    /**
     * Retrieves info from a certain section (separated by ;) of the line.
     *
     * @param line              the line
     * @param splitMunicipality whether or not the line represents in only one of several municipalities
     * @param sectionNumber     the section number from where the info should be retrieved
     * @return the info
     */
    private static String retrieveInfoFromSection(String line, boolean splitMunicipality, int sectionNumber) {
        if (sectionNumber < 1) {
            throw new IllegalArgumentException("illegal section number");
        }

        if (splitMunicipality) {
            sectionNumber = sectionNumber + 1;
        }

        String clippedLine = line;
        for (int i = 0; i < sectionNumber - 1; i++) {
            int index = clippedLine.indexOf(";") + 1;
            clippedLine = clippedLine.substring(index);
        }

        int indexEnd = clippedLine.indexOf(";");

        return clippedLine.substring(0, indexEnd);
    }


    /**
     * Returns the name of the tettsted.
     *
     * @return the name
     */
    public static String retrieveTettstedName(String line) {
        int endIndex = line.indexOf(";");

        String name = line.substring(5, endIndex);
        name = name.replaceAll(" i alt", "");

        return name;
    }


    /**
     * Returns the name of the tettsted or the name of the municipality if it is a split tettsted.
     *
     * @return the name
     */
    public static String retrieveTettstedForMetadata(String line, boolean splitMunicipality) {
        int endIndex = line.indexOf(";");

        if (splitMunicipality) {
            return "Kommune " + line.substring(endIndex + 6, line.indexOf("; ;"));
        }

        return retrieveTettstedName(line);
    }

    /**
     * Returns the number of the tettsted.
     *
     * @return the number
     */
    public static String retrieveTettstedNumber(String line) {
        return line.substring(0, 4);
    }


    public String getTettstedNumber() {
        return tettstedNumber;
    }

    public String getFakeNumber() {
        return fakeNumber;
    }

    /**
     * Tettsted name for the metalist. Uses the municipality name if it is a split tettsted.
     *
     * @return the name
     */
    public String getTettstedNameMeta() {
        if (!fakeNumber.equals(tettstedNumber)) {
            return "Kommune " + municipality.getName();
        }

        return tettstedName;
    }

    public String getTettstedName() {
        return tettstedName;
    }

    public int getPopulation() {
        return population;
    }

    public double getSize() {
        return size;
    }

    public NorwegianMunicipality getMunicipality() {
        return municipality;
    }
}