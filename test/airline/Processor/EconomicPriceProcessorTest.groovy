package airline.Processor;

import airline.Model.PricingRuleModels.EconomicPricingRuleModel;
import airline.Model.*;
import airline.Repository.PricingRulesRepsitory;
import org.junit.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
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
    }

    @Test
    public void testGetAllEconomicRules() throws Exception {

        List<EconomicPricingRuleModel> rules = pricingRulesRepsitory.getEconomicPricingRuleList();
        Assert.assertEquals(3, rules.size());

    }

    @Test
    void ShouldReturnPricePriceAs7800ifBasePriceis6000AndOutOf195seats100isBooked() {
        EconomicPriceProcessor priceProcessor=new EconomicPriceProcessor(195,100);
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(7800,priceProcessor.applyPriceIncrement(6000),0.01)
    }

    @Test
    void ShouldReturnPricePriceAs6000ifBasePriceis6000AndOutOf195seats10isBooked() {
        EconomicPriceProcessor priceProcessor=new EconomicPriceProcessor(195,10);
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(6000,priceProcessor.applyPriceIncrement(6000),0.01)
    }

    @Test
    void ShouldReturnPricePriceAs9600ifBasePriceis6000AndOutOf195seats190isBooked() {
        EconomicPriceProcessor priceProcessor=new EconomicPriceProcessor(195,190);
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(9600,priceProcessor.applyPriceIncrement(6000),0.01)
    }
}
