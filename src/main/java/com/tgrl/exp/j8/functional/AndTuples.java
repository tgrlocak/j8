package com.tgrl.exp.j8.functional;

/**
 * If you need a functional interface for a method with more than two parameters (eg. “TriFunction”)
 * you need to make it yourself or use a library. Another way to handle this issue is to use a data
 * structure called a <i>Tuple</i>.
 * 
 * <p>
 * A Tuple is a typed data structure for holding a number of elements. Some languages, such as
 * Scala, have built-in support for Tuples. Tuples are useful whenever you are handling multiple
 * related values, but don’t want all of the overhead of creating a new class.
 * </p>
 * 
 * <p>Check <pre>ExtraReadingAboutTuples.txt</pre> for further information about Tuples.</p>
 * 
 * @author tugrul.ocak
 *
 */
public class AndTuples {

  class Tuple<A, B> {
    public final A _1;
    public final B _2;
    
    public Tuple(A a, B b) {
      this._1 = a;
      this._2 = b;
    }
    
    public A get_1() {
      return _1;
    }
    
    public B get_2() {
      return _2;
    }
  }
  
  class A {
    
  }
  
  class B {
    
  }
}
