package com.tgrl.exp.j8.defaultMethods;

import java.util.Arrays;
import java.util.stream.Stream;

public class StaticMethodsOnInterfaces {

  public static<T> Stream<T> of(T... values) {
    return Arrays.stream(values);
  }
}
