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
        int mark = -1;
        for (int i = 0; i < numOfCas; i++) {
            System.out.printf("Enter mark for %s\n", getName(i));
            mark = -1;
            while (mark == -1) {
                try {
                    mark = sc.nextInt();
                }
                catch (Exception e) {
                    sc.next();
                    mark = -1;
                    System.out.println("The input is not valid, please enter an integer between 0 and 100\n");
                    continue;
                }
                if (mark < 0 || mark > 100) {
                    mark = -1;
                    System.out.println("The input is not valid, please enter an integer between 0 and 100\n");
                    continue;
                }
            }
            marks[i] = mark;
        }
    }

    public int getMarks(int i) {
        return marks[i];
    }

    public void printMarks() {
        for (int i = 0; i < numOfCas; i++) {
            System.out.format("%12s | %d\n", caName.get(i), marks[i]);
        }
        System.out.println("--------------------------------------------");
        System.out.println();
    }

    public double getOverallCA() {
        int sum = 0;
        for (int i : marks) {
            sum += i;
        }
        return sum * percent;
    }

}
