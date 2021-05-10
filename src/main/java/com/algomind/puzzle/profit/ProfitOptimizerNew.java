package com.algomind.puzzle.profit;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProfitOptimizerNew {
    public Pair getProfit(int[] prices) {
        List<Entry> list = IntStream.range(0, prices.length)
                .mapToObj(i -> new Entry(i, prices[i])).sorted(Comparator.comparingInt(o -> o.number)).collect(Collectors.toList());

        list.forEach(entry -> System.out.println(entry.number + "," + entry.index));

        Pair result = null;

        outterloop:
        for(int i = 0 ; i < list.size() ; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                int iIndex = list.get(i).index;
                int jIndex = list.get(j).index;

                if (jIndex > iIndex) {
                    result = new Pair();
                    result.setBuyIndex(list.get(i).index);
                    result.setSellIndex(list.get(j).index);
                    break outterloop;
                }
            }
        }

        if(result == null) {
            result = new Pair();
            result.setBuyIndex(list.get(list.size() - 1).index);
            result.setSellIndex(list.get(list.size() - 2).index);
        }

        return result;
    }

    public static class Entry {
        public int index;
        public int number;

        public Entry(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }

    public static class Pair {
        private int buyIndex;
        private int sellIndex;

        public int getBuyIndex() {
            return buyIndex;
        }

        public void setBuyIndex(int buyIndex) {
            this.buyIndex = buyIndex;
        }

        public int getSellIndex() {
            return sellIndex;
        }

        public void setSellIndex(int sellIndex) {
            this.sellIndex = sellIndex;
        }
    }

    public static void main(String argv[]) {
        ProfitOptimizerNew profitOptimizerNew = new ProfitOptimizerNew();
        int[] prices = new int[] {3, 5, 2, 8, 5, 2, 5, 10, 2, 1};
        profitOptimizerNew.getProfit(prices);
    }
}
