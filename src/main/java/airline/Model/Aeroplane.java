package airline.Model;

import java.util.Map;

/**
 * Created by Sandipa on 9/5/2017.
 */
public class Aeroplane {

    String planeNumber;
    Map<TravelClassType, TravelClass> traveClasses;

    public Aeroplane(String planeNumber, Map<TravelClassType, TravelClass> traveClasses) {
        this.planeNumber = planeNumber;
        this.traveClasses = traveClasses;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public Map<TravelClassType, TravelClass> getTraveClasses() {
        return traveClasses;
    }

    public void setTraveClasses(Map<TravelClassType, TravelClass> traveClasses) {
        this.traveClasses = traveClasses;
    }
}
