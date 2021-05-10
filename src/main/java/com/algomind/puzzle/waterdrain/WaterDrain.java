package com.algomind.puzzle.waterdrain;

import java.util.ArrayList;
import java.util.List;

public class WaterDrain {
    private static class Grid {
        private int[][] grid;

        public Grid() {
            grid = new int[][]
            {
                    {5, 6, 11, 9},
                    {6, 9, 10, 11},
                    {12, 15, 2, 14},
                    {14, 10, 3, 19},
                    {11, 5, 3, 21},
                    {10, 11, 8, 22},
                    {7, 12, 10, 18}
            };
        }

        public int getHeight(int x, int y) {
            if(x < 0 || x > grid[0].length - 1 || y < 0 || y > grid.length - 1 ) return 0;
            return grid[y][x];
        }
    }

    private static class Point {
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(! (obj instanceof Point)) return false;

            Point p = (Point)obj;
            return this.x == p.x && this.y == p.y;
        }
    }

    private static class Solver {
        private boolean canFormPool(Grid grid, int x, int y, List<Point> searchedPoint) {
            int height = grid.getHeight(x, y);
            if(height == 0) return false;

            searchedPoint.add(new Point(x, y));

            List<Point> lowTerran = findLowTerran(grid, height, x, y);
            if(lowTerran.isEmpty())
                return true;
            else {
                for(Point lowPoint : lowTerran) {
                    if(!searchedPoint.contains(lowPoint)) {
                        boolean willFormPool = canFormPool(grid, lowPoint.x, lowPoint.y, searchedPoint);
                        if (!willFormPool) return false;
                    }
                }
            }

            return true;
        }

        private List<Point> findLowTerran(Grid grid, int height, int x, int y) {
            List<Point> lowTerran = new ArrayList<>();

            int heightNorth = grid.getHeight(x, y -1);
            if(heightNorth <= height) lowTerran.add(new Point(x, y - 1));

            int heightWest = grid.getHeight(x - 1, y);
            if(heightWest <= height) lowTerran.add(new Point(x - 1, y));

            int heightSouth = grid.getHeight(x, y + 1);
            if(heightSouth <= height) lowTerran.add(new Point(x, y + 1));

            int heightEast = grid.getHeight(x + 1, y);
            if(heightEast <= height) lowTerran.add(new Point(x + 1, y));

            return lowTerran;
        }

        public static void main(String argv[]) {
            Solver solver = new Solver();

            boolean result00 = solver.canFormPool(new Grid(), 0, 0, new ArrayList<>());
            System.out.println("0 , 0 -> " + result00);

            boolean result01 = solver.canFormPool(new Grid(), 0, 1, new ArrayList<>());
            System.out.println("0 , 1 -> " + result01);

            boolean result10 = solver.canFormPool(new Grid(), 1, 0, new ArrayList<>());
            System.out.println("1 , 0 -> " + result01);

            boolean result11 = solver.canFormPool(new Grid(), 1, 1, new ArrayList<>());
            System.out.println("1 , 1 -> " + result11);

            boolean result21 = solver.canFormPool(new Grid(), 2, 1, new ArrayList<>());
            System.out.println("2 , 1 -> " + result21);

            boolean result23 = solver.canFormPool(new Grid(), 2, 3, new ArrayList<>());
            System.out.println("2 , 3 -> " + result23);

            boolean result25 = solver.canFormPool(new Grid(), 2, 5, new ArrayList<>());
            System.out.println("2 , 5 -> " + result25);

        }
    }
}
