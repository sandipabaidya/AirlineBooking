package net.sandipabaidya.airlinebooking.model

import org.junit.Test
import org.junit.Assert;

/**
 * Created by Sandipa on 9/6/2017.
 */
class TravelClassTest {
    @Test
    void ShallMatchNumberOfSeatsIfTravelClassMatches() {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 60,8000);
        Assert.assertEquals(60, travelClass.getCapacity());
    }
    @Test
    void ShallReturnAvailableSeatsAs40ifCapacity100and60isOccupied() {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 100,8000);
        travelClass.updateSeatOccupancy(60);
        Assert.assertEquals(40, travelClass.getAvailableSeats());
    }

    @Test
    void ShallReturnFalseifRequestedSeatisMoreThanAvailable() {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 30,8000);
        travelClass.updateSeatOccupancy(20);
        Assert.assertFalse( travelClass.updateSeatOccupancy(11));
    }

    @Test
    void ShallReturnTrueifRequestedSeatisEqualtoAvailable() {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 30,8000);
        travelClass.updateSeatOccupancy(20);
        Assert.assertTrue( travelClass.updateSeatOccupancy(10));
    }

    @Test
    void ShallReturnTrueifRequestedSeatisIsNegative() {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 30,8000);
        travelClass.updateSeatOccupancy(20);
        Assert.assertFalse( travelClass.updateSeatOccupancy(-2));
    }
}
