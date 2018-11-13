import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Record implements Serializable {

    private Student student;
    private Course course;
    private ArrayList<Session> sessionList;
    private int[] marks;
//    private Component component;
//    private CA ca;
//    private ArrayList<String> caName;
    private int examMark;
//    private int numOfCAs;


    public Record(Student student, Course course) {
        this.student = student;
        this.course = course;
        sessionList = new ArrayList<Session>();
//        this.component = this.course.getComponent();
//        this.ca = this.component.getCa();
//        this.caName = this.ca.getCaName();
//        this.numOfCAs = component.getNumOfCAs();
//        this.marks = new int[numOfCAs];
    }

    public void setCaMarks() {
        Scanner sc = new Scanner(System.in);
        int mark;
        Component component = course.getComponent();
        CA ca = component.getCa();
        marks = new int[component.getNumOfCAs()];
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
        Component component = course.getComponent();
        CA ca = component.getCa();
        ArrayList<String> caName = ca.getCaName();
        for (int i = 0; i < component.getNumOfCAs(); i++) {
            System.out.format("%12s | %d\n", caName.get(i), marks[i]);
        }
        System.out.println("--------------------------------------------");
        System.out.println();
    }

    public double getOverallCA() {
        Component component = course.getComponent();
        CA ca = component.getCa();
        double sum = 0;
        int cnt = 0;
        for (int i : marks) {
            sum += (double)i * ca.getWeightage(cnt);
            cnt++;
        }
        return sum;
    }

    public void setExamMark() {
        Scanner sc = new Scanner(System.in);
        int mark;
        System.out.printf("Enter mark for %s\n", "Exam");
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
        this.examMark = mark;

    }

    public void printExamMark() {
        System.out.format("%12s | %d\n", "Exam", examMark);
        System.out.println("--------------------------------------------");
        System.out.println();
    }

    public void printMarks() {
        Component component = course.getComponent();
        CA ca = component.getCa();
        System.out.format("%12s | %d\n", "Exam", examMark);
        for (int i = 0; i < component.getNumOfCAs(); i++) {
            System.out.format("%12s | %d\n", ca.getName(i), getCaMarks(i));
        }
        System.out.println("--------------------------------------------");
        System.out.println();

    }

    public double getOverallMark() {
        Component component = course.getComponent();
        CA ca = component.getCa();
        double examPart = examMark * component.getExamWeightage();
        double CaPart = getOverallCA();
        return component.getExamWeightage() * (double)examMark + getOverallCA();
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

    public ArrayList<Session> getSessionList(){
        return sessionList;
    }
}
