public class Lab{
	
	private int vacancy;
	private int size;
	private int id;

	public Lab(int id, int size){
		this.id = id;
		this.size = size;
		this.vacancy = size;
	}

	public int getVcancy(){
		return vacancy;
	}

	public int getSize(){
		return size;
	}
}