import java.io.Serializable;

/**
 * Represents a lecture session of a course.
 * A course can have only one lecture session.
 * A lecture session can only belong to one course.
 * @author Group3
 * @version 1.0
 */

public class Lecture implements Session, Serializable {
	/**
	 * Number of vacancies of this lecture.
	 */
	private int vacancy;

	/**
	 * Size of this lecture.
	 */
	private int size;

	/**
	 * Id of this lecture.
	 */
	private int id;

	/**
	 * <code>Lecture</code> constructor
	 * Creates a new lecture session with given id and size of this lecture.
	 * Sets initial vacancies of this lecture equal to size of this lecture.
	 * @param id id of this lecture
	 * @param size size of this lecture
	 */
	public Lecture(int id, int size){
	    this.id = id;
	    this.size = size;
	    this.vacancy = size;
    }

	/**
	 * Gets the number of vacancies of this lecture.
	 * @return the number of vacancies of this lecture
	 */
	public int getVacancy(){
		return vacancy;
	}

	/**
	 * Gets the size of this lecture.
	 * @return the size of this lecture
	 */
	public int getSize(){
		return size;
	}

	/**
	 * Gets the id of this lecture.
	 * @return the id of this lecture
	 */
	public int getID(){
	    return id;
    }

	/**
	 * Checks if this lecture session is full or not by checking this lecture's vacancy.
	 * @return a boolean value
	 *         true if this lecture is full
	 *         false if this lecture has vacancy
	 */
	public boolean isFull(){
	    return vacancy==0;
    }

	/**
	 * Reduces the number of vacancies by one when a student registers this lecture session.
	 */
	public void registered(){
        vacancy--;
    }

}