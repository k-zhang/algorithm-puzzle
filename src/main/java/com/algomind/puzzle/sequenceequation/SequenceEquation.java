package com.algomind.puzzle.sequenceequation;

public class SequenceEquation {
    int[] sequenceEquation(int[] p) {
        int[] firstLevelIndex = new int[p.length];

        for(int i = 1 ; i <= p.length ; i++) {
            for(int j = 0 ; j < p.length ; j ++) {
                if(p[j] == i) {
                    firstLevelIndex[i-1] = j + 1;
                    break;
                }
            }
        }

        int[] secondLevelIndex = new int[p.length];
        for(int i = 0 ; i < p.length ; i++) {
            for(int j = 0 ; j < p.length ; j ++) {
                if(p[j] == firstLevelIndex[i]) {
                    secondLevelIndex[i] = j + 1;
                    break;
                }
            }
        }

        return secondLevelIndex;
    }
}
