package com.tgrl.exp.j8.optional;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Java 8 comes with the <code>Optional</code> class in the <code>java.util</code> package for
 * avoiding null return values (and thus <code>NullPointerException</code>).
 * 
 * @author tugrul.ocak
 *
 */
public class HaveYouHeardIt {

  public void trySomethingsAboutOptional() throws Exception {
    String t = new String();
    String other = new String("other");

    // To wrap a non-null value
    Optional opt1 = Optional.of(t);

    // To represent a missing value
    Optional opt2 = Optional.empty();

    // To create an Optional from a reference that may or may not be null
    Optional opt3 = Optional.ofNullable(t);

    // To determine if there is a value
    opt1.isPresent();
    opt2.isPresent();
    opt3.isPresent();

    // To get the value
    String s1 = (String) opt1.get();

    // To returns the given default value if the Optional is empty
    Optional.of(t).orElse(other);

    // To call on the given Supplier to provide a value if the Optional is empty.
    Optional.of(t).orElseGet(new Supplier<String>() {
      @Override
      public String get() {
        return other;
      }
    });

    Optional.of(t).orElseThrow(new Supplier<Exception>() {
      @Override
      public Exception get() {
        return new RuntimeException("Uupps!!");
      }
    });
  }
}
