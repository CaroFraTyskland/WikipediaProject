package person.famouspeople;

import articleTypes.ArticleBasic;
import templates.Categories;

/**
 * Creates an article about the famous people of a certain city. (e. g. [[Liste von Persönlichkeiten der Stadt Tromsø]]).
 */
public class FamousPeople implements ArticleBasic {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String writeFirstParagraph() {
        return "[[Datei:" + name + " komm.svg|125px|rechts]]\n" +
                "Die '''Liste von Persönlichkeiten der Stadt " + name + "''' enthält Personen, die in [[" + name + "]] geboren wurden sowie solche, die dort zeitweise gelebt haben, jeweils chronologisch aufgelistet nach dem Geburtsjahr.";
    }

    @Override
    public String writeBasicStructure() {
        String headingBorn = "== In " + name + " geborene Persönlichkeiten ==";
        String people = getPeople();
        String otherPeople = getDiedInPlace();

        String headings = "=== Bis 1899 ===\n\n=== 1900–1949 ===\n\n=== 1950–1974 ===\n\n=== Seit 1975 ===\n\n== Personen mit Bezug zu " + name + " ==";

        return headingBorn + people + "\n\n" + headings + otherPeople;
    }

    private String getPeople() {
        return Personensuche.getBorn(name);
    }

    private String getDiedInPlace() {
        return Personensuche.getDied(name);
    }

    @Override
    public String writeSources() {
        return "";
    }

    @Override
    public String writeEnding() {
        return Categories.createCategory("Person (" + name + ")|!") +
                Categories.createCategory("Liste (Personen nach Ort in Norwegen)|" + name + "") +
                Categories.createCategory("Wikipedia:Liste|Personlichkeiten " + name);
    }

}
