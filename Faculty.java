public class Faculty {

    private String name;
    private String title;
    private String description;


    public Faculty(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public Faculty(String name, String title, String desc) {
        this.name = name;
        this.title = title;
        this.description = desc;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }


}
