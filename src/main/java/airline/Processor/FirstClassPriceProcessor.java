package airline.Processor;

import airline.Model.PricingRuleModels.BusinessPricingRuleModel;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by Sandipa on 9/17/2017.
 */
public class FirstClassPriceProcessor extends PriceProcessor {

    LocalDate dateOfDeparture;

    public FirstClassPriceProcessor(LocalDate dateOfDeparture) {
        super();
        this.dateOfDeparture = dateOfDeparture;
    }


    @Override
    protected void setPercentageOfIncrement()
    {
        int dayDiffWithDateOfJourney = dateOfDeparture.compareTo(LocalDate.now());

        if(dayDiffWithDateOfJourney >= 0 && dayDiffWithDateOfJourney < 10) {
            percentageOfIncrement = pricingRulesRepsitory.getFirstClassPricingRuleModel()
                    .getIncrementalPercentInFare(dayDiffWithDateOfJourney);
        }

    }
}
