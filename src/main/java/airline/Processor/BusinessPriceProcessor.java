package airline.Processor;

import airline.Model.*;
import airline.Model.PricingRuleModels.*;

import java.time.*;
import java.util.Optional;

/**
 * Created by Sandipa on 9/16/2017.
 */
public class BusinessPriceProcessor extends PriceProcessor {

    BusinessPriceProcessor(IFlight flight){
        super(flight);
    }


    @Override
    protected void setPercentageOfIncrement()
    {
        Optional<BusinessPricingRuleModel> businessPricingRuleModel=pricingRulesRepsitory.getBusinessPricingRuleList().stream()
                .filter(pricingRule -> pricingRule.getDayOfWeek().compareTo(flight.getDepartureDate().getDayOfWeek())==0)
                .findFirst();

        if(businessPricingRuleModel.isPresent()) {
            percentageOfIncrement = businessPricingRuleModel.get().getIncrementalPercentInFare();
        }

    }
}
