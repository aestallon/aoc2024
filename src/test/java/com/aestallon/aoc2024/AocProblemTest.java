package com.aestallon.aoc2024;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AocProblemTest {

  @Test
  void baseClassCorrectlyLocatesItsFile() {
    final var testProblem = new AocProblem(32) {};
    final var testInput = testProblem.readInput();
    assertThat(testInput).hasSize(3);
  }

}