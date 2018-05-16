package com.tgrl.exp.j8.streams;

import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.tgrl.exp.j8.model.Person;

import static java.lang.System.out;

/**
 * Since Streams are lazily evaluated and support parallel execution, you need a special way to
 * combine results; this is called a <code>Collector</code>.
 * 
 * <p>
 * A <code>Collector</code> represents a way to combine the elements of a Stream into one result. It consists of
 * three things:
 * 
 * - A <i>supplier</i> of an initial value. <br/> 
 * - An <i>accumulator</i> which adds to the initial value. <br/> 
 * - A <i>combiner</i> which combines two results into one. <br/>
 * </p>
 * <p>
 * There are two ways to do this: <code>collect(supplier,accumulator,combiner)</code>, or <code>collect(Collector)</code> (types left off for brevity).
 * </p>
 * <p>
 * Don't forget to add this in imports: 
 * <code><b>import static java.util.stream.Collectors.*;</b></code>
 * </p>
 * @author tugrul.ocak
 *
 */
public class CollectorsAndStatistics {

  public static List<Person> persons = Person.getPersons();

  public void anEasyUsageOfCollectors() {
    // Accumulates names into a list
    List<String> list =
        persons.stream().map(Person::getFirstName).collect(toList()/* Collectors.toList() */);

    // Accumulates names into a TreeSet
    Set<String> set = persons.stream().map(Person::getFirstName).collect(toCollection(TreeSet::new));
  }

  /**
   * If you’re familiar with Apache Commons’ <code>StringUtil.join</code>, the joining collector is
   * similar to it. It combines the stream using a given delimiter. <br/>
   * The below code will combine all of the names into one <code>String</code> separated by commas
   */
  public void joiningExampleWithCollectors() {
    String names = persons.stream().map(Person::getFirstName).collect(joining(","));
  }
  
  /**
   * The below code calculates the average length of non-empty lines in the file “<code>Nio.java</code>”.
   * 
   * @throws IOException
   */
  public void statisticsUsageOfCollectors() throws IOException {
    out.println("\n-----> Average line length:");
    Double d = Files.lines(Paths.get("Nio.java")).map(String::trim).filter(s -> !s.isEmpty())
        .collect(averagingInt(String::length));
    out.println(d.doubleValue());
  }
  
  /**
   * Sometimes you want to collect multiple statistics about a collection. Because Streams are
   * consumed when you call <code>collect</code>, you need to calculate all of your statistics at
   * once. This is where <code>SummaryStatistics</code> comes in. First import the one you want to
   * use: <code><b>import java.util.IntSummaryStatistics; </b> </code> 
   * 
   * @author tugrul.ocak
   * @throws IOException
   *
   */
  public void usageOfSummaryStatistics() throws IOException {
    IntSummaryStatistics stats = Files.lines(Paths.get("Nio.java")).map(String::trim)
        .filter(s -> !s.isEmpty()).collect(summarizingInt(String::length));

    out.println(stats.getAverage());
    out.println("count=" + stats.getCount());
    out.println("max=" + stats.getMax());
    out.println("min=" + stats.getMin());

    // Equivalently, you can map your stream to a primitive type and then call summaryStatistics()
    IntSummaryStatistics stats2 = Files.lines(Paths.get("Nio.java")).map(String::trim)
        .filter(s -> !s.isEmpty()).mapToInt(String::length).summaryStatistics();

  }

}
