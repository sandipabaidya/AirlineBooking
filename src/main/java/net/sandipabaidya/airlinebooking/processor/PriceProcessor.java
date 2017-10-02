package net.sandipabaidya.airlinebooking.processor;

import net.sandipabaidya.airlinebooking.model.IFlight;
import net.sandipabaidya.airlinebooking.repository.PricingRulesRepsitory;

/**
 * Created by Sandipa on 9/14/2017.
 */
public abstract class PriceProcessor implements IPriceProcessor {
    protected float percentageOfIncrement = 0;
    protected PricingRulesRepsitory pricingRulesRepsitory;
    protected IFlight flight;

    protected PriceProcessor(IFlight flight) {
        this.flight = flight;
    }

    protected abstract void setPercentageOfIncrement();

    @Override
    public double applyPriceIncrement(double baseFare) {
        this.flight = flight;
        setPercentageOfIncrement();
        return baseFare + (baseFare * percentageOfIncrement) / 100;
    }

    @Override
    public void setPricingRulesRepsitory(PricingRulesRepsitory pricingRulesRepsitory) {
        this.pricingRulesRepsitory = pricingRulesRepsitory;
    }
}
