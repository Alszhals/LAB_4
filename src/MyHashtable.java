public class MyHashtable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int size;
    private int capacity;
    private HashNode<K, V>[] chainArray;

    public MyHashtable() {
        size = 0;
        capacity = 11;
        chainArray = new HashNode[capacity];
    }

    public MyHashtable(int M) {
        capacity = M;
        size = 0;
        chainArray = new HashNode[capacity];
    }

    private int hash(K key) {
        return key.hashCode();
    }
    public void put(K key, V value) {
        int index = hash(key) % capacity;
        HashNode node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode newNode = new HashNode(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }
    public int getBucketIndex(int key){
    return key % chainArray.length;
    }
    public V get(K key){
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }  public V remove(K key){
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }
    public boolean contains(V value){
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
    public K getKey(V value){
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
    public K replace( K key,V oldvalue,V newvalue){
        K key1=getKey(oldvalue);
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        put(key1,newvalue);
        return null;
    }




}