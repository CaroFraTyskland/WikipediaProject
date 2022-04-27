package basics;

import basics.Gender;

public enum Job {

    ACTOR("Schauspieler", "Schauspielerin", "Schauspieler/in", "Schauspieler"),
    POLITICIAN("Politiker", "Politikerin", "Politiker/in", "Politiker"),
    VARA("Vararepresentant", "Vararepresentantin", "Vararepresentant/in", "Vararepresentant"),
    MP("Abgeordneter", "Abgeordnete", "Abgeordnete/r", null),
    SINGER("Sänger", "Sängerin", "Sänger/in", "Gesang"),
    OTHER("", "", "", null);

    private final String nameMale;
    private final String nameFemale;
    private final String nameNB;
    private final String linkToWikipediaArticle;

    /**
     * Enum describing a type of job.
     *
     * @param nameMale               the name of the job for a male person
     * @param nameFemale             the name of the job for a female person
     * @param nameNB                 the name of the job for a non-binary person
     * @param linkToWikipediaArticle the link to the wikipedia article about the job
     */
    Job(String nameMale, String nameFemale, String nameNB, String linkToWikipediaArticle) {
        this.nameMale = nameMale;
        this.nameFemale = nameFemale;
        this.nameNB = nameNB;
        this.linkToWikipediaArticle = linkToWikipediaArticle;
    }

    /**
     * Returns the link based on the gender of the person.
     *
     * @param gender the gender
     * @return the link
     */
    public String getLink(Gender gender) {
        String jobName = getName(gender);

        if (linkToWikipediaArticle == null) {   //if there is no wiki article
            return jobName;
        }

        if (jobName.equals(linkToWikipediaArticle)) {   //if the job name and wikipedia article name are the same
            return "[[" + linkToWikipediaArticle + "]]";
        }

        /*
            If the wikipedia article name is part of the job name. E. g. [[Politiker]]in.
         */
        if (jobName.contains(linkToWikipediaArticle)) {
            return jobName.replace(linkToWikipediaArticle, "[[" + linkToWikipediaArticle + "]]");
        }

        return "[[" + linkToWikipediaArticle + "|" + jobName + "]]";
    }

    /**
     * Returns the name of the job based on the given gender.
     *
     * @param gender the gender
     * @return the job name
     */
    public String getName(Gender gender) {
        return switch (gender) {
            case MALE -> nameMale;
            case FEMALE -> nameFemale;
            case NON_BINARY -> nameNB;
            default -> throw new IllegalStateException("unknown gender");
        };
    }
}
