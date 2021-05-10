package com.algomind.puzzle.libraryfine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LibraryFineTest {
    private final LibraryFine libraryFine = new LibraryFine();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int result, int d1, int m1, int y1, int d2, int m2, int y2) {
        Assertions.assertEquals(result, libraryFine.libraryFine(d1, m1, y1, d2, m2, y2));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(0, 9, 6, 2015, 6, 10, 2015),
            Arguments.of(45, 9, 6, 2015, 6, 6, 2015),
            Arguments.of(500, 9, 6, 2015, 6, 5, 2015),
            Arguments.of(10000, 9, 6, 2015, 6, 5, 2014)
        );
    }
}