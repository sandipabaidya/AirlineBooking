package airline.Repository;

import airline.Model.Flight;
import airline.Model.Location;
import airline.Utility.dataUploader;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sandipa on 9/7/2017.
 */

@Repository
public class LocationRepository {
    private List<Location> locations;

    public LocationRepository() {
        String locationInfoFileName="C:\\TWHandson\\AirlineBooking\\AirlineBooking\\src\\main\\resources\\locations.csv";
        locations = dataUploader.loadLocations(locationInfoFileName);
    }

    public List<Location> getLocations() {
        return locations;
    }
}
