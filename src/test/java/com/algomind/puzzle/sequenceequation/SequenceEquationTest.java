package com.algomind.puzzle.sequenceequation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SequenceEquationTest {
    private final SequenceEquation sequenceEquation = new SequenceEquation();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] result, int[] array) {
        Assertions.assertArrayEquals(result, sequenceEquation.sequenceEquation(array));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(Arguments.of(new int[]{2,3,1}, new int[]{2,3,1}));
    }
}