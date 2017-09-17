package airline.Model.PricingRuleModels;

import airline.Model.TravelClassType;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by Sandipa on 9/17/2017.
 */
public class BusinessPricingRuleModel {

    DayOfWeek dayOfWeek;
    float incrementalPercentInFare;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    public float getIncrementalPercentInFare() {
        return incrementalPercentInFare;
    }

    public BusinessPricingRuleModel(DayOfWeek dayOfWeek, float incrementalPercentInFare) {
        this.dayOfWeek=dayOfWeek;
        this.incrementalPercentInFare = incrementalPercentInFare;
    }
}
