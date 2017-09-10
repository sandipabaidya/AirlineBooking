package airline.Model;

import java.time.LocalDate;

/**
 * Created by Sandipa on 9/1/2017.
 */
public class Flight implements Cloneable{
    String flightID;
    String source;
    String destination;
    LocalDate departureDate;
    Aeroplane aeroplane;
    double fare;

    protected Object clone(){
        return this.clone();
    }
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
        if (getTravelClass(travelClassType)!=null)
            return getTravelClass(travelClassType).getSeatsAvailable()>= noOfRequiredSeats;
        return false;
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

    public double getTotalFare()
    {
        return this.fare;
    }

    public Flight getFlightWithTotalFare(TravelClassType travelClassType, int noOfRequiredSeats)
    {
        //Shallow Copy
        Flight cloneFlight=new Flight(this.flightID, this.source, this.destination, this.departureDate);
        cloneFlight.fare = this.getTravelClass(travelClassType).getBaseFare() * noOfRequiredSeats ;

        return cloneFlight;

    }

    private TravelClass getTravelClass(TravelClassType travelClassType){
        if (this.aeroplane != null)
            return this.aeroplane.traveClasses.stream()
                .filter(travelClass -> travelClass.getTravelClassType().equals(travelClassType))
                .findFirst().orElse(null);
        return null;
    }

}