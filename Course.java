import java.util.ArrayList;
public class Course {
	private String name;
	private Component component;
	private ArrayList<Faculty> faculty;
	private ArrayList<Record> recordList;
	private ArrayList<Lab> lab;
	private ArrayList<Tutorial> tutorial;
	private ArrayList<Lecture> lecture;


	public Course(String name, Component component, ArrayList<Faculty> faculty, ArrayList<Record> recordList, ArrayList<Lab> lab, ArrayList<Lecture> lecture, ArrayList<Tutorial> tutorial){
		this.name = name;
		this.faculty = faculty;
		this.recordList = recordList;
		this.component = component;
		this.lab = lab;
		this.tutorial = tutorial;
		this.lecture = lecture;
	}
	public String getName(){
		return name;
	}

	public ArrayList<Faculty> getFaculty(){
		return faculty;
	}

	public ArrayList<Record> getRecordList(){
		return recordList;
	}

	public ArrayList<Lab> getLab(){
		return lab;
	}

	public ArrayList<Lecture> getLecture(){
		return lecture;
	}

	public ArrayList<Tutorial> getTutorial(){
		return tutorial;
	}

	public Component getComponent(){
		return component;
	}

	
}
