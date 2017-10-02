package net.sandipabaidya.airlinebooking.model.pricingrulemodels;

import java.time.DayOfWeek;

/**
 * Created by Sandipa on 9/17/2017.
 */
public class BusinessPricingRuleModel {

    DayOfWeek dayOfWeek;
    float incrementalPercentInFare;

    public BusinessPricingRuleModel(DayOfWeek dayOfWeek, float incrementalPercentInFare) {
        this.dayOfWeek = dayOfWeek;
        this.incrementalPercentInFare = incrementalPercentInFare;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public float getIncrementalPercentInFare() {
        return incrementalPercentInFare;
    }
}
