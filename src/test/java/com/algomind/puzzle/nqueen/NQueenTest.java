package com.algomind.puzzle.nqueen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NQueenTest {
    NQueen nQueen = new NQueen();

    @Test
    public void testSize1() {
        List<int[][]> results = nQueen.search(1);
        Assertions.assertEquals(1, results.size());
    }

    @Test
    public void testSize2() {
        List<int[][]> results = nQueen.search(2);
        Assertions.assertEquals(0, results.size());
    }

    @Test
    public void testSize3() {
        List<int[][]> results = nQueen.search(3);
        Assertions.assertEquals(0, results.size());
    }

    @Test
    public void testSize4() {
        List<int[][]> results = nQueen.search(4);
        Assertions.assertEquals(2, results.size());
    }

    @Test
    public void testSize5() {
        List<int[][]> results = nQueen.search(5);
        Assertions.assertEquals(10, results.size());
    }

    @Test
    public void testSize6() {
        List<int[][]> results = nQueen.search(6);
        Assertions.assertEquals(4, results.size());
    }

    @Test
    public void testSize7() {
        List<int[][]> results = nQueen.search(7);
        Assertions.assertEquals(40, results.size());
    }

    @Test
    public void testSize8() {
        List<int[][]> results = nQueen.search(8);
        Assertions.assertEquals(92, results.size());
        drawResults(8, results);
    }

    private void drawResults(int n, List<int[][]> results) {
        for(int[][] result : results) {
            System.out.println("----------------------");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    String icon = result[i][j] == 2 ? "X" : "o";
                    System.out.print(icon + "  ");
                }
                System.out.println();
            }
            System.out.println("----------------------");
        }
    }
}