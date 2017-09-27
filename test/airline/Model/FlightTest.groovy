package airline.Model

import airline.Model.PricingRuleModels.*
import airline.Repository.PricingRulesRepsitory
import org.junit.*
import org.mockito.Mockito

import java.time.DayOfWeek;
import java.time.LocalDate

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Sandipa on 9/6/2017.
 */

public class FlightTest{

    PricingRulesRepsitory pricingRulesRepsitory;

    @Before
    public void setUp()
    {
        pricingRulesRepsitory= mock(PricingRulesRepsitory.class);
    }

    @Test
    public void ShouldReturnTrueIfSourceAndDestinationMatches()
    {
        Flight flight =new Flight("fl01","blr","hyd",LocalDate.now());
        Assert.assertTrue(flight.isRunBetweenCities("BLR", "Hyd"));

    }

    @Test
    public void ShouldReturnFalseIfSourceAndDestinationDoNotMatches()
    {
        Flight flight =new Flight("fl01","blr","del",LocalDate.now());
        Assert.assertFalse(flight.isRunBetweenCities("BLR", "Hyd"));
    }

    @Test
    public void ShouldReturnTrueIfDeparturedateMatches()
    {
        Flight flight =new Flight("fl01","blr","hyd",LocalDate.parse("2017-09-06"));
        Assert.assertTrue(flight.isDepartingOnDate(LocalDate.parse("2017-09-06")));

    }

    @Test
    public void ShouldReturnFalseIfDeparturedateDoNotMatches()
    {
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"));
        Assert.assertFalse(flight.isDepartingOnDate(LocalDate.parse("2017-09-07")));
    }

    @Test
    public void ShouldReturnTrueIfSeatsAvailableForTravelClass()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 60,8000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);
        flight.bookSeats(TravelClassType.ECONOMY, 9)
        Assert.assertTrue(flight.isSeatsAvailableInTravelClass(TravelClassType.ECONOMY, 4));
    }

    @Test
    public void ShouldReturnFalseIfSeatsNOTAvailableForTravelClass()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 12,8000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);
        flight.bookSeats(TravelClassType.ECONOMY, 9)
        Assert.assertFalse(flight.isSeatsAvailableInTravelClass(TravelClassType.ECONOMY, 7));
    }

    @Test
    public void ShouldReturnFalseIfTravelClassNotAvailable()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 6,8000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);

        Assert.assertFalse(flight.isSeatsAvailableInTravelClass(TravelClassType.BUSINESS, 5));
    }

    @Test
    public void ShouldGet15AsTotalSeatOccupied()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 60,8000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);
        flight.bookSeats(TravelClassType.ECONOMY, 9)
        flight.bookSeats(TravelClassType.ECONOMY, 6)
        Assert.assertEquals(15, flight.getNoOfOccupiedSeats(TravelClassType.ECONOMY));
    }


    @Test
    public void ShouldReturn12000IfNoOfSeatsAre2andBaseFareis6000()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 6,6000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);

        Assert.assertEquals(12000,
                flight.getBaseFare(TravelClassType.ECONOMY)*2,0.001);

    }

    @Test
    public void ShouldReturnTotalfare15600IfNoOfSeatsAre2andBaseFareis6000For2Seats()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 10,6000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);
        flight.bookSeats(TravelClassType.ECONOMY,6)

        EconomicPricingRuleModel mockEconomicRule1 = new EconomicPricingRuleModel(0,40,0);
        EconomicPricingRuleModel mockEconomicRule2 = new EconomicPricingRuleModel(40,90,30);

        Mockito.when(pricingRulesRepsitory.getEconomicPricingRuleList()).thenReturn(Arrays.asList(mockEconomicRule1, mockEconomicRule2));


        Assert.assertEquals(15600,
                flight.getTotalFare(TravelClassType.ECONOMY, 2, Optional.ofNullable(pricingRulesRepsitory)),0.001);

    }

    @Test
    public void ShouldReturnAppropriateFareforBusinessClassIFRulesAreDefined()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.BUSINESS, 10,10000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-10-02"),aeroplane);

        BusinessPricingRuleModel mockBizRule1 = new BusinessPricingRuleModel(DayOfWeek.MONDAY, 40);
        Mockito.when(pricingRulesRepsitory.getBusinessPricingRuleList()).thenReturn(Arrays.asList(mockBizRule1));



        Assert.assertEquals(28000,
                flight.getTotalFare(TravelClassType.BUSINESS, 2, Optional.ofNullable(pricingRulesRepsitory)),0.001);

    }

    @Test
    public void ShouldReturnAppropriateFareforBusinessClassIFRulesAreNOTDefined()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.BUSINESS, 10,10000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-10-02"),aeroplane);


        Assert.assertEquals(20000,
                flight.getTotalFare(TravelClassType.BUSINESS, 2, Optional.ofNullable(pricingRulesRepsitory)),0.001);

    }
    @Test
    public void ShouldReturnAppropriateFareforFirstClassIFRulesAreDefined()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.FIRSTCLASS, 10,10000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.now().plusDays(6),aeroplane);

        FirstClassPricingRuleModel mockRule = new FirstClassPricingRuleModel();
        Mockito.when(pricingRulesRepsitory.getFirstClassPricingRuleModel()).thenReturn(mockRule);


        Assert.assertEquals(28000,
                flight.getTotalFare(TravelClassType.FIRSTCLASS, 2, Optional.ofNullable(pricingRulesRepsitory)),0.001);

    }
}
