package com.algomind.puzzle.lrucache;

/// Write the Least Re-Used Cache (LRU Cache) implementation
/// A LRU cache is a cache with fixed size. It works like a normal key/value cache until
/// the cache reaches its maximum capacity, at which point, the most least reused data item
/// should be removed to make room for any new item.
///
/// This implementation uses an extended version of LinkedHashMap.
/// This implementation is not thread-safe

class LRUCachePlus<K, V> {
    private BoundedLinkedHashMap<K, V> cache;

    LRUCachePlus(int capacity) {
        cache = new BoundedLinkedHashMap<>(capacity);
    }

    V get(K key) {
        if(cache.containsKey(key)) {
           V result = cache.get(key);
           cache.remove(key);
           cache.put(key, result);
           return result;
        }
        return null;
    }

    void put(K key, V value) {
        cache.remove(key);
        cache.put(key, value);
    }
}
