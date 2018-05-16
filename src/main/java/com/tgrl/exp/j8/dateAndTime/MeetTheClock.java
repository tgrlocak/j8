package com.tgrl.exp.j8.dateAndTime;

import java.time.Clock;
import java.time.LocalTime;

/**
 * The <code>Clock</code> can be used in conjunction with dates and times to help build your tests.
 * During production a normal <code>Clock</code> can be used, and a different one during tests
 * 
 * @author tugrul.ocak
 *
 */
public class MeetTheClock {

  public Clock gettingDefaultClock() {
    return Clock.systemDefaultZone();
  }
  
  public void passingClockIntoFactoryMethods() {
    Clock clock = gettingDefaultClock();
    
    LocalTime time = LocalTime.now(clock);
  }
}
