package com.algomind.puzzle.sherlockandsquares;

public class SherlockAndSquares {
    int sherlockAndSquares(int a, int b) {
        int lowerInt = (int)Math.ceil(Math.sqrt(a));
        int upperInt = (int)Math.floor(Math.sqrt(b));
        return upperInt - lowerInt + 1;
    }
}
