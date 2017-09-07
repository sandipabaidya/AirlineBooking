package airline.Services;
import airline.Model.Flight;
import airline.Model.SearchCriteria;
import airline.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Sandipa on 9/1/2017.
 */
@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public FlightService()    {
    }


    public List<Flight> findFlights(SearchCriteria searchCriteria) {
        List<Flight> flights=flightRepository.getFlights();

        List<Flight> matchedFights = new ArrayList<Flight>();
        for (Flight flight:flights) {
            if(!flight.isRunBetweenCities(searchCriteria.getSource(),searchCriteria.getDestination()))
                    continue;
            if(searchCriteria.getDepartureDate()!=null)
                if(!flight.isDepartingOnDate(searchCriteria.getDepartureDate()))
                    continue;
            if(!flight.isSeatsAvailableInTravelClass(searchCriteria.getTravelClassType(),searchCriteria.getRequiredSeats()))
                continue;
            matchedFights.add(flight);
        }

        return matchedFights;
    }

}
