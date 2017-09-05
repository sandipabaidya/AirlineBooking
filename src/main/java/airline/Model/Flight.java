package airline.Model;

import java.time.LocalDate;

/**
 * Created by Sandipa on 9/1/2017.
 */
public class Flight {
    String flightID;
    String source;
    String destination;
    LocalDate departureDate;
    Aeroplane aeroplane;

    public Flight(String flightID, String source, String destination, LocalDate date, Aeroplane aeroplane) {
        departureDate = date;
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.aeroplane = aeroplane;
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
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Aeroplane getAeroplane() {
        return aeroplane;
    }

    public void setAeroplane(Aeroplane aeroplane) {
        this.aeroplane = aeroplane;
    }
}