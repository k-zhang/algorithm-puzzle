package com.algomind.puzzle.repeatedstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedStringTest {
    @Test
    public void test() {
        RepeatedString repeatedString = new RepeatedString();
        long result = repeatedString.repeatedString("aba", 10);
        assertEquals(7, result);
    }
}