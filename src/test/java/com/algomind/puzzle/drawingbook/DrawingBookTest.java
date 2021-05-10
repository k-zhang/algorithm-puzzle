package com.algomind.puzzle.drawingbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrawingBookTest {
    DrawingBook drawingBook = new DrawingBook();

    @Test
    public void testLookForPageOne() {
        int result = drawingBook.pageCount(6, 1);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testLookForPageTwo() {
        int result = drawingBook.pageCount(6, 2);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testLookForPageThree() {
        int result = drawingBook.pageCount(6, 3);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testLookForPageFour() {
        int result = drawingBook.pageCount(6, 4);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testLookForPageFive() {
        int result = drawingBook.pageCount(6, 5);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testLookForPageSix() {
        int result = drawingBook.pageCount(6, 6);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testOnePageBook() {
        int result = drawingBook.pageCount(1, 1);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testTwoPageBookForPageOne() {
        int result = drawingBook.pageCount(1, 1);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testTwoPageBookForPageTwo() {
        int result = drawingBook.pageCount(1, 1);
        Assertions.assertEquals(0, result);
    }
}