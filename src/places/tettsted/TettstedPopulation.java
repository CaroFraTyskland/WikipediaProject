package places.tettsted;

import basics.FileHelper;
import basics.norway.NorwegianProvince;
import places.municipalities.NorwegianMunicipality;

import java.util.ArrayList;
import java.util.Scanner;

public class TettstedPopulation {

    private static final ArrayList<BeftettLine> tettstedList = splitIntoTettstedMeta();
    public static int YEAR = 2020;

    /**
     * Returns the line object based on its name and municipality.
     *
     * @param name         the name of the tettsted
     * @param municipality the municipality where the tettsted is located in
     * @return the line object
     */
    public static BeftettLine getTettstedByName(String name, NorwegianMunicipality municipality) {
        for (BeftettLine line : tettstedList) {
            if (line.getTettstedName().equals(name) && line.getMunicipality() == municipality) {
                return line;
            }
        }

        return null;
    }

    /**
     * Returns a list of tettsteder in a province.
     *
     * @param province the province
     * @return the list of tettsteder
     */
    public static ArrayList<BeftettLine> getTettstederInProvince(NorwegianProvince province) {
        ArrayList<BeftettLine> tettstedListTmp = new ArrayList<>();

        for (BeftettLine object : tettstedList) {
            if (object.getMunicipality() != null && object.getMunicipality().getProvince() == province) {
                tettstedListTmp.add(object);
            }
        }

        return tettstedListTmp;
    }

    /**
     * Returns a list of tettsteder in a municipality.
     *
     * @param municipality the municipality
     * @return the list of tettsteder
     */
    public static ArrayList<BeftettLine> getTettstederInMunicipality(NorwegianMunicipality municipality) {
        ArrayList<BeftettLine> tettstedListTmp = new ArrayList<>();

        for (BeftettLine object : tettstedList) {
            if (object.getMunicipality() == municipality) {
                tettstedListTmp.add(object);
            }
        }

        return tettstedListTmp;
    }


    public static ArrayList<BeftettLine> splitIntoTettstedMeta() {
        Scanner scanner = FileHelper.readFile("INSERT PATH");
        ArrayList<BeftettLine> list = new ArrayList<>();

        if (scanner == null) {
            throw new IllegalStateException("scanner is null");
        }

        String lastTettstedNumber = "";
        String lastTettstedName = "";

        while (scanner.hasNextLine()) {
            BeftettLine currentObject;
            String data = scanner.nextLine();

            String numbers = "012345678";
            if (numbers.contains("" + data.charAt(0))) {

                currentObject = BeftettLine.getLineFromData(data);
                list.add(currentObject);

                lastTettstedNumber = currentObject.getTettstedNumber();
                lastTettstedName = currentObject.getTettstedName();

            } else if (data.charAt(1) == ';') {
                currentObject = BeftettLine.getLineFromData(data, lastTettstedName, lastTettstedNumber);
                list.add(currentObject);
            }
        }

        return list;
    }
}
