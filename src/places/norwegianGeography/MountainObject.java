package places.norwegianGeography;

public class MountainObject {

    private final String mountain;
    private final String height;

    public MountainObject(String mountain, String height) {
        this.mountain = mountain;
        this.height = height;
    }

    public MountainObject() {
        this.mountain = "?";
        this.height = "?";
    }

    public String getHeight() {
        return height;
    }

    public String getMountain() {
        return mountain;
    }
}
