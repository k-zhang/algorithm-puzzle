package com.algomind.puzzle.beautifulday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BeautifulDayTest {
    private final BeautifulDay beautifulDay = new BeautifulDay();

    @ParameterizedTest
    @MethodSource("provideData")
    public void testBeautifulDay(int i, int j, int k, int expected) {
        int result = beautifulDay.beautifulDays(i, j, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(20, 23, 6, 2),
            Arguments.of(19, 19, 6, 1),
            Arguments.of(1, 10, 6, 9)
        );
    }
}