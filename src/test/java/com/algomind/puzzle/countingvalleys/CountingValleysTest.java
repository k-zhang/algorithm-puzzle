package com.algomind.puzzle.countingvalleys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountingValleysTest {
    private CountingValleys countingValleys = new CountingValleys();

    @Test
    public void testOneValley() {
        String input = "UDDDUDUU";
        int result = countingValleys.countingValleys(input.length(), input);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testTwoValley() {
        String input = "UDDDUDUUDDDUDUUU";
        int result = countingValleys.countingValleys(input.length(), input);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void testNoValley() {
        String input = "UUUUDDDD";
        int result = countingValleys.countingValleys(input.length(), input);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testTwoStepValley() {
        String input = "DU";
        int result = countingValleys.countingValleys(input.length(), input);
        Assertions.assertEquals(1, result);
    }
}