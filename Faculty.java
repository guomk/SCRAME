import java.io.Serializable;

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

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() { return this.id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public void setId(String id) { this.id = id; }

}
