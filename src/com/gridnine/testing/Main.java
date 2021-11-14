package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Flight> flight = new ArrayList<>(FlightBuilder.createFlights());
        Filter filter = new FilterImp();
        filter.withoutFilter(flight);
        System.out.println("\n");
        filter.filterByDepartureDateBeforeCurrentTime(flight);
        System.out.println("\n");
        filter.filterByArrivalDateBeforeDepartureDate(flight);
        System.out.println("\n");
        filter.filterByTimeSpendOnEarthExceedsTwoHours(flight);
    }
}
