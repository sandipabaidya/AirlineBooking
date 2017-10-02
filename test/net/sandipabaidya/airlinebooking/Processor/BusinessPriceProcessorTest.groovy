package net.sandipabaidya.airlinebooking.processor

import net.sandipabaidya.airlinebooking.model.IFlight
import net.sandipabaidya.airlinebooking.model.pricingrulemodels.BusinessPricingRuleModel
import airline.Model.*;
import net.sandipabaidya.airlinebooking.repository.PricingRulesRepsitory
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test
import org.mockito.*

import java.time.DayOfWeek;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.*;
/**
 * Created by Sandipa on 9/17/2017.
 */
class BusinessPriceProcessorTest{
    PricingRulesRepsitory pricingRulesRepsitory;


    BusinessPricingRuleModel mockBizRule1;
    BusinessPricingRuleModel mockBizRule2;

    List<BusinessPricingRuleModel> bizRuleList;
    IFlight mockFlight;
    IPriceProcessor priceProcessor;
    @Before
    public void setUp()
    {
        //Create mock object of PricingRulesRepsitory
        pricingRulesRepsitory = mock(PricingRulesRepsitory.class);

        //Create few instances of BusinessPricingRuleModel class.
        mockBizRule1 = new BusinessPricingRuleModel(DayOfWeek.THURSDAY, 50);
        mockBizRule2 = new BusinessPricingRuleModel(DayOfWeek.FRIDAY, 10);

        when(pricingRulesRepsitory.getBusinessPricingRuleList()).thenReturn(Arrays.asList(mockBizRule1, mockBizRule2));

        mockFlight =Mockito.mock(IFlight.class)
        priceProcessor=new BusinessPriceProcessor(mockFlight);
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
    }

    @Test
    public void testGetAllBusinessRules() throws Exception {

        List<BusinessPricingRuleModel> rules = pricingRulesRepsitory.getBusinessPricingRuleList();
        Assert.assertEquals(2, rules.size());

    }

    @Test
    void ShouldReturnPriceAs1500ifBasePriceis1000AndDOJisTHURSDAY() {

        when(mockFlight.getDepartureDate()).thenReturn(LocalDate.parse("2017-09-21"));
        Assert.assertEquals(1500,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1000ifBasePriceis1000AndDOJisWEDNESSDAY() {
        when(mockFlight.getDepartureDate()).thenReturn(LocalDate.parse("2017-09-20"));
        Assert.assertEquals(1000,priceProcessor.applyPriceIncrement(1000),0.01)
    }

}
