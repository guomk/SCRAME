import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a course in the system.
 * A course can be enrolled by a limited number(course size) of students.
 * @author Group3
 * @version 1.0
 */
public class Course implements Serializable {
	/**
	 * Name of this course.
	 */
	private String name;

	/**
	 * <code>Component</code> object storing components of this course.
	 * inclusive of exam and coursework
	 */
	private Component component;

	/**
	 * <code>Faculty</code> object which stores information of the faculty who teaches this course.
	 * information includes: name, title, description and id
	 */
	private Faculty faculty;

	/**
	 * An array of <code>Record</code> object.
	 * Each <code>Record</code> object contains a 'student-course'pair and the student's mark of this course.
	 */
	private ArrayList<Record> recordList;

	/**
	 * An array of <code>Lab</code> object.
	 * Each <code>Lab</code> object stores information of a lab session of this course.
	 */
	private ArrayList<Lab> lab;

	/**
	 * An array of <code>Tutorial</code> object.
	 * each <code>Tutorial</code> object stores information of a tutorial session of this course.
	 */
	private ArrayList<Tutorial> tutorial;

	/**
	 *<code>Lecture</code> object that stores information of lecture of this course.
	 * information includes: vacancy, size and id
	 */
	private Lecture lecture;

	/**
	 * A dictionary which stores name of all students taking this course.
	 * key: MatricNumber of Student, value: index of student
	 */
	private HashMap<String, Integer> allStudents; //??????????????????????????????????????????????

	/**
	 * A dictionary which stores all labs of this course.
	 * key: lab id , value: index of a lab in the lab array
	 */
	private HashMap<Integer, Integer> labDic;

	/**
	 * A dictionary which stores all tutorials of this course.
	 * key: tutorial id , value: index of a tutorial in the lab array
	 */
	private HashMap<Integer, Integer> tutorialDic;

	/**
	 * Number of students registered to this course.
	 */
	private int studentCount;


	/**
	 * <code>Course</code> constructor
	 * Creates a course with  course name, faculty who teaches this course,
	 *                       information of lecture, tutorial, lab
	 *                       of this course.
	 * @param name name of this course
	 * @param faculty a <code>Faculty</code> object which stores information of the faculty who teaches this course
	 * @param lecture a <code>Lecture</code> object which stores information of lecture of this course
	 * @param tutorial an array of all <code>Tutorial</code> object, each object stores information of a tutorial session of this course
	 * @param lab an array of <code>Lab</code> object,each object stores information of a lab session of this course
	 * @param tutorialDic a dictionary which stores all tutorials of this course
	 * @param labDic a dictionary which stores all labs of this course
	 */
	public Course(String name, Faculty faculty, Lecture lecture, ArrayList<Tutorial> tutorial, ArrayList<Lab> lab, HashMap<Integer, Integer> tutorialDic, HashMap<Integer, Integer> labDic){
		this.name = name;
		this.faculty = faculty;
		this.lecture = lecture;
		this.lab = lab;
		this.tutorial = tutorial;
		this.tutorialDic = tutorialDic;
		this.labDic = labDic;
		this.studentCount = 0;
		recordList = new ArrayList<>();
		allStudents = new HashMap<>();
	}

	/**
	 * Gets name of this course(Coursecode).
	 * @return name of this course
	 */
	public String getName(){
		return name;
	}

	/**
	 * Gets a <code>Faculty</code> object which stores information of the faculty who teaches this course.
	 * @return a <code>Faculty</code> object which stores information of the faculty who teaches this course
	 */
	public Faculty getFaculty(){
		return faculty;
	}

	/**
	 * Gets an array of <code>Record</code> object.
	 * Each Record contains a 'student-course'pair and the student's mark of this course.
	 * @return the array of Record object containing 'student-course' information related to this course
	 */
	public ArrayList<Record> getRecordList(){
		return recordList;
	}

	/**
	 * Gets the <code>Lecture</code> object which stores lecture information of this course.
	 * @return the <code>Lecture</code> object which stores lecture information of this course
	 */
	public Lecture getLecture(){
		return lecture;
	}

	/**
	 * Gets the array of <code>Lab</code> object which stores lab information of this course.
	 * @return an array of <code>Lab</code> object which stores lab information of this course
	 */
	public ArrayList<Lab> getLab(){
		return lab;
	}

