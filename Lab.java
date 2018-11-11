import java.io.Serializable;

public class Lab implements Serializable, Session {

	private int vacancy;
	private int size;
	private int id;

	public Lab(int id, int size){
		this.id = id;
		this.size = size;
		this.vacancy = size;
	}

	public int getID(){
		return id;
	}

	public int getVacancy(){
		return vacancy;
	}

	public int getSize(){
		return size;
	}

	public boolean isFull() {
		return vacancy == 0;
	}

	public void registered(){
		vacancy--;
	}

	public boolean ifEmpty(){return size == vacancy;}
}