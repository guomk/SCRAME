import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class CA implements Serializable{

    private int numOfCas;
    private double percent;
    private double[] weightage;
    private ArrayList<String> caName;


    public CA(int num, double percent) {
        this.numOfCas = num;
        this.weightage = new double[num];
        this.caName = new ArrayList<>();
        this.percent = percent;
    }

    public void setName(String name, int i) {
       caName.add(i, name);
    }

    public void setWeightage(double weightage, int i) {
        this.weightage[i] = weightage;
    }

    public double getWeightage(int i) {
        return weightage[i] * percent;
    }

    public String getName(int i) {
        return caName.get(i);
    }

    public ArrayList<String> getCaName() {
        return caName;
    }

    public double getPercent() {
        return percent;
    }
}
