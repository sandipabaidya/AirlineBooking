package net.sandipabaidya.airlinebooking.model.viewmodels;

import java.util.List;

/**
 * Created by Sandipa on 9/14/2017.
 */
public class SearchResponse {
    boolean searchSuccess;
    String message;
    List<FlightView> matchedFights;


    public boolean isSearchSuccess() {
        return searchSuccess;
    }

    public void setSearchSuccess(boolean searchSuccess) {
        this.searchSuccess = searchSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FlightView> getMatchedFights() {
        return matchedFights;
    }

    public void setMatchedFights(List<FlightView> matchedFights) {
        this.matchedFights = matchedFights;
    }
}
