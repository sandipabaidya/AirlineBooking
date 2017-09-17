package airline.Model

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
}
