package basics;

public enum Gender {

    FEMALE("sie", "Frau", "eine"),
    MALE("er", "Mann", "ein"),
    NON_BINARY("?", "Nichtbinäre Person", "eine/r");

    private final String pronoun;
    private final String wikipediaCategory;
    private final String article;

    Gender(String pronoun, String wikipediaCategory, String article) {
        this.pronoun = pronoun;
        this.wikipediaCategory = wikipediaCategory;
        this.article = article;
    }

    /**
     * Returns the pronoun used for the gender or the last name if the person is non-binary.
     *
     * @return the pronoun
     */
    public String getPronoun(String lastName) {
        if (this == NON_BINARY) {
            return lastName;
        }

        return pronoun;
    }

    /**
     * Returns the name of the category assigned to this gender
     *
     * @return the category
     */
    public String getWikipediaCategory() {
        return wikipediaCategory;
    }

    /**
     * Returns the article (grammar) used for the gender.
     *
     * @return the article
     */
    public String getArticle() {
        return article;
    }
}