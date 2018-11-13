import java.io.Serializable;

/**
 * Represents a tutorial session of a course.
 * A course can have multiple tutorial sessions.
 * A tutorial session can only belong to one course.
 * @author Group3
 * @version 1.0
 */
public class Tutorial implements Session, Serializable {
	/**
	 * Size of this tutorial.
	 */
	private int size;

	/**
	 * Id of this tutorial.
	 */
	private int id;

	/**
	 * Number of vacancies of this tutorial.
	 */
	private int vacancy;

	/**
	 * <code>Tutorial</code> constructor
	 * Creates a new tutorial session with given id and size.
	 * Sets initial vacancies of this tutorial equal to size of this tutorial.
	 * @param id id of this tutorial
	 * @param size size of this tutorial
	 */
	public Tutorial(int id, int size){
		this.size = size;
		this.id = id;
		this.vacancy = size;
	}

	/**
	 * Gets the id of this tutorial.
	 * @return the id of this tutorial
	 */
	public int getID(){
		return id;
	}

	/**
	 * Gets the number of vacancies of this tutorial.
	 * @return the number of vacancies of this tutorial
	 */
	public int getVacancy(){
		return vacancy;
	}

	/**
	 * Gets tht size of this tutorial.
	 * @return the size of this tutorial
	 */
	public int getSize(){
		return size;
	}

	/**
	 * Checks if this tutorial session is full or not by checking this tutorial's vacancy.
	 * @return a boolean value
	 * 	       true if this tutorial is full
	 * 	       false if this tutorial has vacancy
	 */
	public boolean isFull() {
		return vacancy == 0;
	}

	/**
	 * Reduces the number of vacancies by one when a student registers this tutorial session.
	 */
	public void registered(){
		vacancy--;
	}

	/**
	 * Checks if this tutorial session is empty or not,
	 * by checking whether the size equals to vacancy or not.
	 * @return a boolean value
	 *         true if this tutorial session if empty (no student registers this tutorial session)
	 *         false if there are students register this tutorial session
	 */
	public boolean isEmpty(){return size == vacancy;}


}