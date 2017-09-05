package airline.Model;

/**
 * Created by Sandipa on 9/4/2017.
 */
public class Location {

    private String id;
    private String name;

    public Location(String inputId, String inputName) {
        id = inputId;
        name = inputName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}