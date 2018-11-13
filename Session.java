/**
 * Represents a session of a course.
 * A session can be tutorial or lab.
 * A course can have multiple sessions.
 * A session can only belong to one course.
 * To be implemented by <code>Tutorial</code> or <code>Lab</code>
 * @author Group3
 * @version 1.0
 */

interface Session{
	/**
	 * Gets the number of vacancies of this session.
	 * To be implemented by <code>Tutorial</code> or <code>Lab</code>
	 * @return the number of vacancies of this session
	 */
	public int getVacancy();

	/**
	 * Gets the size of this session.
	 * To be implemented by <code>Tutorial</code> or <code>Lab</code>
	 * @return the size of this session
	 */
	public int getSize();

	/**
	 * Gets the id of this session.
	 * To be implemented by <code>Tutorial</code> or <code>Lab</code>
	 * @return the id of this session
	 */
	public int getID();
}