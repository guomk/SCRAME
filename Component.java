import java.util.ArrayList;

public class Component {

    private String name;
    private ArrayList<Component> subComponents;
    private float exam_weightage;

    public Component(String name, float relativeWeightage) {
        this.name = name;
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
