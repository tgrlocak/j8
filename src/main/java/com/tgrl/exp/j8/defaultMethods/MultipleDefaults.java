package com.tgrl.exp.j8.defaultMethods;

import static java.lang.System.out;

public class MultipleDefaults {

  interface Foo {
    default void talk() {
      out.print("Foo!");
    }
  }
  
  interface Bar {
    default void talk() {
      out.print("Bar!");
    }
  }
  
  class FooBar implements Foo, Bar {

    @Override
    public void talk() {
      Foo.super.talk();
    }
    
  }
}
