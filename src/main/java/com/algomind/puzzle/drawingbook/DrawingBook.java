package com.algomind.puzzle.drawingbook;

import java.util.stream.IntStream;

public class DrawingBook {
    public int pageCount(int n, int p) {
        if(p <= n/2) {
            return IntStream.rangeClosed(0, n / 2).filter(i -> 2*i == p || 2*i + 1 == p).findFirst().getAsInt();
        }else {
            if(n % 2 != 0) {
                if(n == p) return 0;
                else return IntStream.rangeClosed(0, n / 2).filter(i -> n - 2 * i == p || n - 2 * i - 1 == p).findFirst().getAsInt();
            }else{
                return IntStream.rangeClosed(0, n / 2).filter(i -> n - 2 * i == p || n - 2 * i + 1 == p).findFirst().getAsInt();
            }
        }
    }
}
