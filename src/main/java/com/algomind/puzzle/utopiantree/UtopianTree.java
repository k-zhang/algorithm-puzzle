package com.algomind.puzzle.utopiantree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class UtopianTree {
    private List<Function<Integer, Integer>> growthPeriods;

    public UtopianTree() {
        this.growthPeriods = ImmutableList.of(
                (n) -> n * 2,
                (n) -> n + 1
        );
    }

    public int utopianTree(int n) {
        return IntStream.range(0, n).reduce(1, (a, b) -> growthPeriods.get(b % 2).apply(a));
    }
}
