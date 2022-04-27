package politics.StortingAPI;

import basics.Gender;
import basics.Month;
import basics.norway.Constituency;
import basics.norway.Party;

import java.util.ArrayList;
import java.util.List;

public class ApiConversion {

    /**
     * Retrieves the necessary basic data for a Wikipedia article of a Storting member that the API has and returns
     * the data as a data object.
     *
     * @param apiResult the api result
     * @return member data
     */
    static StortingMember retrieveStortingMemberData(String apiResult) {
        StortingMember data = new StortingMember();

        data.setLastName(getLastName(apiResult));
        data.setFirstName(getFirstName(apiResult));
        data.setGender(getGender(apiResult));
        data.setBirthMonth(getBirthMonth(apiResult));
        data.setBirthYear(getBirthYear(apiResult));
        data.setBirthDay(getBirthDay(apiResult));

        return data;
    }

    /**
     * Retrieves the necessary data for the list of Storting members and returns the data as a data object.
     *
     * @param apiResult the api result
     * @return member data
     */
    static StortingMemberListData retrieveStortingMemberListData(String apiResult) {
        StortingMemberListData data = new StortingMemberListData();

        data.setLastName(getLastNameList(apiResult));
        data.setFirstName(getFirstNameList(apiResult));
        data.setBirthYear(getBirthYearList(apiResult));

        String constituencyAbbrev = getConstituencyList(apiResult);
        data.setConstituency(Constituency.getByNameOrAbbreviation(constituencyAbbrev));

        return data;
    }

    /**
     * Takes the JSON file and extracts the data of the representatives.
     *
     * @param text the text
     * @return the data of the representatives
     */
    static List<StortingMemberListData> getStortingRepData(String text) {
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


    /**
     * Returns the last name.
     *
     * @param text the json text
     * @return the last name
     */
    static String getLastNameList(String text) {
        int indexLastName = text.indexOf("etternavn>") + 10;
        int indexLastName2 = text.indexOf("</etternavn>");

        return text.substring(indexLastName, indexLastName2);
    }

    /**
     * Returns the first name.
     *
     * @param text the json text
     * @return the first name
     */
    static String getFirstNameList(String text) {
        int indexLastName = text.indexOf("fornavn>") + 8;
        int indexLastName2 = text.indexOf("</fornavn>");

        return text.substring(indexLastName, indexLastName2);
    }

    /**
     * Returns the constituency of the person.
     *
     * @param text the json text
     * @return the constituency
     */
    static String getConstituencyList(String text) {
        int indexLastName = text.indexOf("<navn>") + 6;
        int indexLastName2 = text.indexOf("</navn>");

        return text.substring(indexLastName, indexLastName2);
    }

    /**
     * Returns the party.
     *
     * @param text the json text
     * @return the party
     */
    static String getPartyList(String text) {
        int indexLastName = text.indexOf("<navn>") + 6;
        int indexLastName2 = text.indexOf("</navn>");

        return text.substring(indexLastName, indexLastName2);
    }

    /**
     * Returns the birth year.
     *
     * @param text the json text
     * @return the birth year
     */
    static String getBirthYearList(String text) {
        int indexLastName = text.indexOf("<foedselsdato>") + 14;
        int indexLastName2 = indexLastName + 4;

        return text.substring(indexLastName, indexLastName2);
    }

    /**
     * Returns the last name.
     *
     * @param text the json text
     * @return the last name
     */
    static String getLastName(String text) {
        int indexLastName = text.indexOf("<etternavn>") + 11;
        int indexLastName2 = text.indexOf("</etternavn>");

        return text.substring(indexLastName, indexLastName2);
    }

    /**
     * Returns the first name.
     *
     * @param text the json-text
     * @return first name
     */
    static String getFirstName(String text) {
        int indexLastName = text.indexOf("<fornavn>") + 9;
        int indexLastName2 = text.indexOf("</fornavn>");

        return text.substring(indexLastName, indexLastName2);
    }

    /**
     * Returns the gender of the person
     *
     * @param text the json-text
     * @return the gender
     */
    static Gender getGender(String text) {
        int indexLastName = text.indexOf("<kjoenn>") + 8;
        int indexLastName2 = text.indexOf("</kjoenn>");

        String genderID = text.substring(indexLastName, indexLastName2);

        if (genderID.equals("mann")) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }

    /**
     * Returns the month of birth of the person
     *
     * @param text the json-text
     * @return the month
     */
    static Month getBirthMonth(String text) {
        int indexLastName = text.indexOf("<foedselsdato>") + 19;
        int indexLastName2 = text.indexOf("</foedselsdato>") - 12;

        String monthNumber = text.substring(indexLastName, indexLastName2);

        return Month.getMonthByNumber(monthNumber);
    }

    /**
     * Returns the day of birth of the person
     *
     * @param text the json-text
     * @return the day
     */
    static int getBirthDay(String text) {
        int indexLastName = text.indexOf("<foedselsdato>") + 22;
        int indexLastName2 = text.indexOf("</foedselsdato>") - 9;

        return Integer.parseInt(text.substring(indexLastName, indexLastName2));
    }

    /**
     * Returns the year of birth of the person
     *
     * @param text the json-text
     * @return the year
     */
    static int getBirthYear(String text) {
        int indexLastName = text.indexOf("<foedselsdato>") + 14;
        int indexLastName2 = text.indexOf("</foedselsdato>") - 15;

        return Integer.parseInt(text.substring(indexLastName, indexLastName2));
    }

    /**
     * Returns the birth place of the person
     *
     * @param text the json-text
     * @return the place
     */
    static String getBirthPlace(String text) {
        if (text.contains("<foede_kommune i:nil=\"true\"/>")) {
            return "";
        }

        int indexLastName = text.indexOf("<foede_kommune>") + 15;
        int indexLastName2 = text.indexOf("</foede_kommune>");

        return text.substring(indexLastName, indexLastName2);
    }

    /**
     * Returns the birth place of the person
     *
     * @param text the json-text
     * @return the place
     */
    static Party getParty(String text) {
        int indexLastName = text.indexOf("<parti_id>") + 10;
        int indexLastName2 = text.indexOf("</parti_id>");

        return Party.getPartyByAbbreviationNO(text.substring(indexLastName, indexLastName2));
    }
}