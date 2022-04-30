package places.norwegianGeography;

import basics.FileHelper;

import java.util.Scanner;

/**
 * The CSV file with the data is not provided in this copy of the project.
 */
public class Mountains {

    public static MountainObject getHighestMountain(String municipalityName) {
        //File created by copy-pasting data from website (not the code, the actual site) into calc and saving it as csv
        Scanner scanner = FileHelper.readFile("INSERT PATH HERE");

        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] values = line.split(";");

                if (values[1].equals(municipalityName)) {
                    return new MountainObject(values[2], values[3]);
                }
            }
        }

        return new MountainObject();
    }
}