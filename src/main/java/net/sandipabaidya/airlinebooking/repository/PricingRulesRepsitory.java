package net.sandipabaidya.airlinebooking.repository;

import net.sandipabaidya.airlinebooking.model.pricingrulemodels.BusinessPricingRuleModel;
import net.sandipabaidya.airlinebooking.model.pricingrulemodels.EconomicPricingRuleModel;
import net.sandipabaidya.airlinebooking.model.pricingrulemodels.FirstClassPricingRuleModel;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandipa on 9/11/2017.
 */

@Repository
public class PricingRulesRepsitory {


    private List<EconomicPricingRuleModel> economicPricingRuleList;

    private List<BusinessPricingRuleModel> businessPricingRuleList;

    private FirstClassPricingRuleModel firstClassPricingRuleModel;

    public PricingRulesRepsitory() {
        economicPricingRuleList = new ArrayList<>();
        economicPricingRuleList.add(new EconomicPricingRuleModel(0, 40, 0));
        economicPricingRuleList.add(new EconomicPricingRuleModel(40, 90, 0));
        economicPricingRuleList.add(new EconomicPricingRuleModel(90, 40, 0));

        businessPricingRuleList = new ArrayList<>();
        businessPricingRuleList.add(new BusinessPricingRuleModel(DayOfWeek.MONDAY, 40));
        businessPricingRuleList.add(new BusinessPricingRuleModel(DayOfWeek.FRIDAY, 40));
        businessPricingRuleList.add(new BusinessPricingRuleModel(DayOfWeek.SUNDAY, 40));

        firstClassPricingRuleModel = new FirstClassPricingRuleModel();
    }

    public PricingRulesRepsitory getPricingRulesRepsitory() {
        return this;
    }

    public List<EconomicPricingRuleModel> getEconomicPricingRuleList() {
        return economicPricingRuleList;
    }

    public List<BusinessPricingRuleModel> getBusinessPricingRuleList() {
        return businessPricingRuleList;
    }

    public FirstClassPricingRuleModel getFirstClassPricingRuleModel() {
        return firstClassPricingRuleModel;
    }


}
