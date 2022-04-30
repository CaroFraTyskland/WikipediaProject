package politics.Storting;

import articleTypes.ArticleBasic;
import basics.Job;
import basics.norway.Constituency;
import person.Person;
import politics.NorwegianPoliticianArticle;
import politics.StortingAPI.StortingMpPeriod;
import templates.Categories;
import templates.Weblinks;
import templates.sources.SNLsource;
import templates.sources.StortingSource;

import java.util.ArrayList;

public class StortingMPArticle extends NorwegianPoliticianArticle implements ArticleBasic {

    private final StortingMP stortingMP;

    public StortingMPArticle(StortingMP stortingMP) {
        super(stortingMP);
        this.stortingMP = stortingMP;
    }

    /**
     * Writes the first paragraph of the projects.general.article.
     *
     * @return the paragraph
     */
    @Override
    public String writeFirstParagraph() {
        return super.writeFirstParagraph() + " " + writeMpPeriodShort();
    }

    @Override
    public String writeBasicStructure() {
        return writeLife();
    }

    /**
     * Writes a text with the standard weblinks for a Norwegian politician.
     *
     * @return the text
     */
    @Override
    public String writeSources() {
        String stortingLink = StortingSource.getStortingWeblink(stortingMP.getStortingId(), person.getName());
        String snlLink = SNLsource.getSNLPerson(firstNames, lastName);

        return Weblinks.getWeblinksWithCommonscat() + "\n" + stortingLink + "\n" + snlLink + "\n\n" + Weblinks.getReferencesSection();
    }


    /**
     * Returns the information since when a projects.person is MP. Used in the first paragraph.
     *
     * @return the sentence
     */
    public String writeMpPeriodShort() {
        ArrayList<StortingMpPeriod> periods = stortingMP.getPeriods();

        if (periods == null || periods.size() == 0) {
            throw new IllegalStateException("MpTime without periods");
        }

        String periodStart = periods.get(0).getPeriodStart();


        return "Seit " + periodStart + " ist " + person.getPronoun() + " " + Job.MP.getName(gender) +
                " im [[Storting]].";
    }

    /**
     * Writes a short paragraph about the life of the politician.
     *
     * @return the text
     */
    private String writeLife() {
        String source = StortingSource.getStortingReferencesById(stortingMP.getStortingId());
        return HEADING_LIFE + writeMpTime(stortingMP) + source;
    }


    /**
     * Writes the paragraph explaining the politicians time in the parliament.
     *
     * @param person the person who is MP
     * @return the text explaining the time in parliament
     */
    public String writeMpTime(Person person) {
        ArrayList<StortingMpPeriod> periods = stortingMP.getPeriods();

        if (periods == null || periods.size() == 0) {
            throw new IllegalStateException("MpTime without periods");
        }

        for (StortingMpPeriod period : periods) {
            if (period.isHasServed()) {
                String periodStart = period.getPeriodStart();
                String constituency = period.getConstituency().getName();

                if (period.wasVara()) {
                    String text = lastName + " gelang es bei der [[Parlamentswahl in Norwegen " + periodStart +
                            "|Parlamentswahl " + periodStart + "]] nicht, direkt in das norwegische Nationalparlament [[Storting]] einzuziehen." +
                            " Stattdessen wurde " + person.getPronoun() + " ";

                    switch (gender) {
                        case FEMALE -> text = text + "sogenannte [[Vararepresentant]]in, also Ersatzabgeordnete,";
                        case MALE -> text = text + "sogenannter [[Vararepresentant]], also Ersatzabgeordneter,";
                        case NON_BINARY -> text = text + "[[Vararepresentant|Vararepresentant/in]]";
                    }

                    text += " im Wahlkreis " + period.getConstituency() + ". Als ";

                    text = switch (gender) {
                        case FEMALE -> text + "solche kam sie ab xxxx zum Einsatz.";
                        case MALE -> text + "solcher kam er ab xxxx zum Einsatz.";
                        case NON_BINARY -> text + "Vararepresentant/in kam " + lastName + " ab xxxx zum Einsatz.";
                        default -> text;
                    };

                    return text;
                }

                return lastName + " zog bei der [[Parlamentswahl in Norwegen " + periodStart +
                        "|Parlamentswahl " + periodStart + "]] erstmals in das norwegische Nationalparlament [[Storting]] ein." +
                        " Dort vertritt " + person.getPronoun() + " den Wahlkreis [[" + constituency + "]].";
            }
        }

        return "";
    }



    /**
     * Writes the text with the categories assigned to the politician.
     *
     * @return the text
     */
    protected String writeCategories() {
        StringBuilder categoryText = new StringBuilder(stortingMP.getDefaultSort() + "\n");

        //Categories for all the constituencies
        ArrayList<Constituency> constituencies = stortingMP.getConstituencies();
        for (Constituency constituency : constituencies) {
            categoryText.append(Categories.createCategory("Storting-Abgeordneter (" + constituency + ")"));
        }

        //standard categories (nation, birth year, gender)
        categoryText.append(stortingMP.getBasicCategories());

        return categoryText.toString();
    }
}