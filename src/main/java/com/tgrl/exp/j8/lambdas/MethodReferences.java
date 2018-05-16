package com.tgrl.exp.j8.lambdas;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.System.out;

public class MethodReferences {

  public void tryMethodReferences() {
    Stream<File> pdfs = getFiles().filter(FileFilters::fileIsPdf);
    Stream<File> txts = getFiles().filter(FileFilters::fileIsTxt);
    Stream<File> rtfs = getFiles().filter(FileFilters::fileIsRtf);
  }

  public void anotherExampleForMethodReferences() throws IOException {
    Files.lines(Paths.get("Nio.java")).map(String::trim).forEach(out::println);
  }

  static class FileFilters {
    public static boolean fileIsPdf(File file) {
      return false;
    }

    public static boolean fileIsTxt(File file) {
      return false;
    }

    public static boolean fileIsRtf(File file) {
      return false;
    }
  }

  public Stream<File> getFiles() {
    return Stream.of(new File("."));
  }
}
