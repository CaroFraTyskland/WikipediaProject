package person.famouspeople;

import articleTypes.ArticleBasic;
import console.Console;

public class FamousPeopleConsole extends Console {

    public static void main(String[] args) {
        FamousPeople famousPeople = new FamousPeople();
        famousPeople.setName(getNonEmptyString("name of city"));

        ArticleBasic.printArticle(famousPeople);
    }

}