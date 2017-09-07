package airline.Model

import org.junit.Assert
import org.junit.Test

/**
 * Created by Sandipa on 9/6/2017.
 */
class AeroplaneTest {
    @Test
    void ShallReturnZeroIfGivenTravelClassDoesNotMatch() {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 60);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Assert.assertEquals(0, aeroplane.getAvailableSeatsByTravelClass(TravelClassType.BUSINESS));
    }
    @Test
    void ShallReturnAvailableSeatIfGivenTravelClassMatches() {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 60);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Assert.assertEquals(60, aeroplane.getAvailableSeatsByTravelClass(TravelClassType.ECONOMY));
    }
}