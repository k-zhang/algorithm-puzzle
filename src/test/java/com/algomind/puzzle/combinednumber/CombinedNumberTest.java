package com.algomind.puzzle.combinednumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CombinedNumberTest {
    @Test
    public void testInput1() {
        int[] input = new int[] {50, 2, 1, 9};
        CombinedNumber combinedNumber = new CombinedNumber();
        String result = combinedNumber.combinedNumber(input);
        Assertions.assertEquals("95021", result);
    }

    @Test
    public void testInput2() {
        int[] input = new int[] {5, 50, 56};
        CombinedNumber combinedNumber = new CombinedNumber();
        String result = combinedNumber.combinedNumber(input);
        Assertions.assertEquals("56550", result);
    }

    @Test
    public void testInput3() {
        int[] input = new int[] {420, 42, 423};
        CombinedNumber combinedNumber = new CombinedNumber();
        String result = combinedNumber.combinedNumber(input);
        Assertions.assertEquals("42423420", result);
    }
}