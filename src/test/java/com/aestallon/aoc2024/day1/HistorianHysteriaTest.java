package com.aestallon.aoc2024.day1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.assertThat;

class HistorianHysteriaTest {

  private static final Logger log = LoggerFactory.getLogger(HistorianHysteriaTest.class);
  private static HistorianHysteria historianHysteria;
  
  @BeforeAll
  static void beforeAll() {
    historianHysteria = new HistorianHysteria();
  }
  
  @Test
  void problemA() {
    final long solution = historianHysteria.solveA();
    log.info("Problem A solution: {}", solution);
    assertThat(solution).isEqualTo(936_063L);
  }

  @Test
  void problemB() {
    final long solution = historianHysteria.solveB();
    log.info("Problem B solution: {}", solution);
    assertThat(solution).isEqualTo(23_150_395L);
  }

}