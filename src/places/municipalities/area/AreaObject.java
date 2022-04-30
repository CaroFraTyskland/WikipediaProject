package places.municipalities.area;

public class AreaObject implements Comparable<AreaObject> {

    private final String name;
    private final int number;
    private final String areaTotal;


    public AreaObject(String name, int number, String areaTotal) {
        this.name = name;
        this.number = number;
        this.areaTotal = areaTotal;
    }

    @Override
    public int compareTo(AreaObject o) {
        if (o.number > number) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "| " + number + " = " + areaTotal + " <!-- " + name + " -->";
    }


}
