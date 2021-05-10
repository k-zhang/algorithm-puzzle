package com.algomind.puzzle.countcoins;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class CountCoinsTest {
    @Test
    public void testCountCoinsFor_15() {
        CountCoins countCoins = new CountCoins();

        List<Map<Integer, Integer>> results = countCoins.count(15);
        Assertions.assertEquals(6, results.size());

        printResult(results);
    }


    @Test
    public void testCountCoinsFor_100() {
        CountCoins countCoins = new CountCoins();

        List<Map<Integer, Integer>> results = countCoins.count(100);
        Assertions.assertEquals(242, results.size());

        printResult(results);
    }

    private void printResult(List<Map<Integer, Integer>> results) {
        final int[] coins = new int[] {25, 10, 5, 1};

        for(Map<Integer, Integer> result : results) {
            System.out.println("-------------");

            for(int coin : coins) {
                int count = result.get(coin);
                System.out.println("Coin " + coin + " : " + count);
            }

            System.out.println("-------------");
        }
    }
}