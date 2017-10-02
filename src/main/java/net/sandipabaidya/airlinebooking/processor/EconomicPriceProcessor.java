package net.sandipabaidya.airlinebooking.processor;


import net.sandipabaidya.airlinebooking.model.IFlight;
import net.sandipabaidya.airlinebooking.model.pricingrulemodels.EconomicPricingRuleModel;
import net.sandipabaidya.airlinebooking.model.TravelClassType;

import java.util.Optional;

/**
 * Created by Sandipa on 9/14/2017.
 */
public class EconomicPriceProcessor extends PriceProcessor {

    EconomicPriceProcessor(IFlight flight) {
        super(flight);
    }

    @Override
    protected void setPercentageOfIncrement() {
        float percentOfOccupiedSeats = (flight.getNoOfOccupiedSeats(TravelClassType.ECONOMY)
            * 100 / flight.getCapacity(TravelClassType.ECONOMY));
        Optional<EconomicPricingRuleModel> economicClassRule = pricingRulesRepsitory.getEconomicPricingRuleList().stream()
            .filter(pricingRule -> pricingRule.getMinPercentageOfOccupiedSeats() < percentOfOccupiedSeats &&
                pricingRule.getMaxPercentageOfOccupiedSeats() >= percentOfOccupiedSeats)
            .findFirst();

        if (economicClassRule.isPresent()) {
            percentageOfIncrement = economicClassRule.get().getIncrementalPercentInFare();
        }

    }

}
