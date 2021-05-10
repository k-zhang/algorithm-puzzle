package com.algomind.puzzle.savetheprisoner;

public class SaveThePrisoner {
    int saveThePrisoner(int n, int m, int s) {
        int result = (s + (m - 1)) % n;
        if(result == 0) result = n;
        return result;
    }
}
