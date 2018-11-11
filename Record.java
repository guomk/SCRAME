import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Record implements Serializable {

    private Student student;
    private Course course;
    private ArrayList<Session> sessionList;
    private int[] marks;
    private Component component;
    private CA ca;
    private ArrayList<String> caName;
    private int examMark;
    private int numOfCAs;


    public Record(Student student, Course course) {
        this.student = student;
        this.course = course;
        sessionList = new ArrayList<Session>();
        this.component = this.course.getComponent();
        this.ca = this.component.getCa();
        this.caName = this.ca.getCaName();
        this.numOfCAs = component.getNumOfCAs();

    }

    public void setCaMarks() {
        Scanner sc = new Scanner(System.in);
        int mark = -1;
        for (int i = 0; i < component.getNumOfCAs(); i++) {
            System.out.printf("Enter mark for %s\n", ca.getName(i));
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

    public int getCaMarks(int i) {
        return marks[i];
    }

    public void printCaMarks() {
        for (int i = 0; i < component.getNumOfCAs(); i++) {
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
        return sum * ca.getPercent();
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
            System.out.format("%12s | %d\n", ca.getName(i), getCaMarks(i));
        }
        System.out.println("--------------------------------------------");
        System.out.println();

    }

    public double getOverallMark() {
        return component.getExamWeightage() * examMark + getOverallCA();
    }

    public Course getCourse() {
        return this.course;
    }

    public Student getStudent() {
        return this.student;
    }

    public void addSession(Session s){
        sessionList.add(s);
    }
}
