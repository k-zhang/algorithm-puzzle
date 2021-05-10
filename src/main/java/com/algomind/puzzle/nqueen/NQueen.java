package com.algomind.puzzle.nqueen;

import com.google.common.collect.Lists;

import java.util.List;

public class NQueen {
    public List<int[][]> search(int n) {
        List<int[][]> results = Lists.newArrayList();
        int[][] board = new int[n][n];

        doSearch(n, results, board, 0);

        return results;
    }

    private void doSearch(int n, List<int[][]> results, int[][] board, int x) {
        if(x == n) {
            results.add(board);
            return;
        }

        for(int y = 0 ; y < n ; y++) {
            if(board[x][y] == 0) {
                int[][] markedBoard = mark(n, board, x, y);
                doSearch(n, results, markedBoard, x + 1);
            }
        }
    }

    private int[][] mark(int n, int[][] board, int x, int y) {
        int[][] clonedBoard = deepClone(board);

        for(int i = 0 ; i < n ; i++) {
            clonedBoard[x][i] = 1;
            clonedBoard[i][y] = 1;

            int j = i + 1;
            if(x - j >= 0) {
                if(y - j >= 0) clonedBoard[x-j][y-j] = 1;
                if(y + j < n) clonedBoard[x-j][y+j] = 1;
            }

            if(x + j < n) {
                if (y - j >= 0) clonedBoard[x + j][y - j] = 1;
                if (y + j < n) clonedBoard[x + j][y + j] = 1;
            }
        }

        clonedBoard[x][y] = 2;

        return clonedBoard;
    }

    private int[][] deepClone(int[][] board) {
        int[][] cloned = new int[board.length][];
        for(int i = 0 ; i < board.length ; i++) {
            cloned[i] = board[i].clone();
        }
        return cloned;
    }
}
