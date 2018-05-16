package com.tgrl.exp.j8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static java.lang.System.out;

public class SortingOnStreams {

  public void sortingWithLimitOnStream() {
    Random r = new Random();

    r.ints().limit(50).sorted().forEach(out::println);
  }

  /**
   * The code below does the following:
   * 
   * <p>
   * Lists the files in the current directory. <br/>
   * Maps those files to file names. <br/>
   * Finds names that end with “.java”. <br/>
   * Takes only the first five (sorted alphabetically). <br/>
   * Prints them out.
   * <p>
   * 
   * @throws IOException
   */
  public void anotherExampleForSorting() throws IOException {
    Files.list(Paths.get("."))
      .map(Path::getFileName) // still a path
      .map(Path::toString) // convert to Strings
      .filter(name -> name.endsWith(".java"))
      .sorted() // sort alphabetically
      .limit(5) // first 5
      .forEach(out::println);
  }
}
