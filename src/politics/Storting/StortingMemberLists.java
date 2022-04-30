package politics.Storting;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import politics.StortingAPI.ApiConversion;
import politics.StortingAPI.StortingMemberListData;

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
import java.util.List;

public class StortingMemberLists {

    private static final int periodStart = 2009;
    private static final List<StortingMemberListData> list = getList();

    /**
     * Prints a short list of all members (name + party).
     */
    public static void printListOfMembers() {
        if (list != null) {
            for (StortingMemberListData data : list) {
                System.out.println(data.getName() + " (" + data.getParty().getAbbreviation() + ")");
            }
        }
    }

    /**
     * Picks a random member of the parliament and prints name + party.
     *
     * @return a random member
     */
    public static String getRandomMember() {
        if (list != null) {
            int random = (int) (Math.random() * list.size());
            StortingMemberListData data = list.get(random);

            return data.getName() + " (" + data.getParty().getAbbreviation() + ")";
        }

        return "";
    }

    /**
     * Returns the list of Storting members which is retrieved from the Storting API.
     *
     * @return list of the data to the Storting members
     */
    public static List<StortingMemberListData> getList() {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        String text;

        try {
            int periodEnd = periodStart + 4;
            String url = "https://data.stortinget.no/eksport/representanter?stortingsperiodeid=" + periodStart + "-" + periodEnd + "";

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

        return ApiConversion.getStortingRepData(text);
    }
}