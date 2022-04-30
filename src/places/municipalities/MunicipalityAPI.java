package places.municipalities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MunicipalityAPI {

    public static String[] getNeighbourMunicipalities(String number) {
        try {
            URL url = new URL("https://ws.geonorge.no/kommuneinfo/v1//kommuner/" + number + "/nabokommuner?filtrer=kommunenavnNorsk");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String text = br.readLine();
            text = text.substring(1, text.length() - 1);
            String[] municipalities = text.split("},");

            for (int i = 0; i < municipalities.length; i++) {
                municipalities[i] = municipalities[i].substring(21);

                int index = municipalities[i].indexOf("\"");
                municipalities[i] = municipalities[i].substring(0, index);
            }

            conn.disconnect();
            return municipalities;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static MunicipalityData getMunicipalityData(String municipalityNumber) {
        MunicipalityData data = null;

        try {
            URL url = new URL("https://ws.geonorge.no/kommuneinfo/v1//kommuner/" + municipalityNumber);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String text = br.readLine();

            data = new MunicipalityData(getFylkesnummer(text));
            data.setMunicipalityName(getMunicipalityName(text));
            data.setSamiPlace(getIsSamiPlace(text));

            conn.disconnect();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private static String getFylkesnummer(String text) {
        int indexStart = text.indexOf("fylkesnummer") + 15;
        int indexEnd = text.indexOf("\",\"gyldigeNavn\"");

        return text.substring(indexStart, indexEnd);
    }

    private static String getMunicipalityName(String text) {
        int indexStart = text.indexOf("kommunenavnNorsk") + 19;
        int indexEnd = text.indexOf("\",\"kommunenummer\"");

        return text.substring(indexStart, indexEnd);
    }

    private static boolean getIsSamiPlace(String text) {
        int indexStart = text.indexOf("samiskForvaltningsomrade") + 26;

        text = text.substring(indexStart);

        return text.equals("true}");
    }
}