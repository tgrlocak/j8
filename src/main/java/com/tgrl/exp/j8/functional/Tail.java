package com.tgrl.exp.j8.functional;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * <p>
 * One of the hallmarks of functional programming is <i>tail-call</i> recursion. It solves the same
 * problem as iteration (which does not exist in FP). Unfortunately, it can cause stack-overflows if
 * not properly optimized by the compiler.
 * </p>
 * 
 * <p>
 * <i>Tail-Call optimization</i> refers to when a compiler converts a recursive function call into a
 * loop to avoid using the call stack. For example, a function that uses tail-call recursion in Lisp
 * will be automatically optimized this way.
 * </p>
 * 
 * <p>
 * Java 8 does not support tail-call optimization like some other languages (yet). However, it is
 * possible to approximate it using something like the following interface:
 * </p>
 * 
 * @author tugrul.ocak
 *
 * @param <T>
 */
@FunctionalInterface
public interface Tail<T> {

  Tail<T> apply();

  default boolean isDone() {
    return false;
  }

  default T result() {
    throw new UnsupportedOperationException("Not done yet.");
  }

  default T invoke() {
    return Stream.iterate(this, Tail::apply).filter(Tail::isDone).findFirst().get().result();
  }

  static <T> Tail<T> done(final T value) {
    return new Tail<T>() {

      @Override
      public T result() {
        return value;
      }

      @Override
      public boolean isDone() {
        return true;
      }

      @Override
      public Tail<T> apply() {
        throw new UnsupportedOperationException("Not supported.");
      }

    };
  }

  /**
   * With the <code>Tail</code> interface you can mimic tail-call recursion quite easily in Java 8.
   * Here’s an example of calculating <i>factorial</i> using this interface (using BigInteger so
   * that very large factorials can be computed):
   */
  public static BigInteger factorial(int n) {
    return streamFactorial(BigInteger.ONE, n).invoke();
  }

  // Using this method, you can make extremely fast programs while still maintaining the functional
  // style.
  static Tail<BigInteger> streamFactorial(BigInteger x, int n) {
    return () -> {
      switch (n) {
        case 1:
          return Tail.done(x);
        default:
          return streamFactorial(x.multiply(BigInteger.valueOf(n)), n - 1);
      }
    };
  }


}
