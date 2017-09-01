package airline.Repositories;

import airline.Model.Flight;
import airline.Model.SearchCriteria;

import java.util.*;

/**
 * Created by Sandipa on 9/1/2017.
 */
public class FlightCollection {
    private List<Flight> flights;

    public FlightCollection(List <Flight> inputList) {
        flights = inputList;
    }

    public List <String> getSourceLocations() {
        List <String> sourceLocations = new ArrayList<String>();
        for (Flight flight:flights
                ) {
            if (!sourceLocations.contains(flight.getSource()))
                sourceLocations.add(flight.getSource());
        }

        return sourceLocations;
    }

    public List <String> getDestinationLocations() {
        List <String> destinationLocations = new ArrayList<String>();
        for (Flight flight:flights
                ) {
            if (!destinationLocations.contains(flight.getDestination()))
                destinationLocations.add(flight.getDestination());
        }

        return destinationLocations;
    }

    public List <Flight> findFlights(SearchCriteria searchCriteria) {
        List<Flight> matchedFights = new ArrayList<Flight>();
        for (Flight flight:flights
             ) {
            if (searchCriteria.getSource().equalsIgnoreCase(flight.getSource()) &&
                    searchCriteria.getDestination().equalsIgnoreCase(flight.getDestination())) {
                matchedFights.add(flight);
            }
        }
        return matchedFights;
    }
}
