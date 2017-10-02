package net.sandipabaidya.airlinebooking.processor;

import net.sandipabaidya.airlinebooking.repository.PricingRulesRepsitory;

/**
 * Created by Sandipa on 9/11/2017.
 */
public interface IPriceProcessor {
    public double applyPriceIncrement(double baseFare);

    public void setPricingRulesRepsitory(PricingRulesRepsitory pricingRulesRepsitory);
}
