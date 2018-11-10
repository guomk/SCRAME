public class Faculty {

    private String name;
    private String title;
    private String description;
    private String id;


    public Faculty(String name, String title, String id) {
        this.name = name;
        this.title = title;
        this.id = id;
    }

    public Faculty(String name, String title, String desc, String id) {
        this.name = name;
        this.title = title;
        this.description = desc;
        this.id = id;
    }

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
