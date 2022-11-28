public class HashMap<K,V>{
    private int capacity;
    private float loadFactor;
    int occupiedBaskets;

    private Node[] table;


    public HashMap() {
        this.capacity = 16;
        this.loadFactor = 0.75F;
        this.table = new Node[capacity];
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.loadFactor = 0.75F;
        this.table = new Node[capacity];
    }

    public HashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new Node[capacity];
    }

    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    public boolean containsValue(V value) {
        boolean isEqual = false;

        for (Node node : table) {
            if (node.getValue().equals(value)) {
                isEqual = true;

            } else {
                Node<K,V> next = node.getNext();
                while (next != null) {
                        isEqual = node.getNext().getValue().equals(value);
                        next = next.getNext();
                }
            }
        }
        return isEqual;
    }

    public void put(K key, V value) {
        expansion();

        Node prevNode;
        Node<K,V> newNode = new Node<>(key, value);
        int index = indexFor(key);
        if (table[index] == null) {
            table[index] = newNode;
            occupiedBaskets++;
        }
        else {
            prevNode = table[index];
            table[index] = newNode;
            newNode.setNext(prevNode);
        }
    }

    private int indexFor(K key) {
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    public void expansion() {
        if (occupiedBaskets == capacity * loadFactor) {
            HashMap<Object, Object> newMap = new HashMap<>(capacity * 2, loadFactor);
            Node[] oldTable = table;
            for (Node node : oldTable) {
                if (node != null)
                    newMap.put(node.getKey(), node.getValue());
            }
            this.capacity = newMap.getCapacity();
            this.loadFactor = loadFactor;
            this.occupiedBaskets = newMap.getOccupiedBaskets();
            this.table = newMap.getTable();
        }
    }

//    public void reduction();

    public void remove(K key) {
        int index = indexFor(key);
        Node<K,V> delete = getNode(key);
        Node prevNode = table[index];

        if (delete.getNext() != null) {
            table[index] = delete.getNext();
        }
        else {
            if (prevNode.getKey() != delete.getKey()) {
                while (!prevNode.getNext().getKey().equals(key)) {
                    prevNode = prevNode.getNext();
                }
                prevNode.setNext(null);
            } else {
                table[index] = null;
                occupiedBaskets--;
            }
        }
    }

    public V get(K key) {
        return getNode(key).getValue();
    }

    public Node<K,V> getNode(K key) {
        int index = indexFor(key);
        Node<K,V> search = table[index];
        while (search.getKey().hashCode() != key.hashCode()) {
            search = search.getNext();
        }
        if (!key.equals(search.getKey()))
            throw new IndexOutOfBoundsException("Элемент не найден");

        return search;
    }

    public void next() {
        for (Node node : table) {
            System.out.println(node);
        }
    }

    private int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private float getLoadFactor() {
        return loadFactor;
    }

    private void setLoadFactor(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    private Node[] getTable() {
        return table;
    }

    private void setTable(Node[] table) {
        this.table = table;
    }

    private int getOccupiedBaskets() {
        return occupiedBaskets;
    }

    private void setOccupiedBaskets(int occupiedBaskets) {
        this.occupiedBaskets = occupiedBaskets;
    }
}
