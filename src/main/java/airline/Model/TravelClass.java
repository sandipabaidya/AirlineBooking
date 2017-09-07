package airline.Model;

/**
 * Created by Sandipa on 9/5/2017.
 */


public class TravelClass {

    private TravelClassType travelClassType;
    private int seatsAvailable=0;

    public TravelClass(TravelClassType travelClassType, int seatsAvailable) {
        this.travelClassType = travelClassType;
        this.seatsAvailable = seatsAvailable;
    }

    public TravelClassType getTravelClassType() {
        return travelClassType;
    }
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}
