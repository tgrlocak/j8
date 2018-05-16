package com.tgrl.exp.j8.streams;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamGenerations {

  public void createStreamFromCollection() {
    List<String> list = Collections.emptyList();

    list.stream();
    // or
    list.parallelStream();
  }

  public void streamingFiles() throws FileNotFoundException, IOException {
    try (FileReader fr = new FileReader("file"); BufferedReader buff = new BufferedReader(fr)) {
      buff.lines().forEach(out::println);
    }

    try (Stream<String> s = Files.lines(Paths.get("file"))) {
      s.forEach(out::println);
    }
  }

  /**
   * There are several static methods on the <code>Files</code> class for navigating file trees
   * using a Stream.
   * 
   * <code>list(Path dir)</code> – Stream of files in the given directory.
   * <code>walk(Path dir)</code> – Stream that traverses the file tree depth-first starting at the
   * given directory. <code>walk(Path dir, int maxDepth)</code> – Same as <code>walk(dir)</code> but
   * with a maximum depth.
   * 
   * @throws IOException
   */
  public void streamingFileTrees() throws IOException {
    Files.walk(Paths.get("naber"));

    Files.walk(Paths.get("iidir"), 5);
  }

  /**
   * The <code>Pattern</code> class now has a method, <code>splitAsStream</code>(CharSequence),
   * which creates a Stream.
   */
  public void streamingTextPatterns() {
    Pattern p = Pattern.compile(",");
    p.splitAsStream("a,b,c").forEach(out::println);
  }

  /**
   * Using the generate or iterate static methods on <code>Stream</code>, you can create a Stream of
   * values including never ending streams
   */
  public void infiniteStreams() {
    Stream.generate(() -> new String());

    // You could also use generate to create an infinite random number supply
    Stream.generate(() -> Math.random());

    // The iterate method is similar to generate except it takes an initial value and a Function
    // that modifies that value. For example, you can iterate over the Integers using the following
    // code:
    Stream.iterate(1, i -> i + 1).forEach(out::print);

  }

  public void rangesOfStream() {
    IntStream.range(1, 11).forEach(out::println);
  }

  public void streamingAnything() {
    // Stream.of can take any number of parameters of any type.
    Stream<Integer> s1 = Stream.of(1, 2, 3);
    Stream<Object> s2 = Arrays.stream(new Object[] {"a", 15, new Long(10L)});
  }
}
