package com.gridnine.testing;

import java.util.List;

public interface Filter {
    void withoutFilter(List<Flight> flights);
    void filterByDepartureDateBeforeCurrentTime(List<Flight> flights);
    void filterByArrivalDateBeforeDepartureDate(List<Flight> flights);
    void filterByTimeSpendOnEarthExceedsTwoHours(List<Flight> flights);
}
