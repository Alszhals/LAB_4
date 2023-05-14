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

}