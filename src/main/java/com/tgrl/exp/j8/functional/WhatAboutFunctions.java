package com.tgrl.exp.j8.functional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

/**
 * When lambda expressions, method-references, the Stream interface, and immutable data-structures
 * are combined, Java enables what could be called “functional programming” (FP)
 * 
 * @author tugrul.ocak
 *
 */
public class WhatAboutFunctions {

  /**
   * The <code>Function</code> interface (and related interfaces <code>IntFunction</code>,
   * <code>DoubleFunction</code>, <code>LongFunction</code>, <code>BiFunction</code>, etc.)
   * represents the compromise made by Java 8 in elevating functions to objects. This interface
   * allows functions to be passed as arguments, stored as variables, and be returned by methods
   * 
   * <p>
   * The Function interface has the following default methods: <br/>
   * 
   * <code>andThen(Function)</code>: Returns a composed function that first applies this function to
   * its input, and then applies the given function to the result.<br/>
   * <code>compose(Function)</code>: Similar to andThen but in reversed order (first applies the
   * given function to its input, and then this function).<br/>
   * <code>identity()</code>: Returns a function that always returns its input argument. <br/>
   * </p>
   */
  public void howToUseFunctions() {
    Function<Integer, String> f =
        Function.<Integer>identity().andThen(i -> 2 * i).andThen(i -> "str" + i);

  }

  /**
   * <code>andThen</code> can be used any number of times to create a single function. Also,
   * remember that functions can be passed and returned from methods. Following is an example
   * involving the new Date-Time API
   */
  public Function<LocalDate, LocalDateTime> dateTimeFunction(
      final Function<LocalDate, LocalDate> f) {
    return f.andThen(d -> d.atTime(2, 2));
  }
}
