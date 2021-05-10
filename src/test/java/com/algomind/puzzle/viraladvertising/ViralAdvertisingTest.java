package com.algomind.puzzle.viraladvertising;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ViralAdvertisingTest {
    private final ViralAdvertising viralAdvertising = new ViralAdvertising();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int n, int expected) {
        int result = viralAdvertising.viralAdvertising(n);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, 9),
                Arguments.of(5, 24)
        );
    }
}