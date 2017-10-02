package net.sandipabaidya.airlinebooking.model.pricingrulemodels;

/**
 * Created by Sandipa on 9/11/2017.
 */
public class EconomicPricingRuleModel {
    float minPercentageOfOccupiedSeats;
    float maxPercentageOfOccupiedSeats;
    float incrementalPercentInFare;

    public EconomicPricingRuleModel(float minPercentageOfOccupiedSeats,
                                    float maxPercentageOfOccupiedSeats, float incrementalPercentInFare) {
        this.minPercentageOfOccupiedSeats = minPercentageOfOccupiedSeats;
        this.maxPercentageOfOccupiedSeats = maxPercentageOfOccupiedSeats;
        this.incrementalPercentInFare = incrementalPercentInFare;
    }

    public float getMinPercentageOfOccupiedSeats() {
        return minPercentageOfOccupiedSeats;
    }

    public float getIncrementalPercentInFare() {
        return incrementalPercentInFare;
    }

    public float getMaxPercentageOfOccupiedSeats() {
        return maxPercentageOfOccupiedSeats;
    }
}
