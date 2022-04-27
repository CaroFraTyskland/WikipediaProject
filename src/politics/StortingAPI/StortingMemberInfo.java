package politics.StortingAPI;

import basics.norway.Party;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to retrieve info about a specific member of Storting through the API.
 */
public class StortingMemberInfo {

    private final String code;
    private final String id;

    public StortingMemberInfo(String id) {
        this.id = id;
        this.code = getStortingBiographyCode(id);
    }

    public static void main(String[] args) {
        System.out.println(getStortingBiographyCode("ssc"));
    }

    /**
     * Returns list of Storting periods a certain MP has served.
     *
     * @param id   the mp id
     * @param code the code of the api
     * @return the list of periods
     */
    public static ArrayList<StortingMpPeriod> getStortingPeriods(String id, String code) {
        ArrayList<StortingMpPeriod> list = new ArrayList<>();

        if (!code.contains("<stortingsperiode_kodet_liste>")) {
            return list;
        }

        String codeTmp = code.substring(code.indexOf("<stortingsperiode_kodet_liste>"), code.indexOf("</stortingsperiode_kodet_liste>"));


        while (codeTmp.contains("<person_biografi_stortingsperiode_kodet>")) {
            String period = codeTmp.substring(codeTmp.indexOf("<person_biografi_stortingsperiode_kodet>"), codeTmp.indexOf("</person_biografi_stortingsperiode_kodet>"));

            String fylke = period.substring(period.indexOf("<fylke>") + 7, period.indexOf("</fylke>"));
            String verv = period.substring(period.indexOf("<verv>") + 6, period.indexOf("</verv>"));
            String periodId = period.substring(period.indexOf("<stortingsperiode_id>") + 21, period.indexOf("</stortingsperiode_id>"));

            StortingMpPeriod periodInfo = new StortingMpPeriod(id, fylke, verv, periodId);

            list.add(periodInfo);

            codeTmp = codeTmp.substring(codeTmp.indexOf("</person_biografi_stortingsperiode_kodet>") + 30);
        }

        checkIfVaraHasServed(code, list);

        return list;
    }

    public static void checkIfVaraHasServed(String code, ArrayList<StortingMpPeriod> periods) {
        if (periods == null || !code.contains("<permisjon_kodet_liste>")) {
            return;
        }

        while (code.contains("<person_biografi_permisjon_kodet>")) {
            String period = code.substring(code.indexOf("<person_biografi_permisjon_kodet>"), code.indexOf("</person_biografi_permisjon_kodet>"));


            String type = period.substring(period.indexOf("<type>") + 6, period.indexOf("</type>"));

            if (type.equals("VARA")) {


                int indexFrom = period.indexOf("<fra_dato>") + 10;
                int indexTo = period.indexOf("<til_dato>") + 10;


                int fromDate = Integer.parseInt(period.substring(indexFrom, indexFrom + 4));
                int toDate = Integer.parseInt(period.substring(indexTo, indexTo + 4));

                for (StortingMpPeriod mpPeriod : periods) {
                    if (fromDate >= Integer.parseInt(mpPeriod.getPeriodStart()) &&
                            toDate <= Integer.parseInt(mpPeriod.getPeriodEnd())) {
                        mpPeriod.setHasServed(true);
                    }
                }

            }

            code = code.substring(code.indexOf("</person_biografi_permisjon_kodet>") + 10);
        }
    }

    private static String getStortingBiographyCode(String id) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;

        try {
            String url = "https://data.stortinget.no/eksport/kodetbiografi?personid=" + id.toUpperCase();

            /*
                Saves the data of the Storting API.
             */
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(url).openStream());

            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));

            return writer.getBuffer().toString();

        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves the data of a representative with a given id.
     *
     * @param id the id
     * @return the data of the representative
     */
    public static StortingMember getDataByID(String id) {
        String text = getBasicMemberAPI(id);

        if (text == null) {
            return null;
        }

        StortingMember data = ApiConversion.retrieveStortingMemberData(text);
        setBiographyDataByID(id, data);

        return data;
    }

    /**
     * Retrieves the basic data of a MP (name, sex, party...)
     *
     * @param id the MP id
     * @return the result of the api query
     */
    private static String getBasicMemberAPI(String id) {
        String text;
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;

        try {
            String url = "https://data.stortinget.no/eksport/person?personid=" + id.toUpperCase();

            /*
                Saves the data of the Storting API.
             */
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(url).openStream());

            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));

            text = writer.getBuffer().toString();

        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
            return null;
        }

        return text;
    }

    /**
     * Retrieves the data of a MP with a given id.
     *
     * @param id the id
     */
    public static void setBiographyDataByID(String id, StortingMember data) {
        String biographyCode = getStortingBiographyCode(id);

        if (biographyCode == null) {
            System.out.println("no biography code for the MP found");
            return;
        }

        data.setParty(ApiConversion.getParty(biographyCode));
        data.setBirthPlace(ApiConversion.getBirthPlace(biographyCode));
    }

    /**
     * Returns list of Storting periods the MP has served.
     *
     * @return the list of periods
     */
    public ArrayList<StortingMpPeriod> getStortingPeriods() {
        return getStortingPeriods(id, code);
    }

    /**
     * Takes the JSON file and extracts the data of the MPa.
     *
     * @param text the text
     * @return the data of the representatives
     */
    private static List<StortingMemberListData> getStortingRepData(String text) {
        List<StortingMemberListData> list = new ArrayList<>();

        /*
            Goes through the list of representatives and saves the data of the current representative.
         */
        for (int i = 0; i < 169; i++) {
            StortingMemberListData data = ApiConversion.retrieveStortingMemberListData(text);
            data.setRepresentantNumber(i + 1);

            /*
                Cuts off the data of the current representative.
            */
            int index = text.indexOf("</fylke>") + 10;
            text = text.substring(index);

            data.setParty(Party.getPartyByName(ApiConversion.getPartyList(text)));
            list.add(data);

            index = text.indexOf("</representant>") + 10;
            text = text.substring(index);
        }

        return list;
    }
}