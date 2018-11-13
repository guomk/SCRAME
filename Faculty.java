import java.io.Serializable;

/**
 * Represents a faculty in the school.
 * A faculty can teach multiple courses.
 * @author Group3
 * @version 1.0
 */
public class Faculty implements Serializable {

    /**
     * Name of this faculty.
     */
    private String name;

    /**
     * Title of this faculty.
     */
    private String title;

    /**
     * Description of this faculty.
     */
    private String description;

    /**
     * ID of this faculty.
     */
    private String id;


    /**
     * <code>Faculty</code> constructor
     * Creates a new faculty.
     * Sets the name, title and id of this faculty.
     * @param name name of this faculty
     * @param title title of this faculty
     * @param id id of this faculty
     */
    public Faculty(String name, String title, String id) {
        this.name = name;
        this.title = title;
        this.id = id;
    }

    /**
     * <code>Faculty</code> constructor
     * Creates a new faculty.
     * Sets the name, title, description and id of this faculty.
     * @param name name of this faculty
     * @param title title of this faculty
     * @param desc description of this faculty
     * @param id id of this faculty
     */
    public Faculty(String name, String title, String desc, String id) {
        this.name = name;
        this.title = title;
        this.description = desc;
        this.id = id;
    }

    /**
     * Gets the name of this faculty.
     * @return the name of this faculty
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the title of this faculty.
     * @return the title of this faculty
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the description of this faculty.
     * @return the description of this faculty
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the description of this faculty.
     * @return the description of this faculty.
     */
    public String getId() { return this.id; }

    /**
     * Sets the name of this faculty.
     * @param name new name of this faculty
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the title of this faculty.
     * @param title new title of this faculty
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the description of this faculty.
     * @param desc new description of this faculty
     */
    public void setDescription(String desc) {
        this.description = desc;
    }

    /**
     * Sets the id of this faculty.
     * @param id new id of this faculty
     */
    public void setId(String id) { this.id = id; }

}
