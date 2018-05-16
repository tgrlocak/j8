package com.tgrl.exp.j8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tgrl.exp.j8.model.Person;

/**
 * The <code>groupingBy</code> collector groups elements based on a function you provide. <br/>
 * Similarly, the <code>partitioningBy</code> method creates a map with a boolean key.
 * 
 * @author tugrul.ocak
 *
 */
public class GroupsAndPartitions {

  public static List<Person> persons = Person.getPersons();

  public void groupByUsageOfStreams() {
    // Group by first letter of name
    Map<Character, List<Person>> map =
        persons.stream().collect(Collectors.groupingBy(person -> person.getFirstName().charAt(0)));
  }

  public void partitioningByUsageOfStreams() {
    // Group by whether or not the person is female
    Map<Boolean, List<Person>> map =
        persons.stream().collect(Collectors.partitioningBy(Person::isFemale));
  }

  public void parallelGroupingUsage() {
    persons.parallelStream().unordered().collect(Collectors.groupingByConcurrent(Person::getSth));
  }
}
