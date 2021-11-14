package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>(FlightBuilder.createFlights());
        printWithoutFilter(flights);
        printByDepDateBeforeCurTime(flights);
        printByArrivalDateBeforeDepDate(flights);
        printByTimeSpendOnGroundExceedsTwoHours(flights);
    }

    public static void printWithoutFilter(List<Flight> flights) {
        System.out.println("Все полеты:");
        printFlights(flights);
    }

    public static void printByDepDateBeforeCurTime(List<Flight> flights) {
        System.out.println("\nВылет до текущего момента времени:");
        Filter filter = new FilterImp();
        List<Flight> filteredFlights = new ArrayList<>(filter.filterByDepDateBeforeCurTime(flights));
        printFlights(filteredFlights);
    }

    public static void printByArrivalDateBeforeDepDate(List<Flight> flights) {
        System.out.println("\nИмеются сегменты с датой прилета раньше, чем дата вылета:");
        Filter filter = new FilterImp();
        List<Flight> filteredFlights = new ArrayList<>(filter.filterByArrivalDateBeforeDepDate(flights));
        printFlights(filteredFlights);
    }

    public static void printByTimeSpendOnGroundExceedsTwoHours(List<Flight> flights) {
        System.out.println("\nОбщее время на земле превышает 2 часа:");
        Filter filter = new FilterImp();
        List<Flight> filteredFlights = new ArrayList<>(filter.filterByTimeSpendOnGroundExceedsTwoHours(flights));
        printFlights(filteredFlights);
    }

    public static void printFlights(List<Flight> flights) {
        if (!flights.isEmpty()) {
            for (Flight f : flights) {
                System.out.println(f.toString());
            }
        } else {
            System.out.println("Не найдены");
        }
    }
}