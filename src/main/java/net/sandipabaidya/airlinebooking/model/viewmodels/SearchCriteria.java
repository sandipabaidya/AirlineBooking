package net.sandipabaidya.airlinebooking.model.viewmodels;

import net.sandipabaidya.airlinebooking.model.TravelClassType;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sandipa on 8/31/2017.
 */
public class SearchCriteria {
    @NotNull
    TravelClassType travelClassType;
    @NotNull
    private String source;
    @NotNull
    private String destination;
    private int requiredSeats = 1;
    private String inputDepartureDate;
    private LocalDate departureDate;

    public String getInputDepartureDate() {
        return inputDepartureDate;
    }

    public void setInputDepartureDate(String inputDepartureDate) {
        this.inputDepartureDate = inputDepartureDate;
    }

    public LocalDate getDepartureDate() {
        if (inputDepartureDate == null || inputDepartureDate.isEmpty())
            return null;
        else {
            return LocalDate.parse(inputDepartureDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    public int getRequiredSeats() {
        return requiredSeats;
    }

    public void setRequiredSeats(int requiredSeats) {
        this.requiredSeats = requiredSeats;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public TravelClassType getTravelClassType() {
        return travelClassType;
    }

    public void setTravelClassType(TravelClassType travelClassType) {
        this.travelClassType = travelClassType;
    }
}
