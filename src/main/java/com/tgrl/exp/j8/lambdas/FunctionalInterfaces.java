package com.tgrl.exp.j8.lambdas;

import java.util.function.Function;

import org.assertj.core.util.Arrays;

import static java.lang.System.out;

public class FunctionalInterfaces {

  public void aSmallExampleForFunctionalInterfaces(String[] args) {
    Function<String, String> atr = (name) -> {return "@" + name;};
    
    Function<String, Integer> leng = (name) -> name.length();
    
    Function<String, Integer> leng2 = String::length;
    
    Arrays.asList(args).forEach(s -> out.println(leng2.apply((String) s)));
  }
  
  
}
