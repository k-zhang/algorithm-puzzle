package com.algomind.puzzle.appendanddelete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AppendAndDeleteTest {
    private final AppendAndDelete appendAndDelete = new AppendAndDelete();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test (String result, String s, String t, int k){
        Assertions.assertEquals(result, appendAndDelete.appendAndDelete(s, t, k));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of("Yes", "aba", "aba", 7),
            Arguments.of("No", "ashley", "ash", 2),
            Arguments.of("Yes", "aaaaaaaaaa", "aaaaa", 7),
            Arguments.of("No", "qwerasdf", "qwerbsdf", 6),
            Arguments.of("No", "y", "yu", 2)
        );
    }
}