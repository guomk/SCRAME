import java.util.ArrayList;
public class Course {
	private String name;
	private Component component;
	private String faculty;
	private ArrayList<Record> recordList;
	private ArrayList<Lab> lab;
	private ArrayList<Tutorial> tutorial;


	public Course(String name, String faculty, ArrayList<Tutorial> tutorial, ArrayList<Lab> lab){
		this.name = name;
		this.faculty = faculty;
		this.lab = lab;
		this.tutorial = tutorial;
	}
	public String getName(){
		return name;
	}

	public String getFaculty(){
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

	
}
