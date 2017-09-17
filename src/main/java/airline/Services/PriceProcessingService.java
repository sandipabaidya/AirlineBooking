package airline.Services;

import airline.Model.Flight;
import airline.Model.TravelClass;
import airline.Model.TravelClassType;
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


    public Optional<IPriceProcessor> getPriceProcessorInstance(Flight flight, TravelClassType travelClassType){

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
                priceProcessor =null;
        }

        return Optional.ofNullable(priceProcessor);
    }
}
