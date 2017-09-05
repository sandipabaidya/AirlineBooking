package airline.Services;

import airline.Model.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Sandipa on 9/1/2017.
 */
public class FlightService {

    private List<Flight> flights;
    private List<Location> locations;

    public FlightService(List<Flight> inputList, List<Location> locations )
    {
        flights = inputList;
        this.locations=locations;
    }


    public List<Flight> findFlights(SearchCriteria searchCriteria) {
        List<Flight> matchedFights = new ArrayList<Flight>();
        matchedFights = flights.stream()
            .filter(filterByDate(searchCriteria.getDepartureDate()))
            .filter(filterBySourceAndDestination(searchCriteria.getSource(), searchCriteria.getDestination()))
            .filter(filterByTravelClass(searchCriteria.getTravelClassType()))
            .filter(filterBySeatAvailability(searchCriteria.getRequiredSeats(), searchCriteria.getTravelClassType()))
            .collect(Collectors.toList());

        return matchedFights;
    }


    public static Predicate<Flight> filterByDate(Optional<LocalDate> departureDate) {
        if (Optional.ofNullable(departureDate).equals(Optional.empty()))
            return f -> f.getDepartureDate().compareTo(LocalDate.now())>=0  ;
        else
            return f -> f.getDepartureDate().compareTo(departureDate.get())==0;
    }

    public static Predicate<Flight> filterBySourceAndDestination(String source, String destinaton) {
        return f -> f.getSource().equalsIgnoreCase(source) && f.getDestination().equalsIgnoreCase(destinaton);
    }

    public static Predicate<Flight> filterByTravelClass(TravelClassType travelClassType) {
        return f -> f.getAeroplane().getTraveClasses().containsKey(travelClassType) &&
                f.getAeroplane().getTraveClasses().get(travelClassType).getSeatsAvailable()>0;
    }

    public static Predicate<Flight> filterBySeatAvailability(int noOfRequiredSeats, TravelClassType travelClassType) {
        return f -> f.getAeroplane().getTraveClasses().containsKey(travelClassType) &&
                f.getAeroplane().getTraveClasses().get(travelClassType).getSeatsAvailable()>=noOfRequiredSeats;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Location> getSourceLocations() {
        return locations;
    }

    public List<Location> getDestinationLocations() {
        return locations;
    }


    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

}
