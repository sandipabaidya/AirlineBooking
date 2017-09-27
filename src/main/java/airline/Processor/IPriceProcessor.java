package airline.Processor;

import airline.Model.IFlight;
import airline.Repository.PricingRulesRepsitory;

/**
 * Created by Sandipa on 9/11/2017.
 */
public interface IPriceProcessor {
    public double applyPriceIncrement(double baseFare);
    public void setPricingRulesRepsitory(PricingRulesRepsitory pricingRulesRepsitory);
}
