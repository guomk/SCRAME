import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private String matricNo;
    private String school;
    private int gender;
    private ArrayList<Record> recordList;
    private HashMap<String, Integer> allCourses;
    private int couseCount;

    public Student(String name, String matricNo, String school, int gender) {
        this.name = name;
        this.matricNo = matricNo;
        this.school = school;
        this.gender = gender;
        recordList = new ArrayList<>();
        couseCount = 0;
    }

    public void addRecord(Record record) {
        recordList.add(record);
        allCourses.put(record.getCourse().getName(), couseCount);
        couseCount++;
    }

    public boolean checkRegistered(String courseCode){
        if(allCourses.containsKey(courseCode)){
            return true;
        }
        else return false;
    }

    public String getName() {
        return this.name;
    }

    public String getMatricNo() {
        return this.matricNo;
    }

    public String getSchool() {
        return this.school;
    }

    public int getGender() {
        return this.gender;
    }
}
