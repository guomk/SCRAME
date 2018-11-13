import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents a record in the system.
 * Each record contains a 'student-course' pair and the mark of the student.
 * @author Group3
 * @version 1.0
 */
public class Record implements Serializable {

    /**
     * A <code>Student</code> object which stores information of the student stored in this record.
     */
    private Student student;

    /**
     * A <code>Course</code> object which stores information of the course stored in this record.
     */
    private Course course;

    /**
     * An array of <code>Session</code> object.
     * Each <code>Session</code> object stores a lab or a tutorial session of the course taken by the student
     */
    private ArrayList<Session> sessionList;

    /**
     * An array of integer, each element stores the mark of each CA.
     */
    private int[] marks;
//    private Component component;
//    private CA ca;
//    private ArrayList<String> caName;
    /**
     * The exam mark of tht course in this record.
     */
    private int examMark;
//    private int numOfCAs;

    /**
     * <code>Record</code> object
     * Creates a record with given <code>Student</code> and <code>Course</code> object.
     * Each <code>Record</code> object contains a 'student-course'pair and the student's mark of the course.
     *
     * @param student <code>Student</code> object storing information of the student in this record
     * @param course  <code>Course</code> object storing information of the course in this record
     */
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

    /**
     * Sets the mark of each CA of the 'student-course' pair stored in this record,perform input checking.
     */
    public void setCaMarks(Scanner sc) {
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
                } catch (Exception e) {
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

    /**
     * Gets the mark of CA with index i.
     *
     * @param i the index of CA in the <code>mark</code> array
     * @return the mark of CA with index i.
     */
    public int getCaMarks(int i) {
        return marks[i];
    }

    /**
     * Prints each CA mark of the student stored in this record.
     * Consider total mark of each CA as 100.
     */
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

    /**
     * Gets the overall CA mark of the course with respect to the total mark of the course.
     *
     * @return the overall CA mark of the course with respect to the total mark of the course
     */
    public double getOverallCA() {
        Component component = course.getComponent();
        CA ca = component.getCa();
        double sum = 0;
        int cnt = 0;
        for (int i : marks) {
            sum += (double) i * ca.getWeightage(cnt);
            cnt++;
        }
        return sum;
    }

    /**
     * Sets the exam mark of the 'student-course' pair stored in this record,perform input checking.
     */
    public void setExamMark(Scanner sc) {
        int mark;
        System.out.printf("Enter mark for %s\n", "Exam");
        mark = -1;
        while (mark == -1) {
            try {
                mark = sc.nextInt();
            } catch (Exception e) {
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

    /**
     * Prints the exam mark of the student.
     */
    public void printExamMark() {
        System.out.format("%12s | %d\n", "Exam", examMark);
        System.out.println("--------------------------------------------");
        System.out.println();
    }

    public double getExamMark(){
        return examMark;
    }

    /**
     * Prints the mark of exam and each CA of the 'student-course' stored in this record.
     * Consider total mark of exam and each CA as 100
     */
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

    /**
     * Gets total mark of the course stored in this record.
     * inclusive of exam and all CAs
     *
     * @return the total mark of the course stored in this record
     */
    public double getOverallMark() {
        Component component = course.getComponent();
        CA ca = component.getCa();
        double examPart = examMark * component.getExamWeightage();
        double CaPart = getOverallCA();
        return component.getExamWeightage() * (double) examMark + getOverallCA();
    }

    public boolean hasMark(){
        return marks != null;
    }

    public int[] getMark(){
        return marks;
    }

    /**
     * Gets the <code>Course</code> object which stores information of the course stored in this record.
     *
     * @return the <code>Course</code> object which stores information of the course stored in this record
     */
    public Course getCourse() {
        return this.course;
    }

    /**
     * Gets the <code>Student</code> object which stores information of the student stored in this record.
     *
     * @return the <code>Course</code> object which stores information of the course stored in this record
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * Adds a tutorial or a lab session of the course to this record
     *
     * @param s the lab or tutorial session to be added
     */
    public void addSession(Session s) {
        sessionList.add(s);
    }



    /**
     * Gets an array of <code>Session</code> object.
     * Each <code>Session</code> object stores a lab or a tutorial session of the course taken by the student
     * @return the array of <code>Session</code> object
     */
    public ArrayList<Session> getSessionList() {
        return sessionList;
    }
}
