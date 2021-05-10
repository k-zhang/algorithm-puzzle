package com.algomind.puzzle.profit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfitOptimizerTest {
    private final ProfitOptimizer profitOptimizer = new ProfitOptimizer();

    @Test
    public void testRandom() {
        int[] prices = new int[] {3, 5, 2, 8, 5, 2, 5, 10, 2, 1};
        ProfitOptimizer.Pair result = profitOptimizer.getProfit(prices);

        Assertions.assertEquals(2, result.getBuyIndex());
        Assertions.assertEquals(7, result.getSellIndex());
    }

    @Test
    public void testAscend() {
        int[] prices = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ProfitOptimizer.Pair result = profitOptimizer.getProfit(prices);

        Assertions.assertEquals(0, result.getBuyIndex());
        Assertions.assertEquals(9, result.getSellIndex());
    }

    @Test
    public void testDescent() {
        int[] prices = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        ProfitOptimizer.Pair result = profitOptimizer.getProfit(prices);

        Assertions.assertEquals(0, result.getBuyIndex());
        Assertions.assertEquals(1, result.getSellIndex());
    }

    @Test
    public void testTwoElement() {
        int[] prices = new int[] {2, 1};
        ProfitOptimizer.Pair result = profitOptimizer.getProfit(prices);

        Assertions.assertEquals(0, result.getBuyIndex());
        Assertions.assertEquals(1, result.getSellIndex());
    }
}