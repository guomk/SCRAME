import java.util.ArrayList;
public class Course {
	private String name;
	private Component component;
	private Faculty faculty;
	private ArrayList<Record> recordList;
	private ArrayList<Lab> lab;
	private ArrayList<Tutorial> tutorial;


	public Course(String name, Faculty faculty, ArrayList<Tutorial> tutorial, ArrayList<Lab> lab){
		this.name = name;
		this.faculty = faculty;
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

	public ArrayList<Lab> getLab(){
		return lab;
	}

	public ArrayList<Tutorial> getTutorial(){
		return tutorial;
	}

	public Component getComponent(){
		return component;
	}

	public boolean isFull(){
		boolean labFull = true;
		for(Lab a:lab){
			if(!a.isFull()){
				labFull = false;
				break;
			}
		}
		boolean tutorialFull = true;
		for(Tutorial a:tutorial){
			if(!a.isFull()){
				tutorialFull = false;
				break;
			}
		}
		if(labFull || tutorialFull)
			return true;
		else return false;
	}
	
}
