package person;

import articleTypes.ArticleBasic;
import basics.Gender;
import basics.Job;
import basics.Nation;
import templates.*;

public class PersonArticle implements ArticleBasic {

    protected static final String HEADING_LIFE = "== Leben ==\n";

    protected final Person person;
    protected final String firstNames;
    protected final String lastName;
    protected final Gender gender;
    protected final Nation nationality;
    protected final Job job;
    protected final PD pd;

    protected String article;
    protected String pronoun;

    public PersonArticle(Person person) {
        this.person = person;

        this.firstNames = person.getFirstNames();
        this.lastName = person.getLastName();
        this.nationality = person.getNationality();
        this.job = person.getJob();
        this.gender = person.getGender();
        this.pd = person.getPD();

        this.article = gender.getArticle();
        this.pronoun = gender.getPronoun(lastName);
    }

    @Override
    public String writeFirstParagraph() {
        return writeLemma();
    }

    @Override
    public String writeBasicStructure() {
        return HEADING_LIFE + "\n";
    }

    @Override
    public String writeSources() {
        return Weblinks.getWeblinksWithCommonscat() + "\n\n" + Weblinks.getReferencesSection();
    }

    public String writeEnding() {
        return Normdata.getNormdataTemplateChecked() + "\n\n" + writeCategories() + "\n" + person.getPDText();
    }

    /**
     * Write the first sentences with the name, birth date, birth place and job.
     *
     * @return the text
     */
    public String writeLemma() {
        person.setGeneralJob();
        String pictureFile = Picture.getPictureTemplate(firstNames + " " + lastName + ", ");

        String name = "'''" + firstNames + " " + lastName + "''' ";
        String birthdayText = "(* " + pd.getBirthdayWithLinks();

        if (!pd.getBirthPlaceWithLinks().equals("")) {
            birthdayText += " in " + pd.getBirthPlaceWithLinks();
        }

        birthdayText += ")";

        return pictureFile + name + birthdayText + " ist " + article + " [[" + nationality.getCountryName()
                + "|" + nationality.getAdjective(gender) + "]] " + job.getLink(gender);
    }

    protected String writeCategories() {
        return Categories.getDefaultSort(pd.getNameWithComma()) + "\n" + person.getPersonCategories();
    }


}
