package airline.Processor;


import airline.Model.PricingRuleModels.EconomicPricingRuleModel;
import airline.Model.TravelClassType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sandipa on 9/14/2017.
 */
public class EconomicPriceProcessor extends PriceProcessor {
    int noOfOccupiedSeats=0;
    int totalSeatCapacity ;
    public EconomicPriceProcessor(int totalSeatCapacity,int noOfOccupiedSeats) {
        super();
        this.noOfOccupiedSeats = noOfOccupiedSeats;
        this.totalSeatCapacity=totalSeatCapacity;
    }

    @Override
    public double applyPriceIncrement(double baseFare){
        setPercentageOfIncrement();
        return super.applyPriceIncrement(baseFare);
    }

    @Override
    protected void setPercentageOfIncrement()
    {
        float percentOfOccupiedSeats=(noOfOccupiedSeats * 100 / totalSeatCapacity);
        Optional<EconomicPricingRuleModel> economicClassRule=pricingRulesRepsitory.getEconomicPricingRuleList().stream()
                .filter(pricingRule -> pricingRule.getMinPercentageOfOccupiedSeats() < percentOfOccupiedSeats &&
                        pricingRule.getMaxPercentageOfOccupiedSeats() >= percentOfOccupiedSeats)
                .findFirst();

        if(economicClassRule.isPresent()) {
            percentageOfIncrement = economicClassRule.get().getIncrementalPercentInFare();
        }

    }
}
