package net.sandipabaidya.airlinebooking.model.pricingrulemodels

import org.junit.Assert
import org.junit.Test

import java.time.DayOfWeek

/**
 * Created by Sandipa on 9/17/2017.
 */
class BusinessPricingRuleModelTest{
    @Test
    void testGetDayName() {
        BusinessPricingRuleModel mockBizRule1 =
                new BusinessPricingRuleModel(DayOfWeek.THURSDAY, 50);
        Assert.assertEquals(DayOfWeek.THURSDAY.name(), mockBizRule1.getDayName())
    }
}
