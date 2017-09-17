package airline.Processor

import airline.Model.PricingRuleModels.FirstClassPricingRuleModel
import airline.Repository.PricingRulesRepsitory
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import java.time.LocalDate

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created by Sandipa on 9/17/2017.
 */
    class FirstClassPriceProcessorTest {
    PricingRulesRepsitory pricingRulesRepsitory;
    FirstClassPricingRuleModel mockFirstClassRule;


    @Before
    public void setUp()
    {
        ///Create mock object of PricingRulesRepsitory
        pricingRulesRepsitory = mock(PricingRulesRepsitory.class);

        //Create  instance of PricingRuleModel class.
        mockFirstClassRule = new FirstClassPricingRuleModel();

        when(pricingRulesRepsitory.getFirstClassPricingRuleModel()).thenReturn(mockFirstClassRule);
    }

    @Test
    void ShouldReturnPriceAs2000ifBasePriceis1000AndDOJisTODAY() {
        FirstClassPriceProcessor priceProcessor=new FirstClassPriceProcessor(LocalDate.now());
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(2000,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1600ifBasePriceis1000AndDOJisAfter4Days() {
        FirstClassPriceProcessor priceProcessor=new FirstClassPriceProcessor(LocalDate.now().plusDays(4));
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(1600,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1300ifBasePriceis1000AndDOJisAfter7Days() {
        FirstClassPriceProcessor priceProcessor=new FirstClassPriceProcessor(LocalDate.now().plusDays(7));
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(1300,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1000ifBasePriceis1000AndDOJisAfter10Days() {
        FirstClassPriceProcessor priceProcessor=new FirstClassPriceProcessor(LocalDate.now().plusDays(10));
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(1000,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1000ifBasePriceis1000AndDOJisAfter12Days() {
        FirstClassPriceProcessor priceProcessor=new FirstClassPriceProcessor(LocalDate.now().plusDays(12));
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);
        Assert.assertEquals(1000,priceProcessor.applyPriceIncrement(1000),0.01)
    }
}
