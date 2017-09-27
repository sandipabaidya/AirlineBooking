package airline.Processor

import airline.Model.IFlight
import airline.Model.PricingRuleModels.FirstClassPricingRuleModel
import airline.Repository.PricingRulesRepsitory
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

import java.time.LocalDate

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created by Sandipa on 9/17/2017.
 */
    class FirstClassPriceProcessorTest {
    PricingRulesRepsitory pricingRulesRepsitory;
    FirstClassPricingRuleModel mockFirstClassRule;

    IFlight mockFlight;
    IPriceProcessor priceProcessor;

    @Before
    public void setUp()
    {
        ///Create mock object of PricingRulesRepsitory
        pricingRulesRepsitory = mock(PricingRulesRepsitory.class);
        mockFirstClassRule = new FirstClassPricingRuleModel();

        mockFlight =Mockito.mock(IFlight.class)
        priceProcessor=new FirstClassPriceProcessor(mockFlight);
        priceProcessor.setPricingRulesRepsitory(pricingRulesRepsitory);

        when(pricingRulesRepsitory.getFirstClassPricingRuleModel()).thenReturn(mockFirstClassRule);
    }

    @Test
    void ShouldReturnPriceAs2000ifBasePriceis1000AndDOJisTODAY() {
        when(mockFlight.getDepartureDate()).thenReturn(LocalDate.now());
        Assert.assertEquals(2000,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1600ifBasePriceis1000AndDOJisAfter4Days() {

        when(mockFlight.getDepartureDate()).thenReturn(LocalDate.now().plusDays(4));
        Assert.assertEquals(1600,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1300ifBasePriceis1000AndDOJisAfter7Days() {
        when(mockFlight.getDepartureDate()).thenReturn(LocalDate.now().plusDays(7));
        Assert.assertEquals(1300,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1000ifBasePriceis1000AndDOJisAfter10Days() {
        when(mockFlight.getDepartureDate()).thenReturn(LocalDate.now().plusDays(10));
        Assert.assertEquals(1000,priceProcessor.applyPriceIncrement(1000),0.01)
    }

    @Test
    void ShouldReturnPriceAs1000ifBasePriceis1000AndDOJisAfter12Days() {
        when(mockFlight.getDepartureDate()).thenReturn(LocalDate.now().plusDays(12));
        Assert.assertEquals(1000,priceProcessor.applyPriceIncrement(1000),0.01)
    }
}
