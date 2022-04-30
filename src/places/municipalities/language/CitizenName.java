package places.municipalities.language;

import basics.FileHelper;
import places.municipalities.NorwegianMunicipality;

import java.util.ArrayList;
import java.util.Scanner;

public class CitizenName {

    public static String getCitizenName(NorwegianMunicipality municipality) {
        return getCitizenName(readInTxtFile(), municipality);
    }

    private static String readInTxtFile() {
        // PATH IS NOT PROVIDED IN THIS COPY OF THE PROJECT
        Scanner scanner = FileHelper.readFile("INSERT PATH HER", false);

        StringBuilder builder = new StringBuilder();

        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                builder.append(data).append("\n");
            }
        }

        return builder.toString();
    }

    private static String getCitizenName(String text, NorwegianMunicipality municipality) {
        String[] parts = text.split("\n\n");

        ArrayList<String> names = new ArrayList<>();

        for (String part : parts) {
            String[] lines = part.split("\n");

            NorwegianMunicipality muni = NorwegianMunicipality.getMunicipalityByName(lines[1]);

            if (muni != null && muni == municipality) {
                names.add(lines[0]);
            }
        }

        StringBuilder articleText;

        if (names.isEmpty()) {
            return "";
        } else {

            String citizenName = names.get(0).substring(0, 1).toUpperCase() + names.get(0).substring(1);

            articleText = new StringBuilder(citizenName);

            if (names.size() > 1) {
                for (int i = 1; i < names.size(); i++) {
                    citizenName = names.get(i).substring(0, 1).toUpperCase() + names.get(i).substring(1);

                    articleText.append("'' oder ''").append(citizenName);
                }
            }

        }

        return articleText.toString();
    }

}
