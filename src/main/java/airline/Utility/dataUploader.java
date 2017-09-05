package airline.Utility;

import airline.Model.Flight;
import airline.Model.FlightSchedules;
import airline.Model.Location;

import java.io.*;
import java.text.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Sandipa on 9/1/2017.
 */
public final class dataUploader {

    public static List<FlightSchedules> LoadFlights(String fileName) {
        List <FlightSchedules> resultList = new ArrayList<FlightSchedules>();
        String line = "";
        String cvsSplitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] flightData = line.split(cvsSplitBy);
                String flightID = flightData[0].trim();
                String src = flightData[1].trim();
                String destination = flightData[2].trim();
                int availableSeats =Integer.parseInt( flightData[3].trim());
                LocalDate depurtureDate = LocalDate.parse(flightData[4]);
                resultList.add(new FlightSchedules(depurtureDate, new Flight(flightID, src, destination), availableSeats));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static List<Location> loadLocations(String locationFilePath) {
        List <Location> locations = new ArrayList<Location>();
        String line = "";
        String cvsSplitBy = ",";

        try {

            BufferedReader brLocation = new BufferedReader(new FileReader(locationFilePath));
            while ((line = brLocation.readLine()) != null) {
                // use comma as separator
                String[] locationData = line.split(cvsSplitBy);
                String locationID = locationData[0].trim().toUpperCase();
                String locationName = locationData[1].trim();
                Location location = new Location(locationID,locationName);
                locations.add(location);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return locations;
    }

}
