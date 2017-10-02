package net.sandipabaidya.airlinebooking.model;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
