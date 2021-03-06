package net.sandipabaidya.airlinebooking.utility;

import net.sandipabaidya.airlinebooking.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandipa on 9/1/2017.
 */
public final class DataUploader {

    public static List<Flight> LoadFlights(File fileName) {
        List<Flight> resultList = new ArrayList<Flight>();
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
                LocalDate depurtureDate = LocalDate.parse(flightData[3]);
                String aeroplaneNo = flightData[4].trim();
                int economySeat = Integer.parseInt(flightData[6].trim());
                double economyFare = Double.parseDouble(flightData[7].trim());
                int businessSeat = Integer.parseInt(flightData[9].trim());
                double businessFare = Double.parseDouble(flightData[10].trim());
                int firstclassSeat = Integer.parseInt(flightData[12].trim());
                double firstclassFare = Double.parseDouble(flightData[13].trim());
                List<TravelClass> travelClasses = new ArrayList<TravelClass>();
                if (economySeat > 0)
                    travelClasses.add(new TravelClass(TravelClassType.ECONOMY, economySeat, economyFare));
                if (businessSeat > 0)
                    travelClasses.add(new TravelClass(TravelClassType.BUSINESS, businessSeat, businessFare));
                if (firstclassSeat > 0)
                    travelClasses.add(new TravelClass(TravelClassType.FIRSTCLASS, firstclassSeat, firstclassFare));
                resultList.add(new Flight(flightID, src, destination, depurtureDate,
                    new Aeroplane(aeroplaneNo, travelClasses)));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static List<Location> loadLocations(File locationFilePath) {
        List<Location> locations = new ArrayList<Location>();
        String line = "";
        String cvsSplitBy = ",";

        try {

            BufferedReader brLocation = new BufferedReader(new FileReader(locationFilePath));
            while ((line = brLocation.readLine()) != null) {
                // use comma as separator
                String[] locationData = line.split(cvsSplitBy);
                String locationID = locationData[0].trim().toUpperCase();
                String locationName = locationData[1].trim();
                Location location = new Location(locationID, locationName);
                locations.add(location);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return locations;
    }

}
