package airline.Model;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Sandipa on 9/1/2017.
 */
public class Flight{
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
        this( flightID,  source,  destination,  date);
        this.aeroplane = aeroplane;
    }

    public boolean isRunBetweenCities(String source, String destination){
        return this.source.equalsIgnoreCase(source)&& this.destination.equalsIgnoreCase(destination);
    }

    public boolean isDepartingOnDate(LocalDate departureDate){
        return this.departureDate.compareTo(departureDate)==0;
    }

    public boolean isSeatsAvailableInTravelClass(TravelClassType travelClassType, int noOfRequiredSeats){
        return this.aeroplane.getAvailabilityByTravelClass(travelClassType) >= noOfRequiredSeats;
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

    public int getCapacity(TravelClassType travelClassType)
    {
        return this.aeroplane.getCapacityByTravelClass(travelClassType);
    }

    public int getNoOfOccupiedSeats(TravelClassType travelClassType)
    {
        return this.aeroplane.getNoOfOccupiedSeatsByTravelClass(travelClassType);
    }
    public double getBaseFare(TravelClassType travelClassType)
    {
        return this.aeroplane.getBaseFare(travelClassType);
    }

    public void bookSeats(TravelClassType travelClassType, int noOfSeatsTobeBooked)
    {
        if(noOfSeatsTobeBooked>0 && noOfSeatsTobeBooked <10 )
            this.aeroplane.updateSeatOccupancy(travelClassType,noOfSeatsTobeBooked);
    }

}