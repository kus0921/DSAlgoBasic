package DatastructureBasedQuestions;

import java.util.LinkedList;

public class MyMap<K, V> {
    public static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    MyMap(int capacity) {
        buckets = new LinkedList[capacity];
    }

    MyMap() {
        this(INITIAL_CAPACITY);
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }
        }
        buckets[index] = new LinkedList<>();
        buckets[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }

        }
        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> entry.key.equals(key));
        }

    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyMap<Integer, String> myMap = new MyMap<>();
        for (int i = 0; i < 16; i++)
            myMap.put(i, i + "M");
        myMap.remove(3);
        for (int i = 0; i < 16; i++) {
            System.out.println(myMap.get(i));
        }
    }
}