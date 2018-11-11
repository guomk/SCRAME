import java.util.ArrayList;
import java.util.Scanner;
public class CA {

    private int numOfCas;
    private double percent;
    private double[] weightage;
    private ArrayList<String> caName;
    private int[] marks;

    public CA(int num, double percent) {
        this.numOfCas = num;
        this.weightage = new double[num];
        this.caName = new ArrayList<>();
        this.percent = percent;
        this.marks = new int[num];
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


    public void setMarks() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numOfCas; i++) {
            System.out.printf("Enter mark for %s\n", getName(i));
            marks[i] = sc.nextInt();
        }
    }

    public int getMarks(int i) {
        return marks[i];
    }

    public void printMarks() {
        for (int i = 0; i < numOfCas; i++) {
            System.out.format("%12s | %d\n", getName(i), getMarks(i));
        }
    }
}
