package net.sandipabaidya.airlinebooking.model;

import java.time.LocalDate;

/**
 * Created by Sandipa on 9/26/2017.
 */
public interface IFlight {

    LocalDate getDepartureDate();

    int getCapacity(TravelClassType travelClassType);

    int getNoOfOccupiedSeats(TravelClassType travelClassType);
}
