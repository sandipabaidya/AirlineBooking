package net.sandipabaidya.airlinebooking.processor

import airline.Model.*;
import net.sandipabaidya.airlinebooking.repository.PricingRulesRepsitory
import net.sandipabaidya.airlinebooking.model.IFlight
import net.sandipabaidya.airlinebooking.model.pricingrulemodels.EconomicPricingRuleModel
import net.sandipabaidya.airlinebooking.model.TravelClassType
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when

import java.util.*;

/**
 * Created by Sandipa on 9/17/2017.
 */
@RunWith(MockitoJUnitRunner.class)
class EconomicPriceProcessorTest {
    PricingRulesRepsitory pricingRulesRepsitory;

    EconomicPricingRuleModel mockEconomicRule1;
    EconomicPricingRuleModel mockEconomicRule2;
    EconomicPricingRuleModel mockEconomicRule3;

    List<EconomicPricingRuleModel> economicRuleList;

    IFlight mockFlight;
    IPriceProcessor priceProcessor;
    @Before
    public void setUp()
    {
        ///Create mock object of PricingRulesRepsitory
        pricingRulesRepsitory = mock(PricingRulesRepsitory.class);

        //Create few instances of EconomicPricingRuleModel class.
        mockEconomicRule1 = new EconomicPricingRuleModel(0,40,0);
        mockEconomicRule2 = new EconomicPricingRuleModel(40,90,30);
        mockEconomicRule3 = new EconomicPricingRuleModel(90,100,60);

        when(pricingRulesRepsitory.getEconomicPricingRuleList()).thenReturn(Arrays.asList(mockEconomicRule1, mockEconomicRule2, mockEconomicRule3));

        mockFlight =Mockito.mock(IFlight.class)
        priceProcessor=new EconomicPriceProcessor(mockFlight);
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
    }

    @Test
    public void testGetAllEconomicRules() throws Exception {

        List<EconomicPricingRuleModel> rules = pricingRulesRepsitory.getEconomicPricingRuleList();
        Assert.assertEquals(3, rules.size());

    }

    @Test
    void ShouldReturnPricePriceAs7800ifBasePriceis6000AndOutOf195seats100isBooked() {

        when(mockFlight.getNoOfOccupiedSeats(TravelClassType.ECONOMY)).thenReturn(100);
        when(mockFlight.getCapacity(TravelClassType.ECONOMY)).thenReturn(195);

        Assert.assertEquals(7800,priceProcessor.applyPriceIncrement(6000),0.01)
    }

    @Test
    void ShouldReturnPricePriceAs6000ifBasePriceis6000AndOutOf195seats10isBooked() {
        when(mockFlight.getNoOfOccupiedSeats(TravelClassType.ECONOMY)).thenReturn(10);
        when(mockFlight.getCapacity(TravelClassType.ECONOMY)).thenReturn(195);
        Assert.assertEquals(6000,priceProcessor.applyPriceIncrement(6000),0.01)
    }

    @Test
    void ShouldReturnPricePriceAs9600ifBasePriceis6000AndOutOf195seats190isBooked() {
        when(mockFlight.getNoOfOccupiedSeats(TravelClassType.ECONOMY)).thenReturn(190);
        when(mockFlight.getCapacity(TravelClassType.ECONOMY)).thenReturn(195);
        Assert.assertEquals(9600,priceProcessor.applyPriceIncrement(6000),0.01)
    }
}
