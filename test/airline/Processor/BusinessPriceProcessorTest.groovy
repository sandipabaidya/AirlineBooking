package airline.Processor

import airline.Model.PricingRuleModels.BusinessPricingRuleModel
import airline.Model.PricingRuleModels.EconomicPricingRuleModel;
import airline.Model.*;
import airline.Repository.PricingRulesRepsitory;
import org.junit.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner

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

    @Before
    public void setUp()
    {
        //Create mock object of PricingRulesRepsitory
        pricingRulesRepsitory = mock(PricingRulesRepsitory.class);

        //Create few instances of BusinessPricingRuleModel class.
        mockBizRule1 = new BusinessPricingRuleModel(DayOfWeek.THURSDAY, 50);
        mockBizRule2 = new BusinessPricingRuleModel(DayOfWeek.FRIDAY, 10);

        when(pricingRulesRepsitory.getBusinessPricingRuleList()).thenReturn(Arrays.asList(mockBizRule1, mockBizRule2));
    }

    @Test
    public void testGetAllBusinessRules() throws Exception {

        List<BusinessPricingRuleModel> rules = pricingRulesRepsitory.getBusinessPricingRuleList();
        Assert.assertEquals(2, rules.size());

    }

    @Test
    void ShouldReturnPriceAs1500ifBasePriceis1000AndDOJisTHURSDAY() {
        BusinessPriceProcessor priceProcessor=new BusinessPriceProcessor(LocalDate.parse("2017-09-21"));
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(1500,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1000ifBasePriceis1000AndDOJisWEDNESSDAY() {
        BusinessPriceProcessor priceProcessor=new BusinessPriceProcessor(LocalDate.parse("2017-09-20"));
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(6000,priceProcessor.applyPriceIncrement(6000),0.01)
    }

}