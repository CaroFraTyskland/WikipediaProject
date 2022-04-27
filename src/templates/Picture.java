package templates;

public class Picture {

    public static String getPictureTemplate(String description) {
        return "[[Datei:|mini|" + description + "]]\n";
    }

}
