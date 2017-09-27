package airline.Model;

import airline.Processor.*;
import airline.Repository.PricingRulesRepsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Sandipa on 9/1/2017.
 */
public class Flight implements IFlight{
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

    @Override
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    @Override
    public int getCapacity(TravelClassType travelClassType)
    {
        return this.aeroplane.getCapacityByTravelClass(travelClassType);
    }

    @Override
    public int getNoOfOccupiedSeats(TravelClassType travelClassType)
    {
        return this.aeroplane.getNoOfOccupiedSeatsByTravelClass(travelClassType);
    }


    public double getBaseFare(TravelClassType travelClassType)
    {
        return this.aeroplane.getBaseFare(travelClassType);
    }

    public double getTotalFare(TravelClassType travelClassType, int requiredSeats, Optional<PricingRulesRepsitory> pricingRulesRepsitory)
    {
        Optional<IPriceProcessor> priceProcessor = PriceProcessorResolver.resolvePriceProessor(travelClassType,this);
        if(priceProcessor.isPresent() && pricingRulesRepsitory.isPresent())
        {
            priceProcessor.get().setPricingRulesRepsitory(pricingRulesRepsitory.get());
            return priceProcessor.get().applyPriceIncrement(getBaseFare(travelClassType)) * requiredSeats;
        }
        return getBaseFare(travelClassType) * requiredSeats;
    }
    public void bookSeats(TravelClassType travelClassType, int noOfSeatsTobeBooked)
    {
        if(noOfSeatsTobeBooked>0 && noOfSeatsTobeBooked <10 )
            this.aeroplane.updateSeatOccupancy(travelClassType,noOfSeatsTobeBooked);
    }

}