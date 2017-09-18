package airline.Services

import airline.Model.PricingRuleModels.EconomicPricingRuleModel
import airline.Model.ViewModels.*;
import airline.Model.*
import airline.Repository.PricingRulesRepsitory
import org.junit.Assert
import org.junit.Before;
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

//import static org.mockito.Mockito.when;
import java.time.LocalDate

/**
 * Created by Sandipa on 9/18/2017.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = PriceProcessingService.class)
class PriceProcessingServiceTest {

    @Autowired
    PriceProcessingService priceProcessingService

    @MockBean
    PricingRulesRepsitory pricingRulesRepsitory;

    Flight mockFlight;
    @Before
    public void setUp()
    {
        EconomicPricingRuleModel mockEconomicRule1 = new EconomicPricingRuleModel(0,40,0);
        EconomicPricingRuleModel mockEconomicRule2 = new EconomicPricingRuleModel(40,90,30);

        ArrayList<EconomicPricingRuleModel> economicPricingRuleModelArrayList=Arrays.asList(mockEconomicRule1, mockEconomicRule2);

        Mockito.when(pricingRulesRepsitory.getEconomicPricingRuleList()).thenReturn(economicPricingRuleModelArrayList);


        mockFlight = new Flight("Fl01","src","dest",LocalDate.parse("2017-09-07"),
                new Aeroplane("B77",new ArrayList<TravelClass>(
                        Arrays.asList(new TravelClass(TravelClassType.ECONOMY,10,400),
                                new TravelClass(TravelClassType.BUSINESS,6,6000))
                )));
    }



    @Test
    public void ShouldReturn1BasefareIfPriceRuleIsNotConfigured()
    {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSource("src");
        searchCriteria.setDestination("dest");
        searchCriteria.setTravelClassType(TravelClassType.ECONOMY);
        searchCriteria.setRequiredSeats(2);
        Assert.assertEquals(800, priceProcessingService.getTotalFare(mockFlight,searchCriteria), 0.01);
    }

    @Test
    public void ShouldReturn1040If50PerentSeatIsOccupied()
    {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSource("src");
        searchCriteria.setDestination("dest");
        searchCriteria.setTravelClassType(TravelClassType.ECONOMY);
        searchCriteria.setRequiredSeats(2);
        mockFlight.bookSeats(TravelClassType.ECONOMY,6);
        Assert.assertEquals(1040, priceProcessingService.getTotalFare(mockFlight,searchCriteria), 0.01);
    }
}
