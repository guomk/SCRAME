import java.io.Serializable;
import java.util.ArrayList;

public class Component implements Serializable {

    private double examWeightage;
    private CA ca;
    private int numOfCAs;
    private int examMark;

    public Component(double exam_weightage, int numOfCAs) {
        this.examWeightage = exam_weightage;
        this.numOfCAs = numOfCAs;
        this.ca = new CA(numOfCAs, 1-exam_weightage);
    }


    public CA getCa() {
        return ca;
    }

    public void printComponents() {
        System.out.println("Component of the course: ");
        System.out.format("%12s | %.2f\n", "Exam",  examWeightage);
        for (int i = 0; i < numOfCAs; i++) {
            System.out.format("%12s | %.2f\n", ca.getName(i), ca.getWeightage(i));
        }
        System.out.println();
    }

    public void setExamMark(int examMark) {
        this.examMark = examMark;
    }

    public void printExamMark() {
        System.out.format("%12s | %d\n", "Exam", examMark);
        System.out.println("--------------------------------------------");
        System.out.println();
    }

    public void printMarks() {
        System.out.format("%12s | %d\n", "Exam", examMark);
        for (int i = 0; i < numOfCAs; i++) {
            System.out.format("%12s | %d\n", ca.getName(i), ca.getMarks(i));
        }
        System.out.println("--------------------------------------------");
        System.out.println();

    }

    public double getOverallMark() {
        return examWeightage * examMark + ca.getOverallCA();
    }
}
