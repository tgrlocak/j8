package com.tgrl.exp.j8.defaultMethods;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * An interface can have one or more default methods and still be functional.
 * @author tugrul.ocak
 *
 */
public class DefaultAndFunctional {

  
  @FunctionalInterface
  interface IterableExample{
    IterableExample iterableExample();
    
    default <T> void forEach(Consumer<? super T> action) {
      Objects.requireNonNull(action);
      for(T t : new Iterable<T>() {

        @Override
        public Iterator<T> iterator() {
          return null;
        }}) {
        action.accept(t);
      }
    }
  }
}
