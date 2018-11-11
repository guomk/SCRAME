import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Course implements Serializable {
	private String name;
	private Component component;
	private Faculty faculty;
	private ArrayList<Record> recordList;
	private ArrayList<Lab> lab;
	private ArrayList<Tutorial> tutorial;
	private Lecture lecture;
	private HashMap<String, Integer> allStudents;
	private HashMap<Integer, Integer> labDic;
	private HashMap<Integer, Integer> tutorialDic;



	public Course(String name, Faculty faculty, Lecture lecture, ArrayList<Tutorial> tutorial, ArrayList<Lab> lab, HashMap<Integer, Integer> tutorialDic, HashMap<Integer, Integer> labDic){
		this.name = name;
		this.faculty = faculty;
		this.lecture = lecture;
		this.lab = lab;
		this.tutorial = tutorial;
		this.tutorialDic = tutorialDic;
		this.labDic = labDic;
	}
	public String getName(){
		return name;
	}

	public Faculty getFaculty(){
		return faculty;
	}

	public ArrayList<Record> getRecordList(){
		return recordList;
	}

	public Lecture getLecture(){
		return lecture;
	}

	public ArrayList<Lab> getLab(){
		return lab;
	}

	public int getLabNumber(){
		return lab.size();
	}

	public ArrayList<Tutorial> getTutorial(){
		return tutorial;
	}

	public int getTutorialNumber(){
		return tutorial.size();
	}

	public Component getComponent(){
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

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

	public int checkTutorial(int id){
		if(tutorialDic.containsKey(id)){
			return tutorialDic.get(id);
		}
		else return -1;
	}

	public int checkLab(int id){
		if(labDic.containsKey(id)){
			return labDic.get(id);
		}
		else
			return -1;
	}

	public HashMap<Integer, Integer> getTutorialDic() {
		return tutorialDic;
	}

	public HashMap<Integer, Integer> getLabDic() {
		return labDic;
	}
}
