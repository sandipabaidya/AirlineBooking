package net.sandipabaidya.airlinebooking.repository

import net.sandipabaidya.airlinebooking.model.pricingrulemodels.BusinessPricingRuleModel
import net.sandipabaidya.airlinebooking.model.pricingrulemodels.EconomicPricingRuleModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Sandipa on 9/17/2017.
 */
class PricingRulesRepsitoryTest{
    PricingRulesRepsitory pricingRulesRepsitory;

    @Before
    public void setUp() {
        pricingRulesRepsitory=new PricingRulesRepsitory();
    }
    @Test
    void testGetEconomicPricingRuleList() {

        List<EconomicPricingRuleModel> list=  pricingRulesRepsitory.getEconomicPricingRuleList();
        Assert.assertEquals(3,list.size());
    }

    @Test
    void testGetBusinessPricingRuleList() {
        List<BusinessPricingRuleModel> list=  pricingRulesRepsitory.getBusinessPricingRuleList();
        Assert.assertEquals(3,list.size());
    }

    void testGetFirstClassPricingRuleModel() {
    }
}
