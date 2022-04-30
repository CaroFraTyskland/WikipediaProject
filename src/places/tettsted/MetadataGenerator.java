package places.tettsted;

import java.util.ArrayList;

public class MetadataGenerator {

    public static void main(String[] args) {
        printAreaMetadata();
    }

    /**
     * Metadata for the population of tettsteder.
     */
    public static void printPopulationMetadata() {
        ArrayList<BeftettLine> list = TettstedPopulation.splitIntoTettstedMeta();

        for (BeftettLine o : list) {
            System.out.println("|" + o.getFakeNumber() + "=" + o.getPopulation() + " <!--" + o.getTettstedNameMeta() + "-->");
        }
    }

    /**
     * Metadata for the area of tettsteder.
     */
    public static void printAreaMetadata() {
        ArrayList<BeftettLine> list = TettstedPopulation.splitIntoTettstedMeta();

        for (BeftettLine o : list) {
            System.out.println("|" + o.getFakeNumber() + "=" + o.getSize() + " <!--" + o.getTettstedNameMeta() + "-->");
        }
    }

}
