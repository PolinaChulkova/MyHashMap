public class Node<K,V> {
//    private int hashCode;
    private Node<K,V> next;
    private K key;
    private V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

//    public int getHashCode() {
//        return hashCode;
//    }
//
//    public void setHashCode(int hashCode) {
//        this.hashCode = hashCode;
//    }

    @Override
    public String toString() {
        return "Node{" +
                ", next=" + next +
                ", key=" + key +
                ", value=" + value +
                '}';
    }
}