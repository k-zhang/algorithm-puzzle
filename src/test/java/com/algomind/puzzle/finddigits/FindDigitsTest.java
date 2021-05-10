package com.algomind.puzzle.finddigits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindDigitsTest {
    private final FindDigits findDigits = new FindDigits();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int result, int number) {
        Assertions.assertEquals(result, findDigits.findDigits(number));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2, 12),
                Arguments.of(3, 1012)
        );
    }
}