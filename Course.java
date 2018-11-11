import java.util.ArrayList;
public class Course {
	private String name;
	private Component component;
	private Faculty faculty;
	private ArrayList<Record> recordList;
	private ArrayList<Lab> lab;
	private ArrayList<Tutorial> tutorial;
	private Lecture lecture;


	public Course(String name, Faculty faculty, Lecture lecture, ArrayList<Tutorial> tutorial, ArrayList<Lab> lab){
		this.name = name;
		this.faculty = faculty;
		this.lecture = lecture;
		this.lab = lab;
		this.tutorial = tutorial;
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
	
}
