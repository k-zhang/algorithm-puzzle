package com.algomind.puzzle.utopiantree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtopianTreeTest {
    private final UtopianTree utopianTree = new UtopianTree();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int n, int expected) {
        int result = utopianTree.utopianTree(n);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 2),
                Arguments.of(4, 7)
        );
    }
}