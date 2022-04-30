package templates;

public class Normdata {

    private static final String NORMDATA_TEXT = "{{Normdaten|TYP=p|GND=|LCCN=|VIAF=|GNDfehlt=|GNDCheck=}}";

    public static String getNormdataTemplateChecked() {
        return "{{Normdaten|TYP=p|GND=|LCCN=|VIAF=|GNDfehlt=ja|GNDCheck=" + Weblinks.getTodaysDate() + "}}";
    }

}
