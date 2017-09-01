package airline.Model;

/**
 * Created by Sandipa on 8/31/2017.
 */
public class Airport  {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;
    private String code;
    public Airport(String name, String code)
    {
        this.code=code;
        this.name=name;
    }


}
