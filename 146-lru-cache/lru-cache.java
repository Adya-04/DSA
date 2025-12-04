class LRUCache {

    class Node{
        private int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head, tail;
    private int capacity;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        
        head.next = tail;
        tail.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //insert at front (right after head → Most Recently Used)
    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        // move to front (because accessed → MRU)
        removeNode(node);
        insertAtFront(node);

        return node.val;
    }

    public void put(int key, int value) {
        // Key already exists → update + move to front
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;

            removeNode(node);
            insertAtFront(node);
            return;
        }

        // If at full capacity → remove LRU (node before tail)
        if (map.size() == capacity) {
            Node lru = tail.prev;
            map.remove(lru.key);
            removeNode(lru);
        }

        // Insert new key
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAtFront(newNode);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */