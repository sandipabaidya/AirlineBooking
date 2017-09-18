package airline.Services;

import airline.Model.Flight;
import airline.Model.TravelClass;
import airline.Model.TravelClassType;
import airline.Model.ViewModels.SearchCriteria;
import airline.Processor.BusinessPriceProcessor;
import airline.Processor.EconomicPriceProcessor;
import airline.Processor.FirstClassPriceProcessor;
import airline.Processor.IPriceProcessor;
import airline.Repository.PricingRulesRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Sandipa on 9/15/2017.
 */

@Service
public class PriceProcessingService {

    @Autowired
    PricingRulesRepsitory pricingRulesRepsitory;


    public double getTotalFare(Flight flight, SearchCriteria searchCriteria)
    {
        double fare= flight.getBaseFare(searchCriteria.getTravelClassType());

        Optional<IPriceProcessor> priceProcessor= getPriceProcessorInstance(flight, searchCriteria.getTravelClassType());
        if(priceProcessor.isPresent()) {
            priceProcessor.get().setPricingRulesRepsitory(pricingRulesRepsitory);
            fare = priceProcessor.get().applyPriceIncrement(fare);
        }

        return fare * searchCriteria.getRequiredSeats();
    }

    private Optional<IPriceProcessor> getPriceProcessorInstance(Flight flight, TravelClassType travelClassType){

        IPriceProcessor priceProcessor;
        switch (travelClassType){
            case ECONOMY:
                priceProcessor =new EconomicPriceProcessor(flight.getCapacity(travelClassType),flight.getNoOfOccupiedSeats(travelClassType) );
                break;
            case BUSINESS:
                priceProcessor =new BusinessPriceProcessor(flight.getDepartureDate());
                break;
            case FIRSTCLASS:
                priceProcessor =new FirstClassPriceProcessor(flight.getDepartureDate());
                break;
            default:
                return Optional.empty();
        }

        return Optional.ofNullable(priceProcessor);
    }
}
