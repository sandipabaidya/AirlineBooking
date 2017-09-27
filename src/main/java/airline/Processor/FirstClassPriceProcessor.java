package airline.Processor;

import airline.Model.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * Created by Sandipa on 9/17/2017.
 */
public class FirstClassPriceProcessor extends PriceProcessor {

    FirstClassPriceProcessor(IFlight flight){
        super(flight);
    }
    @Override
    protected void setPercentageOfIncrement()
    {
        long dayDiffWithDateOfJourney = LocalDate.now().until(flight.getDepartureDate(), ChronoUnit.DAYS);

        if(dayDiffWithDateOfJourney >= 0 && dayDiffWithDateOfJourney < 10) {
            percentageOfIncrement = pricingRulesRepsitory.getFirstClassPricingRuleModel()
                    .getIncrementalPercentInFare(dayDiffWithDateOfJourney);
        }

    }
}
