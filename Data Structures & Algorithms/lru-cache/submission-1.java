public class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) { 
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int cap;
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

    void insert(Node node) {
        Node before = this.tail.prev;
        node.prev = before;
        node.next = this.tail;
        before.next = node;
        this.tail.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node read = this.cache.get(key);
            remove(read);
            insert(read);
            return read.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            existingNode.val = value;
            remove(existingNode);
            insert(existingNode);
            return;
        }

        if (cache.size() == cap) {
            Node lruNode = this.head.next;
            remove(lruNode);
            cache.remove(lruNode.key);
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        cache.put(key, newNode);
    }
}
