package com.algomind.puzzle.lrucache;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LRUCachePlusTest {
    @Test
    public void testAddSingleElement() {
        LRUCachePlus<String, Integer> LRUCachePlus = new LRUCachePlus<>(2);
        LRUCachePlus.put("ONE", 1);
        Assertions.assertEquals(1, LRUCachePlus.get("ONE").intValue());
    }

    @Test
    public void testAddTwoElements() {
        LRUCachePlus<String, Integer> LRUCachePlus = new LRUCachePlus<>(2);
        LRUCachePlus.put("ONE", 1);
        LRUCachePlus.put("TWO", 2);
        Assertions.assertEquals(1, LRUCachePlus.get("ONE").intValue());
        Assertions.assertEquals(2, LRUCachePlus.get("TWO").intValue());
    }

    @Test
    public void testLRUShouldBeRemoved() {
        LRUCachePlus<String, Integer> LRUCachePlus = new LRUCachePlus<>(2);
        LRUCachePlus.put("ONE", 1);
        LRUCachePlus.put("TWO", 2);
        LRUCachePlus.put("THREE", 3);
        Assertions.assertNull(LRUCachePlus.get("ONE"));
        Assertions.assertEquals(2, LRUCachePlus.get("TWO").intValue());
        Assertions.assertEquals(3, LRUCachePlus.get("THREE").intValue());
    }

    @Test
    public void testRewriteExistingCacheEntry() {
        LRUCachePlus<String, Integer> LRUCachePlus = new LRUCachePlus<>(2);
        LRUCachePlus.put("ONE", 1);
        LRUCachePlus.put("TWO", 2);
        LRUCachePlus.put("ONE", 11);
        Assertions.assertEquals(11, LRUCachePlus.get("ONE").intValue());
        Assertions.assertEquals(2, LRUCachePlus.get("TWO").intValue());
    }

    @Test
    public void testReadShouldChangeLRU() {
        LRUCachePlus<String, Integer> LRUCachePlus = new LRUCachePlus<>(2);
        LRUCachePlus.put("ONE", 1);
        LRUCachePlus.put("TWO", 2);
        Assertions.assertEquals(1, LRUCachePlus.get("ONE").intValue());

        LRUCachePlus.put("THREE", 3);
        Assertions.assertEquals(1, LRUCachePlus.get("ONE").intValue());
        Assertions.assertNull(LRUCachePlus.get("TWO"));
        Assertions.assertEquals(3, LRUCachePlus.get("THREE").intValue());
    }

    @Test
    public void testGetFromEmptyCache() {
        LRUCachePlus<String, Integer> LRUCachePlus = new LRUCachePlus<>(2);
        Assertions.assertNull(LRUCachePlus.get("ONE"));
        Assertions.assertNull(LRUCachePlus.get("ONE"));
    }
}