package com.algomind.puzzle.combinednumber;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CombinedNumber {
    private static class Number {
        private final int actualNumber;
        private final String repNumber;

        Number(int actualNumber) {
            this.actualNumber = actualNumber;
            this.repNumber = String.valueOf(actualNumber) + String.valueOf(actualNumber).charAt(0);
        }
    }

    public String combinedNumber(int[] numbers) {
        TreeSet<Number> numberTreeSet = new TreeSet<>((o1, o2) -> (-1) * o1.repNumber.compareTo(o2.repNumber));
        Arrays.stream(numbers).forEach(number -> numberTreeSet.add(new Number(number)));
        return numberTreeSet.stream().map(n -> String.valueOf(n.actualNumber)).collect(Collectors.joining(""));
    }
}
