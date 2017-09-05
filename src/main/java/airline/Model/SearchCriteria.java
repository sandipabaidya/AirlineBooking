package airline.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Sandipa on 8/31/2017.
 */
public class SearchCriteria {
    private String source;
    private String destination;
    private int requiredSeats=1;
    private String inputDepartureDate;
    //@DateTimeFormat(pattern = "MM/dd/yyyy")
    private Optional<LocalDate>  departureDate;

    public String getInputDepartureDate() {
        return inputDepartureDate;
    }

    public void setInputDepartureDate(String inputDepartureDate) {
        this.inputDepartureDate = inputDepartureDate;
    }

    public Optional<LocalDate> getDepartureDate() {
        if(inputDepartureDate==null || inputDepartureDate.isEmpty())
            return null;
        else
        {
            return Optional.ofNullable(LocalDate.parse(inputDepartureDate,DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            //LocalDate.parse(depurtureDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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

    public String getDestination() {
        return destination;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
