package airline.Model;

import airline.Processor.EconomicPriceProcessor;
import airline.Processor.IPriceProcessor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sandipa on 9/1/2017.
 */
public class Flight{
    String flightID;
    String source;
    String destination;
    LocalDate departureDate;
    Aeroplane aeroplane;
    Map<TravelClassType, Integer> OccupiedSeats;
    int economicSeatsOccupied;

    public Flight(String flightID, String source, String destination, LocalDate date) {
        departureDate = date;
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        OccupiedSeats = new HashMap(){
            {
                put(TravelClassType.ECONOMY, 0);
                put(TravelClassType.BUSINESS, 0);
                put(TravelClassType.FIRSTCLASS, 0);
            }
        };
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
        return this.getNoOfAvailableSeats(travelClassType) >= noOfRequiredSeats;
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
        TravelClass travelClass = getTravelClass(travelClassType);
        if(travelClass!=null) {
            return travelClass.getCapacity();
        }

        return 0;
    }

    public int getNoOfOccupiedSeats(TravelClassType travelClassType)
    {
        return OccupiedSeats.containsKey(travelClassType)? OccupiedSeats.get(travelClassType) : 0;
    }

    public int getNoOfAvailableSeats(TravelClassType travelClassType)
    {
        return (this.getCapacity(travelClassType) - this.getNoOfOccupiedSeats(travelClassType)) ;
    }


    public double getBaseFare(TravelClassType travelClassType)
    {
        TravelClass travelClass = getTravelClass(travelClassType);
        if(travelClass!=null) {
            return travelClass.getBaseFare();
        }

        return 0;
    }

    public void bookSeats(TravelClassType travelClassType, int noOfBookedSeats)
    {
        if(noOfBookedSeats>0 && noOfBookedSeats <10 )
            OccupiedSeats.put(travelClassType, OccupiedSeats.get(travelClassType)+ noOfBookedSeats);
    }
    private TravelClass getTravelClass(TravelClassType travelClassType){
        if (this.aeroplane != null)
            return this.aeroplane.traveClasses.stream()
                .filter(travelClass -> travelClass.getTravelClassType().equals(travelClassType))
                .findFirst().orElse(null);
        return null;
    }

}