import java.util.Objects;

class MyHashMap<K, V> {

    // Node class for key-value pairs
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] buckets; // Array of linked list heads
    private int capacity = 16;   // Initial capacity
    private int size = 0;        // Number of key-value pairs

    // Constructor
    public MyHashMap() {
        buckets = new Node[capacity];
    }

    // Hash function
    private int getIndex(K key) {
        return Math.abs(Objects.hashCode(key)) % capacity;
    }

    // Put operation
    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node<K, V> current = buckets[index];
            Node<K, V> prev = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Update value if key exists
                    return;
                }
                prev = current;
                current = current.next;
            }

            prev.next = newNode; // Add new node at the end of the chain
        }
        size++;

        if ((1.0 * size) / capacity > 0.7) {
            resize();
        }
    }

    // Get operation
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null; // Key not found
    }

    // Remove operation
    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Resize the array
    private void resize() {
        capacity *= 2;
        Node<K, V>[] newBuckets = new Node[capacity];

        for (Node<K, V> head : buckets) {
            while (head != null) {
                int newIndex = getIndex(head.key);

                Node<K, V> next = head.next; // Save the next node
                head.next = newBuckets[newIndex];
                newBuckets[newIndex] = head; // Insert at new index
                head = next;
            }
        }

        buckets = newBuckets;
    }

    // Size of the HashMap
    public int size() {
        return size;
    }
}
