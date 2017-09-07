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

    public Flight(String flightID, String source, String destination, LocalDate date) {
        departureDate = date;
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
    }
    public Flight(String flightID, String source, String destination, LocalDate date, Aeroplane aeroplane) {
        departureDate = date;
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.aeroplane = aeroplane;
    }

    public boolean isRunBetweenCities(String source, String destination){
        return this.source.equalsIgnoreCase(source)&& this.destination.equalsIgnoreCase(destination);
    }

    public boolean isDepartingOnDate(LocalDate departureDate){
        return this.departureDate.compareTo(departureDate)==0;
    }

    public boolean isSeatsAvailableInTravelClass(TravelClassType travelClassType, int noOfRequiredSeats){
        return this.aeroplane.getAvailableSeatsByTravelClass(travelClassType)>= noOfRequiredSeats;
    }


    public double getPriceforTravelClass(TravelClassType travelClassType)
    {
        return 0;
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }


    public Aeroplane getAeroplane() {
        return aeroplane;
    }


}