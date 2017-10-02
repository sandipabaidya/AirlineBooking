package net.sandipabaidya.airlinebooking.utility;

import net.sandipabaidya.airlinebooking.model.Flight;
import net.sandipabaidya.airlinebooking.model.viewmodels.FlightView;

/**
 * Created by Sandipa on 9/9/2017.
 */
public final class FlightToFlightViewTransformer extends ObjectTransformer<Flight, FlightView> {
    @Override
    public FlightView transform(Flight flight) {
        FlightView flightView = new FlightView();
        flightView.setFlightID(flight.getFlightID());
        flightView.setSource(flight.getSource());
        flightView.setDestination(flight.getDestination());
        flightView.setDepartureDate(flight.getDepartureDate());

        return flightView;
    }
}

