import java.io.Serializable;
import java.util.ArrayList;

public class Record implements Serializable {

    private Student student;
    private Course course;
    private ArrayList<Session> sessionList;

    public Record(Student student, Course course) {
        this.student = student;
        this.course = course;
        sessionList = new ArrayList<Session>();
    }

    public Course getCourse() {
        return this.course;
    }

    public Student getStudent() {
        return this.student;
    }

    public void addSession(Session s){
        sessionList.add(s);
    }

    public ArrayList getSessionList(){
        return sessionList;
    }
}
