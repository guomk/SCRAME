import java.util.ArrayList;

public class Student {
    private String name;
    private String matricNo;
    private String school;
    private String gender;
    private ArrayList<Record> recordList;

    public Student(String name, String matricNo, String school, String gender) {
        this.name = name;
        this.matricNo = matricNo;
        this.school = school;
        this.gender = gender;
        recordList = new ArrayList<Record>();
    }

    public void addRecord(Record record) {
        recordList.add(record);
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
}
