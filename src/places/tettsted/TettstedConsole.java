package places.tettsted;

import articleTypes.ArticleWithInfobox;
import console.NorwegianConsole;

public class TettstedConsole extends NorwegianConsole {

    /**
     * Runs through the projects.general.console dialog for a Norwegian tettsted.
     */
    public static void runThrough() {
        Tettsted tettsted = getTettstedFromConsole();

        ArticleWithInfobox.printArticle(tettsted);
    }

    /**
     * Asks the necessary questions for a Norwegian tettsted and returns a tettsted object.
     *
     * @return the tettsted
     */
    public static Tettsted getTettstedFromConsole() {
        Tettsted tettsted = new Tettsted();

        tettsted.setName(getNonEmptyString("name"));
        tettsted.setMunicipality(promptMunicipality());
        tettsted.setIsCity(promptYesNo("is city"));
        tettsted.setIsAdminCentre(promptYesNo("is administrative center"));

        return tettsted;
    }

}