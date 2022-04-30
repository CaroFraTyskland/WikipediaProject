package articleTypes;

/**
 * Basic article without an infobox.
 */
public interface ArticleBasic {

    /**
     * Sets together the different parts of the article.
     *
     * @param article the article
     */
    static void printArticle(ArticleBasic article) {
        System.out.println(article.writeFirstParagraph() +
                "\n\n" + article.writeBasicStructure() +
                "\n\n" + article.writeSources() +
                "\n\n" + article.writeEnding());
    }

    /**
     * Writes the first paragraph of the article
     *
     * @return the first paragraph
     */
    String writeFirstParagraph();

    /**
     * Writes the basic structure of the text being seen by the reader of the article.
     *
     * @return the text
     */
    String writeBasicStructure();

    /**
     * Writes the sources section (weblinks, references and normdata if needed)
     *
     * @return the section
     */
    String writeSources();

    /**
     * Writes the category and pd (if needed) section of the article.
     *
     * @return the categories
     */
    String writeEnding();

}
