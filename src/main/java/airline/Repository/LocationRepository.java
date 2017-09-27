package airline.Repository;


import airline.Model.Location;
import airline.Utility.dataUploader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

/**
 * Created by Sandipa on 9/7/2017.
 */

@Repository
public class LocationRepository {
    private List<Location> locations;

    public LocationRepository() throws Exception {
       Resource resource = new ClassPathResource("locations.csv");
        File locationInfoFile = resource.getFile();
        locations = dataUploader.loadLocations(locationInfoFile);
    }

    public List<Location> getLocations() {
        return locations;
    }
}
