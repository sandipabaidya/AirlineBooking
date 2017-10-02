package net.sandipabaidya.airlinebooking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sandipa on 9/5/2017.
 */
public class Aeroplane {

    String planeModel;
    List<TravelClass> traveClasses;

    public Aeroplane(String planeNumber) {
        this.planeModel = planeNumber;
        traveClasses = new ArrayList<TravelClass>();
    }

    public Aeroplane(String planeNumber, List<TravelClass> traveClasses) {
        this.planeModel = planeNumber;
        this.traveClasses = traveClasses;
    }

    public String getPlaneNumber() {
        return planeModel;
    }

    public int getCapacityByTravelClass(TravelClassType travelClassType) {
        if (getMatchedTravelClass(travelClassType).isPresent())
            return getMatchedTravelClass(travelClassType).get().getCapacity();
        return 0;
    }

    public int getNoOfOccupiedSeatsByTravelClass(TravelClassType travelClassType) {
        if (getMatchedTravelClass(travelClassType).isPresent())
            return getMatchedTravelClass(travelClassType).get().getOccupiedSeats();
        return 0;
    }

    public int getAvailabilityByTravelClass(TravelClassType travelClassType) {
        if (getMatchedTravelClass(travelClassType).isPresent())
            return getMatchedTravelClass(travelClassType).get().getAvailableSeats();
        return 0;
    }

    public double getBaseFare(TravelClassType travelClassType) {
        if (getMatchedTravelClass(travelClassType).isPresent())
            return getMatchedTravelClass(travelClassType).get().getBaseFare();
        return 0;
    }

    public boolean updateSeatOccupancy(TravelClassType travelClassType, int noOfSeatsTobeBooked) {
        if (getMatchedTravelClass(travelClassType).isPresent())
            return getMatchedTravelClass(travelClassType).get().updateSeatOccupancy(noOfSeatsTobeBooked);
        return false;
    }

    public void AddTravelClass(TravelClass travelClass) {
        if (!getMatchedTravelClass(travelClass.getTravelClassType()).isPresent())
            traveClasses.add(travelClass);
    }

    private Optional<TravelClass> getMatchedTravelClass(TravelClassType travelClassType) {
        return traveClasses.stream()
            .filter(travelClass -> travelClass.getTravelClassType().equals(travelClassType))
            .findFirst();
    }
}
