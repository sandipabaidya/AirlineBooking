package airline.Model

import org.junit.Assert
import org.junit.Test

import java.time.LocalDate

/**
 * Created by Sandipa on 9/6/2017.
 */
public class FlightTest{

    @Test
    public void ShouldReturnTrueIfSourceAndDestinationMatches()
    {
        Flight flight =new Flight("fl01","blr","hyd",LocalDate.now());
        Assert.assertTrue(flight.isRunBetweenCities("BLR", "Hyd"));

    }

    @Test
    public void ShouldReturnFalseIfSourceAndDestinationDoNotMatches()
    {
        Flight flight =new Flight("fl01","blr","del",LocalDate.now());
        Assert.assertFalse(flight.isRunBetweenCities("BLR", "Hyd"));
    }

    @Test
    public void ShouldReturnTrueIfDeparturedateMatches()
    {
        Flight flight =new Flight("fl01","blr","hyd",LocalDate.parse("2017-09-06"));
        Assert.assertTrue(flight.isDepartingOnDate(LocalDate.parse("2017-09-06")));

    }

    @Test
    public void ShouldReturnFalseIfDeparturedateDoNotMatches()
    {
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"));
        Assert.assertFalse(flight.isDepartingOnDate(LocalDate.parse("2017-09-07")));
    }

    @Test
    public void ShouldReturnTrueIfSeatsAvailableForTravelClass()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 60,8000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);

        Assert.assertTrue(flight.isSeatsAvailableInTravelClass(TravelClassType.ECONOMY, 5));
    }

    @Test
    public void ShouldReturnFalseIfSeatsNOTAvailableForTravelClass()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 6,8000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);

        Assert.assertFalse(flight.isSeatsAvailableInTravelClass(TravelClassType.ECONOMY, 7));
    }

    @Test
    public void ShouldReturnFalseIfTravelClassNotAvailable()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 6,8000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);

        Assert.assertFalse(flight.isSeatsAvailableInTravelClass(TravelClassType.BUSINESS, 5));
    }

    @Test
    public void ShouldReturn12000IfNoOfSeatsAre2andBaseFareis6000()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 6,6000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);

        Assert.assertEquals(12000,
                flight.getFlightWithTotalFare(TravelClassType.ECONOMY, 2).getTotalFare(),0.001);

    }
}
