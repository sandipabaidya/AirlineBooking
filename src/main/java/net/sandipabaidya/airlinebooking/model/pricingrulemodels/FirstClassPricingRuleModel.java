package net.sandipabaidya.airlinebooking.model.pricingrulemodels;

/**
 * Created by Sandipa on 9/17/2017.
 */
public class FirstClassPricingRuleModel {

    public float getIncrementalPercentInFare(long dayDiffWithDateOfJourney) {
        if ((10 - dayDiffWithDateOfJourney) >= 0)
            return (10 - dayDiffWithDateOfJourney) * 10f;

        return 0;
    }

}
