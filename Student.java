import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Student implements Serializable {
    private String name;
    private String matricNo;
    private String school;
    private String gender;
    private ArrayList<Record> recordList;
    private HashMap<String, Integer> allCourses;
    private int couseCount;

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

    public void printTranscript() {
        System.out.format("Name: %s\nMatric Number: %s\nGender: %s\n", name, matricNo, gender);
        System.out.println("Printing marks for all course");
        for (Record record : recordList) {
            System.out.format("%12s | %f\n", record.getCourse().getName(), record.getOverallMark());
            record.printMarks();
        }
        System.out.println();
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

    public String getGender() {
        return this.gender;
    }

    public ArrayList<Record> getRecordList() {
        return recordList;
    }

}
