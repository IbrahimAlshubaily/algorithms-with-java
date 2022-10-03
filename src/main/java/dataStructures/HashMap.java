package dataStructures;

public class HashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 32;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private int length;
    private int capacity;
    private final double loadFactor;
    private HashMapNode<K,V>[] data;


    public HashMap(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity){
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(Double loadFactor){
        this(DEFAULT_CAPACITY, loadFactor);
    }

    public HashMap(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        data = new HashMapNode[capacity];
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }


    public boolean containsKey(K key) {
        HashMapNode<K, V> node = getNode(key);
        return node != null;
    }

    public boolean containsValue(V value) {

        for (int i = 0; i < capacity; i++) {
            if (data[i] == null)
                continue;

            if (data[i].containsValue(value))
                return true;
        }
        return false;
    }


    public V get(K key) {
        HashMapNode<K, V> node = getNode(key);
        if (node != null)
            return node.value;
        return null;
    }

    public V put(K key, V value) {
        HashMapNode<K, V> node = getNode(key);
        if (node != null) {
            V out = node.value;
            node.value = value;
            return out;
        }
        length++;
        int idx = getIndex(key);
        if (data[idx] == null)
            data[idx] = new HashMapNode<>(key, value);
        else
            data[idx].insert(key, value);
        return null;
    }

    public V remove(K key) {
        int idx = getIndex(key);
        if (data[idx] == null)
            return null;

        length--;
        if (data[idx].key.equals(key)) {
            V out = data[idx].value;
            data[idx] = data[idx].next;
            return out;
        }
        return data[idx].remove(key);
    }

    private int getIndex(K key) {
        return key.hashCode() & (capacity - 1);
    }
    private HashMapNode<K, V> getNode(K key) {
        int idx = getIndex(key);
        if (data[idx] == null)
            return null;
        return data[idx].getNode(key);
    }
}

class HashMapNode<K,V> {
    final K key;
    V value;
    HashMapNode<K,V> next;
    HashMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    HashMapNode<K, V> getNode(K key) {
        if (this.key.equals(key))
            return this;

        if (this.next != null)
            return this.next.getNode(key);

        return null;
    }

    boolean containsValue(V value) {
        if (this.value.equals(value))
            return true;

        if (this.next != null)
            return this.next.containsValue(value);

        return false;
    }

    void insert(K key, V value) {
        HashMapNode<K,V> curr = this;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new HashMapNode<>(key, value);
    }

    V remove(K key) {
        if (this.next == null)
            return null;

        if (this.next.key.equals(key)) {
            this.next = this.next.next;
            return this.next.value;
        }

        return this.next.remove(key);
    }

}
