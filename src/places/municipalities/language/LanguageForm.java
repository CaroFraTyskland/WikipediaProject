package places.municipalities.language;

import basics.FileHelper;
import basics.norway.Language;
import places.municipalities.NorwegianMunicipality;

import java.util.Scanner;

public class LanguageForm {

    public static Language getLanguageForm(NorwegianMunicipality municipality) {
        Scanner scanner = FileHelper.readFile("vedtak.txt");

        if (scanner == null) {
            return null;
        }

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();

            if (data.contains(municipality.getMunicipalityNumber())) {
                if (data.contains("bokmål")) {
                    return Language.BOKMAAL;
                } else if (data.contains("nynorsk")) {
                    return Language.NYNORSK;
                } else if (data.contains("nøytral")) {
                    return Language.NEUTRAL;
                }
            }
        }

        return null;
    }
}