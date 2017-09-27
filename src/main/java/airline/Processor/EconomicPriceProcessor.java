package airline.Processor;


import airline.Model.IFlight;
import airline.Model.PricingRuleModels.EconomicPricingRuleModel;
import airline.Model.TravelClassType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sandipa on 9/14/2017.
 */
public class EconomicPriceProcessor extends PriceProcessor {

    EconomicPriceProcessor(IFlight flight){
        super(flight);
    }
    @Override
    protected void setPercentageOfIncrement()
    {
        float percentOfOccupiedSeats=(flight.getNoOfOccupiedSeats(TravelClassType.ECONOMY)
                * 100 / flight.getCapacity(TravelClassType.ECONOMY));
        Optional<EconomicPricingRuleModel> economicClassRule=pricingRulesRepsitory.getEconomicPricingRuleList().stream()
                .filter(pricingRule -> pricingRule.getMinPercentageOfOccupiedSeats() < percentOfOccupiedSeats &&
                        pricingRule.getMaxPercentageOfOccupiedSeats() >= percentOfOccupiedSeats)
                .findFirst();

        if(economicClassRule.isPresent()) {
            percentageOfIncrement = economicClassRule.get().getIncrementalPercentInFare();
        }

    }

}
