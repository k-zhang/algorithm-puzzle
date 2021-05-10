package com.algomind.puzzle.viraladvertising;

import java.util.stream.Stream;

public class ViralAdvertising {
    public int viralAdvertising(int n) {
        return Stream.iterate((int) Math.floor(5 / 2d), i -> (int) Math.floor((i * 3) / 2d)).limit(n).mapToInt(i -> i).sum();
    }
}
