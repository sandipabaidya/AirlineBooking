package airline.Model.PricingRuleModels;

import airline.Model.TravelClassType;

/**
 * Created by Sandipa on 9/11/2017.
 */
public class EconomicPricingRuleModel {
    float minPercentageOfOccupiedSeats;
    float maxPercentageOfOccupiedSeats;
    float incrementalPercentInFare;

    public float getMinPercentageOfOccupiedSeats() {
        return minPercentageOfOccupiedSeats;
    }

    public float getIncrementalPercentInFare() {
        return incrementalPercentInFare;
    }

    public float getMaxPercentageOfOccupiedSeats() {
        return maxPercentageOfOccupiedSeats;
    }

    public EconomicPricingRuleModel(float minPercentageOfOccupiedSeats,
                       float maxPercentageOfOccupiedSeats, float incrementalPercentInFare) {
        this.minPercentageOfOccupiedSeats = minPercentageOfOccupiedSeats;
        this.maxPercentageOfOccupiedSeats=maxPercentageOfOccupiedSeats;
        this.incrementalPercentInFare = incrementalPercentInFare;
    }
}
