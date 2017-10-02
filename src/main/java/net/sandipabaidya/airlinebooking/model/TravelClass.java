package net.sandipabaidya.airlinebooking.model;

/**
 * Created by Sandipa on 9/5/2017.
 */


public class TravelClass {

    private TravelClassType travelClassType;
    private int capacity;
    private int occupiedSeats;
    private double baseFare;

    public TravelClass(TravelClassType travelClassType, int capacity, double baseFare) {
        this.travelClassType = travelClassType;
        this.capacity = capacity;
        this.baseFare = baseFare;

    }

    public TravelClassType getTravelClassType() {
        return travelClassType;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public int getAvailableSeats() {
        return capacity - occupiedSeats;
    }

    public boolean updateSeatOccupancy(int noOfSeatsTobeBooked) {
        if (noOfSeatsTobeBooked > getAvailableSeats() || noOfSeatsTobeBooked < 1)
            return false;

        occupiedSeats += noOfSeatsTobeBooked;
        return true;
    }

    public double getBaseFare() {
        return baseFare;
    }

}
