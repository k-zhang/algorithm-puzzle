package com.algomind.puzzle.lrucache;

class CacheValueItem<K, V> {
    private K key;
    private V value;
    private CacheValueItem<K, V> left;
    private CacheValueItem<K, V> right;

    CacheValueItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    void setValue(V value) {
        this.value = value;
    }

    CacheValueItem<K, V> getLeft() {
        return left;
    }

    void setLeft(CacheValueItem<K, V> left) {
        this.left = left;
    }

    CacheValueItem<K, V> getRight() {
        return right;
    }

    void setRight(CacheValueItem<K, V> right) {
        this.right = right;
    }
}
