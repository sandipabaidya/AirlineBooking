package airline.Model;
import java.time.LocalDate;
import java.util.Date;
/**
 * Created by Sandipa on 9/4/2017.
 */
public class FlightSchedules {

    private LocalDate departureDate;
    private Flight flight;
    private int availableSeats;

    public FlightSchedules(LocalDate date, Flight flight, int availableSeats )
    {
        departureDate = date;
        this.flight=flight;
        this.availableSeats = availableSeats;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }


    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }


}
