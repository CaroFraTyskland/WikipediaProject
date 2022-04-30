package politics;


import articleTypes.ArticleBasic;
import basics.Job;
import basics.norway.NorwegianProvince;
import basics.norway.Party;
import person.PersonArticle;
import templates.Weblinks;
import templates.sources.SNLsource;

public class NorwegianPoliticianArticle extends PersonArticle implements ArticleBasic {

    private final Party party;


    public NorwegianPoliticianArticle(NorwegianPolitician politician) {
        super(politician);

        this.party = politician.getParty();
    }

    /**
     * Writes the first part of the projects.general.article explaining that the projects.person is a norwegian politician.
     *
     * @return the text
     */
    @Override
    public String writeFirstParagraph() {
        String lemma = writeLemma();

        return lemma + " der " + party.getDescription() + ".";
    }

    /**
     * Writes a text with the standard weblinks for a Norwegian politician.
     *
     * @return the text
     */
    @Override
    public String writeSources() {
        String snlLink = SNLsource.getSNLPerson(firstNames, lastName);

        return Weblinks.getWeblinksWithCommonscat() + "\n" + snlLink;
    }

    /**
     * Returns text for a politician who was a member of a fylkesting if both start and end time are known.
     *
     * @param province the province
     * @param start    the first year
     * @param end      the last year
     * @return the text
     */
    public String writeFylkestingText(NorwegianProvince province, int start, int end) {
        String text = "In der Zeit zwischen " + start + " und " + end + " war " + person.getPronoun() + " ";

        text += Job.MP.getName(gender);

        text += " im [[Fylkesting]] der ";

        if (province.isFormerProvince()) {
            text += "damaligen ";
        }

        text += "Provinz " + province.getLink() + ".";

        return text;
    }

    /**
     * Returns text for a politician who was a member of a fylkesting if only the start time is known.
     *
     * @param province the province
     * @param start    the first year
     * @return the text
     */
    public String writeFylkestingText(NorwegianProvince province, int start) {

        String text = "Im Jahr " + start + " zog " + person.getPronoun() + " erstmals in das [[Fylkesting]] der ";

        if (province.isFormerProvince()) {
            text += "damaligen ";
        }

        text += "Provinz " + province.getLink() + " ein.";

        return text;
    }


}
