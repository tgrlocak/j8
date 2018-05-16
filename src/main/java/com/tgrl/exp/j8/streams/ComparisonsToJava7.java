package com.tgrl.exp.j8.streams;

import static java.lang.System.out;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Arrays;
import org.hibernate.action.internal.CollectionUpdateAction;

import com.tgrl.exp.j8.model.Person;

public class ComparisonsToJava7 {

  private static List<Double> list = Collections.emptyList();

  static void init() {
    list.add(new Double(0.5));
    list.add(new Double(3.5));
    list.add(new Double(6.9));
    list.add(new Double(4));
  }

  public void comparison4FindingMaximum() {
    // Java 7
    double max = 0;

    for (Double d : list) {
      if (d > max) {
        max = d;
      }
    }
    // Java 8
    max = list.stream().reduce(0.0, Math::max);
    // or
    max = list.stream().mapToDouble(Number::doubleValue).max().getAsDouble();
  }

  public void comparison4CalculatingAverage() {
    double total = 0;
    double average = 0;

    // Java 7
    for (Double d : list) {
      total += d;
    }

    average = total / ((double) list.size());

    // Java 8
    average = list.stream().mapToDouble(Number::doubleValue).average().getAsDouble();
  }

  public void comparison4PrintingNumbers1to10() {
    // Java 7
    for (int i = 1; i < 11; i++) {
      out.println(i);
    }
    // Java 8
    IntStream.range(1, 11).forEach(out::println);
    // or
    Stream.iterate(1, i -> i + 1).limit(10).forEach(out::println);
  }

  public void comparison4JoiningStrings() {
    // Java 7 using commons-util
    List<String> names = new LinkedList<>();
    for (Person person : Person.getPersons()) {
      names.add(person.getFirstName());
    }

    String nameStrIn7 = StringUtils.join(names, ",");
    // Java 8
    String nameStrIn8 =
        Person.getPersons().stream().map(Person::getFirstName).collect(Collectors.joining(","));
  }

}
