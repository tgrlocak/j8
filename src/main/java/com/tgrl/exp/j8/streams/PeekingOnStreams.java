package com.tgrl.exp.j8.streams;

import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PeekingOnStreams {

  public void anEasyPeekOperations() throws IOException {
    Files.list(Paths.get(".")).map(Path::getFileName).peek(out::println).forEach(p -> doSomething(p));;
  }
  
  public void doSomething(Path p) {
    
  }
}
