package places.municipalities.area;

import basics.FileHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class AreaConverter {

    public static void main(String[] args) {
        //System.out.println(getWaterArea("3038"));

        convert();
    }

    /**
     * Converts the table into the metadata (Vorlage:Metadaten Fl�che NO)
     */
    private static void convert() {
        Scanner scanner = FileHelper.readFile("INSERT PATH HERE");
        ArrayList<AreaObject> objects = new ArrayList<>();

        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] values = line.split(";");

                int municipalityNumber = extractMunicipalityNumber(values[0]);
                String municipalityName = extractMunicipalityName(values[0]);

                AreaObject object = new AreaObject(municipalityName, municipalityNumber, values[3]);
                objects.add(object);
            }
        }

        objects.sort(AreaObject::compareTo);

        for (AreaObject object : objects) {
            System.out.println(object.toString());
        }
    }

    private static int extractMunicipalityNumber(String text) {
        return Integer.parseInt(text.substring(text.indexOf("K-") + 2, text.indexOf(" ")));
    }

    private static String extractMunicipalityName(String text) {
        return text.substring(text.indexOf(" ") + 1, text.length() - 1);
    }

    /**
     * Returns the area that is covered in water of a certain municipality.
     *
     * @param municipalityNumber the number of the municipality
     * @return the area
     */
    public static String getWaterArea(String municipalityNumber) {
        Scanner scanner = FileHelper.readFile("INSERT PATH HERE");

        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] values = line.split(";");

                if (values[0].contains(municipalityNumber)) {
                    return values[2];
                }
            }
        }

        return "0";
    }
}