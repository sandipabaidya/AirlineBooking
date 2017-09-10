package airline.Model;

import java.time.LocalDate;

/**
 * Created by Sandipa on 9/9/2017.
 */
public class FlightView {
    String flightID;
    String source;
    String destination;
    LocalDate departureDate;
    double fare;
    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public double getFare() {
        return fare;
    }
}
