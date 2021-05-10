package com.algomind.puzzle.angryprofessor;

import java.util.Arrays;

public class AngryProfessor {
    public String angryProfessor(int k, int[] a) {
        long onTimeCount = Arrays.stream(a).filter(n -> n <= 0).count();
        return onTimeCount >= k ? "NO" : "YES";
    }
}
