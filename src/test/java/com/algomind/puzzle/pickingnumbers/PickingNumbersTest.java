package com.algomind.puzzle.pickingnumbers;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PickingNumbersTest {
    private final PickingNumbers pickingNumbers = new PickingNumbers();

    @ParameterizedTest
    @MethodSource("provideIntList")
    public void testDataInput(List<Integer> input, int expected) {
        int result = pickingNumbers.pickingNumbers(input);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideIntList() {
        return Stream.of(
                Arguments.of(ImmutableList.of(4, 6, 5, 3, 3, 1), 3),
                Arguments.of(ImmutableList.of(1, 2, 2, 3, 1, 2), 5),
                Arguments.of(ImmutableList.of(), 0),
                Arguments.of(ImmutableList.of(1, 1, 1, 1), 4),
                Arguments.of(ImmutableList.of(1), 0),
                Arguments.of(ImmutableList.of(1, 1, 1, 1, 3, 3, 4), 4),
                Arguments.of(ImmutableList.of(1, 3, 5, 7), 0));
    }
}