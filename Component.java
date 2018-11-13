import java.io.Serializable;
import java.util.ArrayList;

public class Component implements Serializable {

    /**
     * Weightage of exam of a course.
     */
    private double examWeightage;
    /**
     * A CA object recording name and weightage of all CAs of a course.
     */
    private CA ca;

    /**
     * The number of CAs of a course.
     */
    private int numOfCAs;

    /**
     * <code>Component</code> constructor
     * Sets the exam weightage and number of CAs.
     * @param exam_weightage weightage of exam of the course
     * @param numOfCAs number of CAs of the course
     */
    public Component(double exam_weightage, int numOfCAs) {
        this.examWeightage = exam_weightage;
        this.numOfCAs = numOfCAs;
        this.ca = new CA(numOfCAs, 1-exam_weightage);
    }


    /**
     * Gets the <code>CA</code> object which stores information of all CAs of a course.
     * @return <code>CA</code> object which stores information of all CAs of a course
     */
    public CA getCa() {
        return ca;
    }

    /**
     * Prints the name and component weightage of a course.
     * inclusive of exam, all components of coursework
     */
    public void printComponents() {
        System.out.println("Component of the course: ");
        System.out.format("%12s | %.2f\n", "Exam",  examWeightage);
        for (int i = 0; i < numOfCAs; i++) {
            System.out.format("%12s | %.2f\n", ca.getName(i), ca.getWeightage(i));
        }
        System.out.println();
    }

    /**
     * Gets weightage of exam with respect to the total mark of a course.
     * @return weightage of exam with respect to the total mark of a course
     */
    public double getExamWeightage() {
        return examWeightage;
    }

    /**
     * Gets the number of CAs of a course.
     * @return the number of CAs of a course
     */
    public int getNumOfCAs() {
        return numOfCAs;
    }
}
