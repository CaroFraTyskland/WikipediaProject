package places.tettsted;

import basics.norway.NorwegianProvince;

import java.util.ArrayList;

public class TettstedListForFylke {

    public static void main(String[] args) {
        printListForProvince(NorwegianProvince.INNLANDET);
    }

    private static void printListForProvince(NorwegianProvince province) {

        ArrayList<BeftettLine> list = TettstedPopulation.getTettstederInProvince(province);

        for (BeftettLine line : list) {

            System.out.println("|-");
            System.out.println("| " + line.getTettstedNumber());
            System.out.println("| ");
            System.out.println("| [[" + line.getTettstedName() + "]]");
            System.out.println("| {{EWZ|Ort NO|" + line.getTettstedNumber() + "}}");
            System.out.println("| {{Metadaten Fläche Ort NO|" + line.getTettstedNumber() + "}}");
            System.out.println("| " + line.getMunicipality().getLink());
        }
    }

}
