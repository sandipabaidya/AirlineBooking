package airline.Model;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sandipa on 9/5/2017.
 */
public class Aeroplane {

    String planeModel;
    List<TravelClass> traveClasses;

    public Aeroplane(String planeNumber) {
        this.planeModel = planeNumber;
        traveClasses=new ArrayList<TravelClass>();
    }
    public Aeroplane(String planeNumber, List<TravelClass> traveClasses) {
        this.planeModel = planeNumber;
        this.traveClasses = traveClasses;
    }

    public String getPlaneNumber() {
        return planeModel;
    }

    public int getAvailableSeatsByTravelClass(TravelClassType travelClassType)
    {
        TravelClass matchTravelClass=traveClasses.stream()
                .filter(travelClass -> travelClass.getTravelClassType().equals(travelClassType))
                .findAny().orElse(null);
        if(matchTravelClass!=null)
            return matchTravelClass.getSeatsAvailable();
        return 0;
    }
    public void AddTravelClass(TravelClass travelClass) {
            traveClasses.add( travelClass);
    }
}
