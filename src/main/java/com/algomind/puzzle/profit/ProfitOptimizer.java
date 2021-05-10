package com.algomind.puzzle.profit;

public class ProfitOptimizer {
    public Pair getProfit(int[] prices) {
        int buyIndex = 0;
        int sellIndex = 1;
        int buyCandidateIndex = 0;
        int profit = prices[sellIndex] - prices[buyIndex];

        for(int i = 2 ; i < prices.length; i++) {
            if(prices[i] - prices[buyCandidateIndex] > profit) {
                buyIndex = buyCandidateIndex;
                sellIndex = i;
            }else if(prices[i] < prices[buyIndex]) {
                buyCandidateIndex = i;
            }else if(prices[i] - prices[buyIndex] > profit) {
                sellIndex = i;
            }
            profit = prices[sellIndex] - prices[buyIndex];
        }

        return new Pair(buyIndex, sellIndex);
    }

    public static class Pair {
        private int buyIndex;
        private int sellIndex;

        public Pair(int buyIndex, int sellIndex) {
            this.buyIndex = buyIndex;
            this.sellIndex = sellIndex;
        }

        public int getBuyIndex() {
            return buyIndex;
        }

        public int getSellIndex() {
            return sellIndex;
        }
    }
}
