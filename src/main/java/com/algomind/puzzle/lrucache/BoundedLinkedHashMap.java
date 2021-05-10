package com.algomind.puzzle.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoundedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    BoundedLinkedHashMap(int capacity) {
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
