package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterTests {
    @Test
    public void testFilterByDepDateBeforeCurTime() {
        Filter filter = new FilterImpl();
        Segment segment1 = new Segment(LocalDateTime.now().minusYears(1), LocalDateTime.now().minusYears(1));
        Segment segment2 = new Segment(LocalDateTime.now().plusYears(1), LocalDateTime.now().plusYears(1));
        List<Flight> expectedFlights = new ArrayList<>(Arrays.asList(new Flight(Arrays.asList(segment1))));
        List<Flight> actualFlights = filter.filterByDepDateBeforeCurTime(
                new ArrayList<>(Arrays.asList(new Flight(Arrays.asList(segment1)), new Flight(Arrays.asList(segment2)))));
        Assert.assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void testFilterByArrivalDateBeforeDepDate() {
        Filter filter = new FilterImpl();
        Segment segment1 = new Segment(LocalDateTime.now().plusYears(1), LocalDateTime.now().minusYears(1));
        Segment segment2 = new Segment(LocalDateTime.now().plusYears(1), LocalDateTime.now().plusYears(1));
        List<Flight> expectedFlights = new ArrayList<>(Arrays.asList(new Flight(Arrays.asList(segment1))));
        List<Flight> actualFlights = filter.filterByArrivalDateBeforeDepDate(
                new ArrayList<>(Arrays.asList(new Flight(Arrays.asList(segment1)), new Flight(Arrays.asList(segment2)))));
        Assert.assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void testFilterByTimeSpendOnGroundExceedsTwoHours() {
        Filter filter = new FilterImpl();
        Segment segment1 = new Segment(LocalDateTime.now().minusYears(1), LocalDateTime.now().minusYears(1));
        Segment segment2 = new Segment(LocalDateTime.now(), LocalDateTime.now());
        Segment segment3 = new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now());
        List<Flight> expectedFlights = new ArrayList<>(Arrays.asList(new Flight(Arrays.asList(segment2, segment3))));
        List<Flight> actualFlights = filter.filterByTimeSpendOnGroundExceedsTwoHours(
                new ArrayList<>(Arrays.asList(new Flight(Arrays.asList(segment1)), new Flight(Arrays.asList(segment2, segment3)))));
        Assert.assertEquals(expectedFlights, actualFlights);
    }
}