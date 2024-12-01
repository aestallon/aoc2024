package com.aestallon.aoc2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AocProblem {

  private static final Logger log = LoggerFactory.getLogger(AocProblem.class);

  private final int day;

  protected AocProblem(int day) {
    this.day = day;
  }

  protected List<String> readInput() {
    final String inputFile = String.format("/%02d.txt", day);
    try (InputStream inputStream = AocProblem.class.getResourceAsStream(inputFile);) {
      if (inputStream == null) {
        log.error("Could not find input file {}", inputFile);
        return Collections.emptyList();
      }

      try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
          BufferedReader reader = new BufferedReader(inputStreamReader)) {
        return reader.lines().collect(Collectors.toList());
      }

    } catch (IOException e) {
      log.error(e.getMessage(), e);
      return Collections.emptyList();
    }
  }

  public abstract long solveA();

  public abstract long solveB();

}
