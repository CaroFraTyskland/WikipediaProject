package articleTypes;

/**
 * Article with an infobox.
 */
public interface ArticleWithInfobox extends ArticleBasic {

    /**
     * Prints the article with the different parts of it (infobox, sources...)
     *
     * @param article the thing the text should be about
     */
    static void printArticle(ArticleWithInfobox article) {
        System.out.println(article.writeInfobox() + "\n" + article.writeFirstParagraph() + "\n\n" + article.writeBasicStructure() +
                "\n\n" + article.writeSources() + "\n\n" + article.writeEnding());
    }

    /**
     * Writes the infobox of the article
     *
     * @return the infobox
     */
    String writeInfobox();

}