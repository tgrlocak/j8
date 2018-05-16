package com.tgrl.exp.j8.lambdas;

import static java.lang.System.out;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.hibernate.action.internal.CollectionUpdateAction;

import com.tgrl.exp.j8.model.Person;

import antlr.StringUtils;

public class ComparisonsToJava7 {

  public void comparison4ActionListener() {
    // Java 7
    ActionListener al1 = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
      }
    };

    // Java 8
    ActionListener al2 = e -> out.println(e.getActionCommand());
  }

  public void comparison4ListingStrings() {
    List<Object> list = Arrays.asList(new String[] {"a", "b", "c"});

    // Java 7
    for (Object s : list) {
      out.println(s);
    }

    // Java 8
    list.forEach(out::println);
  }

  public void comparison4SortingStrings() {
    List<String> list = Collections.emptyList();

    list.add("a");
    list.add("b");
    list.add("c");

    // Java 7
    Collections.sort(list, new Comparator<String>() {

      @Override
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    });

    // Java 8
    Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
    // or
    list.sort(Comparator.comparingInt(String::length));
  }

  /**
   * Sort a person list in Java 7 by last-name and then first-name and then sort with Java 8
   */
  public void comparison4SortingObjects() {
    List<Person> list = Person.getPersons();

    // Java 7
    Collections.sort(list, new Comparator<Person>() {

      @Override
      public int compare(Person p1, Person p2) {
        int result = p1.getLastName().compareTo(p2.getLastName());
        if (result == 0) {
          result = p1.getFirstName().compareTo(p2.getFirstName());
        }
        return result;
      }
    });

    // Java 8
    list.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
  }

}
