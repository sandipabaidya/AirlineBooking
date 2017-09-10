package airline.Model;

/**
 * Created by Sandipa on 9/5/2017.
 */


public class TravelClass {

    private TravelClassType travelClassType;
    private int seatsAvailable=0;
    private double baseFare=0;

    public TravelClass(TravelClassType travelClassType, int seatsAvailable, double baseFare) {
        this.travelClassType = travelClassType;
        this.seatsAvailable = seatsAvailable;
        this.baseFare=baseFare;
    }

    public TravelClassType getTravelClassType() {
        return travelClassType;
    }
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
    public double getBaseFare() {
        return baseFare;
    }
}
