package com.aestallon.aoc2024.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aestallon.aoc2024.AocProblem;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class HistorianHysteria extends AocProblem {

  private static final Logger log = LoggerFactory.getLogger(HistorianHysteria.class);

  private static final String REGEX = "^(\\d+)\\s+(\\d+)$";
  private static final Pattern PATTERN = Pattern.compile(REGEX);

  private final List<Integer> listA = new ArrayList<>();
  private final List<Integer> listB = new ArrayList<>();

  protected HistorianHysteria() {
    super(1);
    init();
  }

  private void init() {
    final List<String> input = readInput();
    for (final var line : input) {
      parseLine(line);
    }
  }

  private void parseLine(final String line) {
    if (line == null || line.isBlank()) {
      log.warn("Encountered empty line!");
      return;
    }

    final Matcher m = PATTERN.matcher(line);
    if (!m.matches()) {
      log.warn("Line does not match pattern! {} -> {}", line, REGEX);
      return;
    }

    final String a = m.group(1);
    final String b = m.group(2);
    listA.add(Integer.parseInt(a));
    listB.add(Integer.parseInt(b));
  }

  @Override
  public long solveA() {
    final var as = new ArrayList<>(listA);
    final var bs = new ArrayList<>(listB);
    Collections.sort(as);
    Collections.sort(bs);

    return IntStream.range(0, as.size())
        .map(i -> Math.abs(as.get(i) - bs.get(i)))
        .sum();
  }

  @Override
  public long solveB() {
    final var frequenciesOfB = listB.stream().collect(groupingBy(it -> it, counting()));
    return listA.stream()
        .mapToLong(it -> {
          final long score = frequenciesOfB.getOrDefault(it, 0L);
          return it * score;
        })
        .sum();
  }
}
