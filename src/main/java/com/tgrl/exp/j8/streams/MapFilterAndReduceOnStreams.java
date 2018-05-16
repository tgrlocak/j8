package com.tgrl.exp.j8.streams;

import java.util.Collections;
import java.util.List;

public class MapFilterAndReduceOnStreams {

  public void findTheHighestPoint() {
    List<String> names = Collections.emptyList();
    names.add("Cameron");
    names.add("Jake");
    names.add("Mikhail");

    PlayerPoints highest = names.stream().map(name -> new PlayerPoints(name, getPoints(name)))
        .reduce(new PlayerPoints("", 0), (s1, s2) -> (s1.points > s2.points) ? s1 : s2);
  }

  static class PlayerPoints {
    final String name;
    final long points;

    PlayerPoints(String name, long points) {
      this.name = name;
      this.points = points;
    }

    public String toString() {
      return name + ":" + points;
    }
  }

  public static long getPoints(final String name) {
    return 0L;
  }
}
