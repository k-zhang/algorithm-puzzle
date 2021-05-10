package com.algomind.puzzle.countingvalleys;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountingValleys {
    public int countingValleys(int n, String s) {
        String[] seq = s.split("");
        int[] upDown = Arrays.stream(seq).mapToInt(l -> l.equals("U") ? 1 : -1).toArray();
        Arrays.parallelPrefix(upDown, Integer::sum);
        return (int) IntStream.rangeClosed(1, n - 1).filter(i -> upDown[i] == 0 && upDown[i-1] < 0).count();
    }
}
