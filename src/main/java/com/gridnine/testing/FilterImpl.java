package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FilterImpl implements Filter {

    @Override
    public List<Flight> filterByDepDateBeforeCurTime(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight f : flights) {
            f.getSegments().stream().filter(s -> s.getDepartureDate().isBefore(LocalDateTime.now())).forEach(s -> filteredFlights.add(f));
        }
        return filteredFlights;
    }

    @Override
    public List<Flight> filterByArrivalDateBeforeDepDate(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight f : flights) {
            f.getSegments().stream().filter(s -> s.getArrivalDate().isBefore(s.getDepartureDate())).forEach(s -> filteredFlights.add(f));
        }
        return filteredFlights;
    }

    @Override
    public List<Flight> filterByTimeSpendOnGroundExceedsTwoHours(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();

        for (Flight f : flights) {
            long countMinutes = 0;
            for (int i = 0; i < f.getSegments().size() - 1; i++) {
                LocalDateTime segment1 = f.getSegments().get(i).getArrivalDate();
                LocalDateTime segment2 = f.getSegments().get(i + 1).getDepartureDate();
                countMinutes += ChronoUnit.MINUTES.between(segment1, segment2);
            }
            if (countMinutes > 120) {
                filteredFlights.add(f);
            }
        }
        return filteredFlights;
    }
}