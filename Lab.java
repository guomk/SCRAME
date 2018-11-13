import java.io.Serializable;

/**
 * Represents a lab session of a course.
 * A course can have multiple lab sessions.
 * A lab session can only belong to one course.
 * @author Group3
 * @version 1.0
 */
public class Lab implements Serializable,Session {


	/**
	 * Number of vacancies of this lab.
	 */
	private int vacancy;

	/**
	 * Size of this lab.
	 */
	private int size;

	/**
	 * Id of this lab.
	 */
	private int id;

	/**
	 * <code>Lab</code> constructor.
	 * Creates a new lab session with given id and size of this lab.
	 * Sets initial vacancies of this lab equal to size of this lab.
	 * @param id id of this lab
	 * @param size size of this lab
	 */
	public Lab(int id, int size){
		this.id = id;
		this.size = size;
		this.vacancy = size;
	}

	/**
	 * Gets the id of this lab.
	 * @return id of this lab
	 */
	public int getID(){
		return id;
	}

	/**
	 * Gets number of vacancies of this lab.
	 * @return number of vacancies of this lab
	 */
	public int getVacancy(){
		return vacancy;
	}

	/**
	 * Gets the id of this lab.
	 * @return the id of this lab
	 */
	public int getSize(){
		return size;
	}

	/**
	 * Checks if this lab session is full or not by checking this lab's vacancy.
	 * @return A boolean value.
	 *         true if this lab is full,
	 *         false if this lab has vacancy
	 */
	public boolean isFull() {
		return vacancy == 0;
	}

	/**
	 * Reduces the number of vacancies by one when a student registers this lab session.
	 */
	public void registered(){
		vacancy--;
	}

	/**
	 * Checks if this lab session is empty or not,
	 * by checking whether the size equals to vacancy or not.
	 * @return A boolean value.
	 *         true if this lab session if empty (no student registers this lab session),
	 *         false if there are students register this lab session
	 */
	public boolean isEmpty(){return size == vacancy;}
}