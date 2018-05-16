package com.tgrl.exp.j8.streams;

import java.util.Random;

import static java.lang.System.out;

public class LimitingOnStreams {

  public void limitingExampleOnStreams() {
    Random r = new Random();
    
    r.ints().limit(10).forEach(out::println);
  }
}
