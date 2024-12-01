package com.aestallon.aoc2024;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AocProblemTest {

  private static final class TestProblem extends AocProblem {

    private TestProblem(int day) {
      super(day);
    }

    @Override
    public long solveA() {
      return 0L;
    }

    @Override
    public long solveB() {
      return 0L;
    }
  }

  @Test
  void baseClassCorrectlyLocatesItsFile() {
    final var testProblem = new TestProblem(32);
    final var testInput = testProblem.readInput();
    assertThat(testInput).hasSize(3);
  }

}