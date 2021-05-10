package com.algomind.puzzle.angryprofessor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AngryProfessorTest {
    private final AngryProfessor angryProfessor = new AngryProfessor();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int k, int[] arrivalTime, String expected) {
        String result = angryProfessor.angryProfessor(k, arrivalTime);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(3, new int[]{-1, -3, 4, 2}, "YES"),
                Arguments.of(2, new int[]{0, -1, 2, 1}, "NO")
        );
    }
}