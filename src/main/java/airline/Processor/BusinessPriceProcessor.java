package airline.Processor;

import airline.Model.PricingRuleModels.BusinessPricingRuleModel;
import airline.Model.TravelClassType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by Sandipa on 9/16/2017.
 */
public class BusinessPriceProcessor extends PriceProcessor {

    LocalDate dateOfDeparture;

    public BusinessPriceProcessor(LocalDate dateOfDeparture) {
        super();
        this.dateOfDeparture = dateOfDeparture;
    }

    @Override
    public double applyPriceIncrement(double baseFare){
        setPercentageOfIncrement();
        return super.applyPriceIncrement(baseFare);
    }

    @Override
    protected void setPercentageOfIncrement()
    {
        Optional<BusinessPricingRuleModel> businessPricingRuleModel=pricingRulesRepsitory.getBusinessPricingRuleList().stream()
                .filter(pricingRule -> pricingRule.getDayOfWeek().compareTo(dateOfDeparture.getDayOfWeek())==0)
                .findFirst();

        if(businessPricingRuleModel.isPresent()) {
            percentageOfIncrement = businessPricingRuleModel.get().getIncrementalPercentInFare();
        }

    }
}
