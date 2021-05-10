package com.algomind.puzzle.jumpontheclouds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JumpOnTheCloudsTest {
    private final JumpOnTheClouds jumpOnTheClouds = new JumpOnTheClouds();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int result, int[] cloud, int jump) {
        Assertions.assertEquals(result, jumpOnTheClouds.jumpingOnTheClouds(cloud, jump));
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(92, new int[]{0,0,1,0,0,1,1,0}, 2)
        );
    }
}