package com.tgrl.exp.j8.dateAndTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Java 8 has two types for representing time differences as humans understand them,
 * <code>Period</code> and <code>Duration</code>.
 * 
 * @author tugrul.ocak
 *
 */
public class LikeHuman {

  /**
   * Period is a date-based amount of time, such as ‘2 years, 3 months and 4 days’
   */
  public void determinePeriod() {
    LocalDate date1 = LocalDate.now();
    LocalDate date2 = date1.plusDays(5).plusMonths(2);

    Period p = Period.between(date1, date2);
  }

  /**
   * Duration is a time-based amount of time, such as ‘34.5 seconds’
   */
  public void determineDuration() {
    LocalTime time1 = LocalTime.now();
    LocalTime time2 = time1.plusHours(8).plusSeconds(52);

    Duration d = Duration.between(time1, time2);

    // Durations also can be created with static methods
    Duration twoHours = Duration.ofHours(2);
    Duration tenMinutes = Duration.ofMinutes(10);
    Duration thirtySeconds = Duration.ofSeconds(30);

    // Periods and durations can be added or subtracted from Java 8 date types
    LocalTime t2 = time1.plus(twoHours).minus(tenMinutes);
  }
}