	/**
	 * Gets the number of labs of this course.
	 * @return the number of labs of this course
	 */
	public int getLabNumber(){
		return lab.size();
	}

	/**
	 * Gets the array of <code>Tutorial</code> object which stores tutorial information of this course.
	 * @return an array of <code>Tutorial</code> object which stores tutorial information of this course
	 */
	public ArrayList<Tutorial> getTutorial(){
		return tutorial;
	}

	/**
	 * Gets the number of tutorials of this course.
	 * @return the number of tutorials of this course
	 */
	public int getTutorialNumber(){
		return tutorial.size();
	}

	/**
	 * Gets a <code>Component</code> object which stores exam and coursework weightage of this course.
	 * @return the <code>Component</code> object which stores exam and coursework weightage of this course
	 */
	public Component getComponent(){
		return component;
	}

	/**
	 * Sets the course component of this course.
	 * @param component a <code>Component</code> object that stores exam and coursework weightage of this course
	 */
	public void setComponent(Component component) {
		this.component = component;
	}

	public boolean hasComponent(){
		return component != null;
	}
	/**
	 * Checks whether this course if full or not.
	 * Checking is done by individually checking whether lecture, labs and tutorials are full or not.
	 * @return a boolean value
	 *         true if the course if full
	 *         (course is full if any of lecture, labs or tutorials are full)
	 *         false if this course has vacancy
	 */
	public boolean isFull(){
		boolean lectureFull = true;
		Lecture lecture = this.getLecture();
		if (!lecture.isFull()) {
			lectureFull = false;
		}
		boolean labFull = false;
		if(!lab.isEmpty()) {
			labFull = true;
			for (Lab a : lab) {
				if (!a.isFull()) {
					labFull = false;
					break;
				}
			}
		}
		boolean tutorialFull = false;
		if (!tutorial.isEmpty()) {
			tutorialFull = true;
			for (Tutorial a : tutorial) {
				if (!a.isFull()) {
					tutorialFull = false;
					break;
				}
			}
		}
		if(labFull || tutorialFull || lectureFull)
			return true;
		else return false;
	}

	/**
	 * Checks whether this course contains the tutorial with ID: id or not.
	 * Checking is done by checking whether <code>tutorialDic</code> contains the key 'id' or not.
	 * @param id id of the tutorial session being checked
	 * @return an integer value
	 *         if course contains this tutorial, return the index of the tutorial in the <code>tutorial</code> array
	 *         if course dose not contain this tutorial, -1 will be returned to indicate
	 */
	public int checkTutorial(int id){
		if(tutorialDic.containsKey(id)){
			return tutorialDic.get(id);
		}
		else return -1;
	}

	/**
	 * Checks whether this course contains the lab with ID: id or not.
	 * Checking is done by checking whether <code>labDic</code> contains the key 'id' or not.
	 * @param id id of the lab session being checked
	 * @return an integer value
	 * 	       if course contains this lab, return the index of the lab in the <code>lab</code> array
	 * 	       if course dose not contain this lab, -1 will be returned to indicate
	 */
	public int checkLab(int id){
		if(labDic.containsKey(id)){
			return labDic.get(id);
		}
		else
			return -1;
	}

	/**
	 * Gets the Dictionary <code>tutorialDic</code> that contains all information of all tutorials of this course.
	 * @return  a collection of all tutorials of this course
	 *          It contains all information of all tutorials of this course.
	 */
	public HashMap<Integer, Integer> getTutorialDic() {
		return tutorialDic;
	}

	/**
	 * Gets the Dictionary <code>labDic</code> that contains all information of all labs of this course.
	 * @return a collection of all labs of this course
	 *         It contains all information of all labs of this course
	 */
	public HashMap<Integer, Integer> getLabDic() {
		return labDic;
	}

	/**
	 * Adds a record of this course to <code>recordList</code>.
	 * The <code>Record</code> object contains a 'student-course'pair and the student's mark of this course
	 * Adds the corresponding student into the student list of this course.
	 * @param record the <code>Record</code> object to be added
	 */
	public void addRecord(Record record) {
		recordList.add(record);
		allStudents.put(record.getStudent().getMatricNo(), studentCount);
		studentCount++;
	}
}
