package com.algomind.puzzle.beautifulday;

import java.util.stream.IntStream;

public class BeautifulDay {
    public int beautifulDays(int i, int j, int k) {
        return (int)IntStream.rangeClosed(i, j)
                .map(n -> Math.abs(n - Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString())))
                .filter(n -> n % k == 0)
                .count();
    }
}
