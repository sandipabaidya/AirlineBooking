package airline.Model;

/**
 * Created by Sandipa on 9/1/2017.
 */
public class Flight {
    String flightID;
    String source;
    String destination;
    public Flight(String flightID, String source, String destination) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        flightID = flightID;
    }

}