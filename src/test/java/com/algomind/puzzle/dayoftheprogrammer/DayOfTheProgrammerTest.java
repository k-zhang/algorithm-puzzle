package com.algomind.puzzle.dayoftheprogrammer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DayOfTheProgrammerTest {
    private DayOfTheProgrammer dayOfTheProgrammer = new DayOfTheProgrammer();

    @Test
    public void testYearAfter1918() {
        String result = dayOfTheProgrammer.dayOfProgrammer(2019);
        Assertions.assertEquals("13.09.2019", result);
    }

    @Test
    public void testYearBefore1918() {
        String result = dayOfTheProgrammer.dayOfProgrammer(1800);
        Assertions.assertEquals("12.09.1800", result);
    }

    @Test
    public void test1918() {
        String result = dayOfTheProgrammer.dayOfProgrammer(1918);
        Assertions.assertEquals("26.09.1918", result);
    }
}