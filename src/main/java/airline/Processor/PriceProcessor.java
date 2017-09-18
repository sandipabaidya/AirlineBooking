package airline.Processor;

import airline.Model.PricingRuleModels.*;
import airline.Repository.PricingRulesRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import java.util.*;

/**
 * Created by Sandipa on 9/14/2017.
 */
public abstract class PriceProcessor implements IPriceProcessor{
    protected float percentageOfIncrement=0;
    protected PricingRulesRepsitory pricingRulesRepsitory;

    protected PriceProcessor(){
    }

    protected abstract void setPercentageOfIncrement();

    public double applyPriceIncrement(double baseFare){
        setPercentageOfIncrement();
        return baseFare + baseFare*percentageOfIncrement/100;
    }

    public void setPricingRulesRepsitory(PricingRulesRepsitory pricingRulesRepsitory){
        this.pricingRulesRepsitory = pricingRulesRepsitory;
    }
}
