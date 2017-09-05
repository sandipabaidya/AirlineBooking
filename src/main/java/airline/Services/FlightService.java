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

    private List<FlightSchedules> flights;
    private List<Location> locations;

    public FlightService(List<FlightSchedules> inputList, List<Location> locations )
    {
        flights = inputList;
        this.locations=locations;
    }


    public List<FlightSchedules> findFlights(SearchCriteria searchCriteria) {
        List<FlightSchedules> matchedFights = new ArrayList<FlightSchedules>();
        matchedFights = flights.stream()
            .filter(filterByDate(searchCriteria.getDepartureDate()))
            .filter(filterBySourceAndDestination(searchCriteria.getSource(), searchCriteria.getDestination()))
            .filter(filterBySeatAvailability(searchCriteria.getRequiredSeats()))
            .collect(Collectors.toList());

        return matchedFights;
    }

    public static Predicate<FlightSchedules> filterByDate(Optional<LocalDate> departureDate) {
        if (Optional.ofNullable(departureDate).equals(Optional.empty()))
            return f -> f.getDepartureDate().compareTo(LocalDate.now())>=0  ;
        else
            return f -> f.getDepartureDate().compareTo(departureDate.get())==0;
    }

    public static Predicate<FlightSchedules> filterBySourceAndDestination(String source, String destinaton) {
        return f -> f.getFlight().getSource().equalsIgnoreCase(source) && f.getFlight().getDestination().equalsIgnoreCase(destinaton);
    }

    public static Predicate<FlightSchedules> filterBySeatAvailability(int noOfRequiredSeats) {
        return f -> f.getAvailableSeats() >= noOfRequiredSeats;
    }

    public List<FlightSchedules> getFlights() {
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
    /*
    public static List<Flight> filterList(List<Flight> flights, Predicate<Flight> predicate){
        List<Flight> filteredList = new ArrayList<Flight>();
        for(Flight flight:flights){
            if(predicate.test(flight)){
                filteredList.add(flight);
            }
        }
        return filteredList;
    }
     */
}
