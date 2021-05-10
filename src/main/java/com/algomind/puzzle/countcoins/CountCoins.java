package com.algomind.puzzle.countcoins;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCoins {
    private static final int[] coins = new int[] {25, 10, 5, 1};

    public List<Map<Integer, Integer>> count(int amount) {
        List<Map<Integer, Integer>> results = new ArrayList<>();
        doCount(results, ImmutableMap.of(25, 0, 10, 0, 5, 0, 1, 0), amount, 0, 25);
        return results;
    }

    private void doCount(List<Map<Integer, Integer>> results, Map<Integer, Integer> coinCount, int amount, int sum, int highest) {
        if(amount == sum) results.add(coinCount);
        if(sum > amount) return;

        for(int coin : coins) {
            if(coin <= highest) {
                Map<Integer, Integer> coinCountCopy = new HashMap<>(coinCount);
                coinCountCopy.put(coin, coinCountCopy.get(coin) + 1);
                doCount(results, coinCountCopy, amount, sum + coin, coin);
            }
        }
    }
}
