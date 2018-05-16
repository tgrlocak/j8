package com.tgrl.exp.j8.dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class NewClasses4DateAndTime {

  public void introducingNewClasses() {
    // Before Java 8 - 8 hours later from now
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.HOUR, 8);
    cal.getTime();

    // With Java 8
    LocalTime local = LocalTime.now();
    LocalTime later = local.plusHours(8);
    // or use ChronoUnit enums which replaced Calendar api's integer constants for days, hours etc.
    LocalTime sameLater = local.plus(8, ChronoUnit.HOURS);

    // Extra usages and functions
    LocalDate today = LocalDate.now();
    LocalDate thirtyDaysFromNow = today.plusDays(30);
    LocalDate nextMonth = today.plusMonths(1);
    LocalDate aMonthAgo = today.minusMonths(1);

    /**
     * Note that each method returns a different instance of LocalDate. The original LocalDate,
     * today, remains unchanged. This is because the new Date-Time types are immutable. This allows
     * them to be thread-safe and cacheable.
     */
  }

  public void creatingDateAndTimeObjects() {
    // Creating a LocalDate for May 16;, 2018
    LocalDate date = LocalDate.of(2018, 5, 16);

    // For more type-safety
    date = LocalDate.of(2018, Month.MAY, 16);

    // You can also easily create a LocalDateTime by combining an instance of LocalDate with a
    // LocalTime
    LocalTime time = LocalTime.of(12, 15, 0);
    LocalDateTime dateTime = date.atTime(time);
  }
  
  public void printingDateFields() {
    LocalDate date = LocalDate.of(2018, Month.MAY, 18);
    
    // The below code will print 'MAY'
    System.out.println(date.getMonth());
  }
}
