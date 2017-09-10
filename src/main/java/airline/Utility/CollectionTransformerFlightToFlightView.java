package airline.Utility;

import airline.Model.*;
import java.util.*;

/**
 * Created by Sandipa on 9/9/2017.
 */
public final class CollectionTransformerFlightToFlightView extends CollectionTransformer<Flight, FlightView> {
    @Override
    public FlightView transform(Flight flight) {
        airline.Model.FlightView flightView = new airline.Model.FlightView();
        flightView.setFlightID(flight.getFlightID());
        flightView.setSource(flight.getSource());
        flightView.setDestination(flight.getDestination());
        flightView.setDepartureDate(flight.getDepartureDate());
        flightView.setFare(flight.getTotalFare());

        return flightView;
    }
}

/*public final class CollectionTransformerFlightToFlightView {
    public static List<FlightView> Transform(List<Flight> flights)
    {
        CollectionTransformer transformer = new CollectionTransformer<Flight, FlightView>() {
            @Override
            FlightView transform(Flight flight) {
                FlightView flightView=new FlightView();
                flightView.setFlightID(flight.getFlightID());
                flightView.setSource(flight.getSource());

                return flightView;
            }
        };
        return transformer.transform(flights);
    }
}*/
