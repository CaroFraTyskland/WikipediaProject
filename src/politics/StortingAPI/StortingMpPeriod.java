package politics.StortingAPI;

import basics.norway.Constituency;

public class StortingMpPeriod {

    private final String mpId;
    private final Constituency constituency;
    private final String verv;
    private final String periodId;
    private boolean hasServed;

    public StortingMpPeriod(String mpId, String fylke, String verv, String periodId) {
        this.mpId = mpId;
        this.constituency = Constituency.getByNameOrAbbreviation(fylke);
        this.verv = verv;
        this.periodId = periodId;

        hasServed = !wasVara();
    }

    public boolean isHasServed() {
        return hasServed;
    }

    public void setHasServed(boolean hasServed) {
        this.hasServed = hasServed;
    }

    public Constituency getConstituency() {
        return constituency;
    }

    public String getVerv() {
        return verv;
    }

    public String getPeriodId() {
        return periodId;
    }

    public String getPeriodStart() {
        return periodId.substring(0, 4);
    }

    public String getPeriodEnd() {
        try {
            return periodId.substring(5, 9);
        } catch (IndexOutOfBoundsException e) {
            return "2050";
        }
    }

    public boolean wasVara() {
        return verv.equals("Vararepresentant");
    }

    @Override
    public String toString() {
        return mpId + ": " + constituency + ", " + verv + " (" + periodId + ") " + hasServed;
    }
}
