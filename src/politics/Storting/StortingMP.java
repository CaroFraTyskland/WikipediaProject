package politics.Storting;

import basics.norway.Constituency;
import politics.NorwegianPolitician;
import politics.StortingAPI.StortingMember;
import politics.StortingAPI.StortingMemberInfo;
import politics.StortingAPI.StortingMpPeriod;

import java.util.ArrayList;

public class StortingMP extends NorwegianPolitician {

    private String stortingId;
    private ArrayList<StortingMpPeriod> periods;

    public String getStortingId() {
        return stortingId;
    }

    public ArrayList<StortingMpPeriod> getPeriods() {
        return periods;
    }

    /**
     * Sets the Storting Id, the constituency and periods of a MP.
     *
     * @param stortingId the id
     */
    public void setStortingInformation(String stortingId) {
        this.stortingId = stortingId;

        StortingMemberInfo info = new StortingMemberInfo(stortingId);
        periods = info.getStortingPeriods();

        setDataFromStortingAPI();
    }

    /**
     * Retrieves the list of constituencies (usually only one) the MP has been a member for in the Storting.
     *
     * @return the list of constituencies
     */
    public ArrayList<Constituency> getConstituencies() {
        ArrayList<Constituency> constituencies = new ArrayList<>();

        if (periods != null) {
            for (StortingMpPeriod period : periods) {
                /*
                    Adds the constituency if it is not yet in the list and the MP was not only a vara
                 */
                if (!constituencies.contains(period.getConstituency()) && !period.wasVara()) {
                    constituencies.add(period.getConstituency());
                }
            }
        }

        return constituencies;
    }


    /**
     * Reads out certain values from the Storting API.
     */
    private void setDataFromStortingAPI() {
        StortingMember data = StortingMemberInfo.getDataByID(stortingId);

        if (data == null) {
            throw new IllegalStateException("no data found");
        }

        setGender(data.getGender());
        setLastName(data.getLastName());
        setFirstNames(data.getFirstName());
        setBirthMonth(data.getBirthMonth());
        setBirthyear(data.getBirthYear());
        setBirthday(data.getBirthDay());
        setParty(data.getParty());
        setBirthplace(data.getBirthPlace());
    }

}
