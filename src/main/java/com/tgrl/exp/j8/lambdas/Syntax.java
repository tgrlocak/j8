package com.tgrl.exp.j8.lambdas;

import java.util.Arrays;
import java.util.Optional;

import static java.lang.System.out;

public class Syntax {

  public void someExamplesOfSyntax() {
    FuncFace f = (s) -> out.println(this);
    FuncFace u = (Optional<String> str) -> out.println(str);
    FuncFace n = str -> out.println(str);
    
    String[] strArray = new String[] {"abcdef", "a", "bc", "def"};
    
    Arrays.sort(strArray, (String s1, String s2) -> s2.length() - s1.length());
  }
  
  @FunctionalInterface
  interface FuncFace {
    public abstract void onlyOneAbstractMethod(Optional<String> opt);
    
    public default void additionalMethod() {
      System.out.println("An additional method");
    }
    
    public static void anotherAdditionalMethod() {
      System.out.println("Another additional method");
    }
  }
}
