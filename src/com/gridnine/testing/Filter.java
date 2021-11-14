package com.gridnine.testing;

import java.util.List;

public interface Filter {
    List<Flight> filterByDepDateBeforeCurTime(List<Flight> flights);
    List<Flight> filterByArrivalDateBeforeDepDate(List<Flight> flights);
    List<Flight> filterByTimeSpendOnGroundExceedsTwoHours(List<Flight> flights);
}
