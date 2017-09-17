package airline.Model;

/**
 * Created by Sandipa on 9/5/2017.
 */


public class TravelClass {

    private TravelClassType travelClassType;
    private int capacity=0;
    private double baseFare=0;

    public TravelClass(TravelClassType travelClassType, int capacity, double baseFare) {
        this.travelClassType = travelClassType;
        this.capacity = capacity;
        this.baseFare=baseFare;
    }

    public TravelClassType getTravelClassType() {
        return travelClassType;
    }
    public int getCapacity() {
        return capacity;
    }
    public double getBaseFare() {
        return baseFare;
    }
}
