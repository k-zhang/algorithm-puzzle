package com.algomind.puzzle.lrucache;

import java.util.HashMap;
import java.util.Map;

/// Write the Least Re-Used Cache (LRU Cache) implementation
/// A LRU cache is a cache with fixed size. It works like a normal key/value cache until
/// the cache reaches its maximum capacity, at which point, the most least reused data item
/// should be removed to make room for any new item.
///
/// This implementation uses a HashMap together with a managed linked list.
/// This implementation is not thread-safe

class LRUCache<K, V> {
    private final int capacity;
    private Map<K, CacheValueItem<K, V>> cache;
    private CacheValueItem<K, V> head = null;
    private CacheValueItem<K, V> tail = null;

    LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    V get(K key) {
        if(cache.containsKey(key)) {
            CacheValueItem<K, V> result = cache.get(key);
            removeFromList(result);
            addToTail(result);
            return result.getValue();
        }
        return null;
    }

    void put(K key, V value) {
        if(cache.containsKey(key)) {
            CacheValueItem<K, V> existingCacheValueItem = cache.get(key);
            existingCacheValueItem.setValue(value);
            removeFromList(existingCacheValueItem);
            addToTail(existingCacheValueItem);
        }else{
            if(cache.size() == capacity) {
                cache.remove(head.getKey());
                removeFromList(head);
            }
            CacheValueItem<K, V> cacheValueItem = new CacheValueItem<>(key, value);
            cache.put(key, cacheValueItem);
            addToTail(cacheValueItem);
        }
    }

    private void removeFromList(CacheValueItem<K, V> item) {
        if(item == head) {
            head = head.getRight();
            if(head != null) head.setLeft(null);
        }else if(item == tail) {
            tail = tail.getLeft();
            if(tail != null) tail.setRight(null);
        }else{
            item.getLeft().setRight(item.getRight());
            item.getRight().setLeft(item.getLeft());
        }
    }

    private void addToTail(CacheValueItem<K, V> item) {
        if(tail == null) {
            head = item;
            tail = item;
        }else{
            tail.setRight(item);
            item.setLeft(tail);
            item.setRight(null);
            tail = item;
        }
    }
}
