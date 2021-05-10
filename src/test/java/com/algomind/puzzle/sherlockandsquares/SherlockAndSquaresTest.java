package com.algomind.puzzle.sherlockandsquares;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SherlockAndSquaresTest {
    private final SherlockAndSquares sherlockAndSquares = new SherlockAndSquares();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int result, int a, int b) {
        Assertions.assertEquals(result, sherlockAndSquares.sherlockAndSquares(a, b));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(2, 3, 9),
            Arguments.of(0, 17, 24)
        );
    }
}