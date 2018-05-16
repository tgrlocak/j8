package com.tgrl.exp.j8.streams;

import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.out;

import java.io.IOException;

/**
 * The most basic thing you can do with a Stream is loop through it using the forEach method.
 * @author tugrul.ocak
 *
 */
public class ForEachOfStreams {

  public void useTheForEachMethodOfAStream() throws IOException {
    Files.list(Paths.get(".")).forEach(out::println);
  }
}
