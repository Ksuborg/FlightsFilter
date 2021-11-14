package com.gridnine.testing;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class FilterImp implements Filter {

    @Override
    public void withoutFilter(List<Flight> flights) {
        System.out.println("Без фильтра:");
        for (Flight f : flights) {
            System.out.println(f.getSegments().toString());
        }
    }

    @Override
    public void filterByDepartureDateBeforeCurrentTime(List<Flight> flights) {
        System.out.println("Вылет до текущего момента времени:");
        for (Flight f : flights) {
            f.getSegments().stream().filter(s -> s.getDepartureDate().isBefore(LocalDateTime.now())).forEach(System.out::println);
        }
    }

    @Override
    public void filterByArrivalDateBeforeDepartureDate(List<Flight> flights) {
        System.out.println("Имеются сегменты с датой прилета раньше, чем дата вылета:");
        for (Flight f : flights) {
            f.getSegments().stream().filter(s -> s.getArrivalDate().isBefore(s.getDepartureDate())).forEach(System.out::println);
        }
    }

    @Override
    public void filterByTimeSpendOnEarthExceedsTwoHours(List<Flight> flights) {
        System.out.println("Общее время на земле превышает 2 часа:");
        for (Flight f : flights) {
            for (int i = 0; i < f.getSegments().size() - 1; i++) {
                LocalDateTime segment1 = f.getSegments().get(i).getArrivalDate();
                LocalDateTime segment2 = f.getSegments().get(i + 1).getDepartureDate();
                if (segment2.isAfter(segment1.plusHours(2))) {
                    System.out.println(f.getSegments().toString());
                    break;
                }
            }
        }

    }
}
