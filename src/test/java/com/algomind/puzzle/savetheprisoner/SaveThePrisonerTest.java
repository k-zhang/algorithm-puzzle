package com.algomind.puzzle.savetheprisoner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaveThePrisonerTest {
    private final SaveThePrisoner saveThePrisoner = new SaveThePrisoner();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int result, int n, int m, int s) {
        assertEquals(result, saveThePrisoner.saveThePrisoner(n, m, s));
    }

    public static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, 4, 6, 2),
                Arguments.of(6, 7, 19, 2),
                Arguments.of(3, 3, 7, 3)
        );
    }
}