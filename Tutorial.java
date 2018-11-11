import java.io.Serializable;

public class Tutorial implements Session, Serializable {
	private int size;
	private int id;
	private int vacancy;

	public Tutorial(int id, int size){
		this.size = size;
		this.id = id;
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