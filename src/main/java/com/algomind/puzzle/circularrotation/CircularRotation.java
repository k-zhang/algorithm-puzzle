package com.algomind.puzzle.circularrotation;

import java.util.Arrays;

public class CircularRotation {
    int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int numberOfRotation = k % a.length;
        return Arrays.stream(queries).map(i -> a[oldIndex(i, numberOfRotation, a.length)]).toArray();
    }

    private int oldIndex(int index, int numberOfRotation, int length) {
        int oldIndex = index - numberOfRotation;
        if(oldIndex < 0) oldIndex = oldIndex + length;
        return oldIndex;
    }
}
