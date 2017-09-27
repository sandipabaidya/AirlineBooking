package airline.Processor;

import airline.Model.IFlight;
import airline.Model.TravelClassType;

import java.util.Optional;

/**
 * Created by Sandipa on 9/26/2017.
 */
public class PriceProcessorResolver {
    public static Optional<IPriceProcessor> resolvePriceProessor(
            TravelClassType travelClassType, IFlight flight)
    {
        IPriceProcessor priceProcessor;
        switch (travelClassType){
            case ECONOMY:
                priceProcessor =new EconomicPriceProcessor(flight);
                break;
            case BUSINESS:
                priceProcessor =new BusinessPriceProcessor(flight);
                break;
            case FIRSTCLASS:
                priceProcessor =new FirstClassPriceProcessor(flight);
                break;
            default:
                return Optional.empty();
        }
        return Optional.ofNullable(priceProcessor);
    }
}
