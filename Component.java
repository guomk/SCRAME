import java.util.ArrayList;

public class Component {

    private String name;
    private float relativeWeightage;
    private ArrayList<Component> subComponents;

    public Component(String name, float relativeWeightage) {
        this.name = name;
        this.relativeWeightage = relativeWeightage;
    }

    public String getName() {
        return this.name;
    }

    public float getRelativeWeightage() {
        return this.relativeWeightage;
    }

    public ArrayList<Component> getSubComponents() {
        return this.subComponents;
    }
}
