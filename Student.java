import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a student in the school.
 * A student can be enrolled in many courses.
 * @author Group3
 * @version 1.0
 */
public class Student implements Serializable {
    /**
     * Name of this student.
     */
    private String name;

    /**
     * Matric number of this student.
     */
    private String matricNo;

    /**
     * School of this student.
     */
    private String school;

    /**
     * Gender of this student.
     */
    private String gender;

    /**
     * An array of <code>Record</code> object.
     * Each <code>Record</code> object contains a 'student-course'pair and this student's mark of a course.
     */
    private ArrayList<Record> recordList;

    /**
     * A dictionary which stores all courses taken by this student.
     * key: coursecode, value: index of a course
     */
    private HashMap<String, Integer> allCourses;

    /**
     * Number of courses taken by this student
     */
    private int couseCount;

    /**
     * <code>Student</code> constructor
     * Creates a new student with given name, matricNo, school and gender.
     * @param name name of this student
     * @param matricNo matricnumber of this student
     * @param school shcool of this student
     * @param gender gender of this student
     */
    public Student(String name, String matricNo, String school, int gender) {
        this.name = name;
        this.matricNo = matricNo;
        this.school = school;
        if(gender == 1)
            this.gender = "Male";
        else if(gender == 2)
            this.gender = "Female";
        else if(gender == 3)
            this.gender = "Genderqueer";
        recordList = new ArrayList<>();
        allCourses = new HashMap<>();
        couseCount = 0;
    }

    /**
     * Adds a record of this student to <code>recordList</code>.
     * The <code>Record</code> object contains a 'student-course'pair and this student's mark of a course
     * Adds the corresponding course into the course list of this student.
     * @param record the <code>Record</code> object to be added
     */
    public void addRecord(Record record) {
        recordList.add(record);
        allCourses.put(record.getCourse().getName(), couseCount);
        couseCount++;
    }

    /**
     * Checks if this student registers the course with given coursecode.
     * @param courseCode the coursecode of the course being checked
     * @return a boolean value
     *         true if this student registers the given course
     *         false if this student dose not register the given course
     */
    public boolean checkRegistered(String courseCode){
        if(allCourses.containsKey(courseCode)){
            return true;
        }
        else return false;
    }

    /**
     * Prints the transcript of this student.
     * Inclusive of this student's personal information,
     *              overall mark and individual mark of each component of all courses taken by this student
     */
    public void printTranscript() {
        System.out.format("Name: %s\nMatric Number: %s\nGender: %s\n", name, matricNo, gender);
        System.out.println("Printing marks for all course");
        for (Record record : recordList) {
            System.out.format("%20s | %f\n", record.getCourse().getName(), record.getOverallMark());
            record.printMarks();
        }
        System.out.println();
    }

    /**
     * Gets the name of this student.
     * @return the name of this student
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the matric number of this student.
     * @return the matric number of this student
     */
    public String getMatricNo() {
        return this.matricNo;
    }

    /**
     * Gets the school of this student.
     * @return the school of this student
     */
    public String getSchool() {
        return this.school;
    }

    /**
     * Gets the gender of this student.
     * @return the gender of this student
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Gets an array of <code>Record</code> object.
     * Each Record contains a 'student-course'pair and this student's mark of a course.
     * @return the array of Record object containing 'student-course' information related to this student
     */
    public ArrayList<Record> getRecordList() {
        return recordList;
    }

}
