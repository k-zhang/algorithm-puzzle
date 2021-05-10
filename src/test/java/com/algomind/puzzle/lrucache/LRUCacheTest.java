package com.algomind.puzzle.lrucache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {
    @Test
    public void testAddSingleElement() {
        LRUCache<String, Integer> lruCache = new LRUCache<>(2);
        lruCache.put("ONE", 1);
        Assertions.assertEquals(1, lruCache.get("ONE").intValue());
    }

    @Test
    public void testAddTwoElements() {
        LRUCache<String, Integer> lruCache = new LRUCache<>(2);
        lruCache.put("ONE", 1);
        lruCache.put("TWO", 2);
        Assertions.assertEquals(1, lruCache.get("ONE").intValue());
        Assertions.assertEquals(2, lruCache.get("TWO").intValue());
    }

    @Test
    public void testLRUShouldBeRemoved() {
        LRUCache<String, Integer> lruCache = new LRUCache<>(2);
        lruCache.put("ONE", 1);
        lruCache.put("TWO", 2);
        lruCache.put("THREE", 3);
        Assertions.assertNull(lruCache.get("ONE"));
        Assertions.assertEquals(2, lruCache.get("TWO").intValue());
        Assertions.assertEquals(3, lruCache.get("THREE").intValue());
    }

    @Test
    public void testRewriteExistingCacheEntry() {
        LRUCache<String, Integer> lruCache = new LRUCache<>(2);
        lruCache.put("ONE", 1);
        lruCache.put("TWO", 2);
        lruCache.put("ONE", 11);
        Assertions.assertEquals(11, lruCache.get("ONE").intValue());
        Assertions.assertEquals(2, lruCache.get("TWO").intValue());
    }

    @Test
    public void testReadShouldChangeLRU() {
        LRUCache<String, Integer> lruCache = new LRUCache<>(2);
        lruCache.put("ONE", 1);
        lruCache.put("TWO", 2);
        Assertions.assertEquals(1, lruCache.get("ONE").intValue());

        lruCache.put("THREE", 3);
        Assertions.assertEquals(1, lruCache.get("ONE").intValue());
        Assertions.assertNull(lruCache.get("TWO"));
        Assertions.assertEquals(3, lruCache.get("THREE").intValue());
    }

    @Test
    public void testGetFromEmptyCache() {
        LRUCache<String, Integer> lruCache = new LRUCache<>(2);
        Assertions.assertNull(lruCache.get("ONE"));
        Assertions.assertNull(lruCache.get("ONE"));
    }
}