package person.famouspeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Personensuche {

    public static String getBorn(String name) {
        name = name.replaceAll(" ", "+");

        try {
            URL url = new URL("https://persondata.toolforge.org/index.php?geb_ort=" + name + "&export=1&format=wiki");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String line;
            StringBuilder text = new StringBuilder();

            while ((line = br.readLine()) != null) {
                text.append("\n").append(line);
            }

            String myText = text.toString();

            myText = myText.replaceAll(" norwegischer ", " ");
            myText = myText.replaceAll(" norwegische ", " ");

            return myText;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static String getDied(String name) {

        try {
            URL url = new URL("https://persondata.toolforge.org/index.php?st_ort=" + name + "&export=1&format=wiki");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String line;
            StringBuilder text = new StringBuilder();

            while ((line = br.readLine()) != null) {
                text.append("\n").append(line);
            }

            String myText = text.toString();

            myText = myText.replaceAll(" norwegischer ", " ");
            myText = myText.replaceAll(" norwegische ", " ");

            return myText;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
