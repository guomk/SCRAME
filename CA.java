import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class CA implements Serializable{

    /**
     * Number of CAs of a course.
     */
    private int numOfCas;

    /**
     * The total percentage of all CAs.
     */
    private double percent;

    /**
     * An array to store the weightage of each CA with respect to all CAs.
     */
    private double[] weightage;

    /**
     * An array storing names of CAs,
     * array size is changeable
     */
    private ArrayList<String> caName;


    /**
     * <code>CA</code> constructor
     * Sets the number of CAs and the total percentage.
     * @param num  total number of CAs of the course
     * @param percent  total percentage of all CAs of the course
     */
    public CA(int num, double percent) {
        this.numOfCas = num;
        this.weightage = new double[num];
        this.caName = new ArrayList<>();
        this.percent = percent;
    }

    /**
     * Adds a Coursework component.
     * @param name name of the component added
     * @param i id of the component,
     *          index of the component in array <code>caName</code>
     */
    public void setName(String name, int i) {
       caName.add(i, name);
    }

    /**
     * Sets the weightage of a added CA and store it in an array.
     * @param weightage weightage of a CA with respect to all CAs
     * @param i index of the CA in the <code>weightage</code> array
     */
    public void setWeightage(double weightage, int i) {
        this.weightage[i] = weightage;
    }

    /**
     * Gets the weightage of a CA with respect to total mark of a course.
     * @param i index of a CA in the <code>weightage </code> array
     * @return weightage of a CA with respect to total mark of a course
     */
    public double getWeightage(int i) {
        return weightage[i] * percent;
    }

    /**
     * Gets name of a CA with index i.
     * @param i the index of accessed CA in the <code>caName</code> array
     * @return name of CA with index i
     */
    public String getName(int i) {
        return caName.get(i);
    }

    /**
     * Gets the array storing all CAs of a course.
     * @return array <code>caName</code>,
     *         storing all CAs of a course
     */
    public ArrayList<String> getCaName() {
        return caName;
    }

    /**
     * Gets total percentage of all CAs with respect to total mark.
     * @return total percentage of all CAs
     */
    public double getPercent() {
        return percent;
    }
}
