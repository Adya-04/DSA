class MyHashMap {

    private static class Pair {
        int key;
        int value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 769; // prime number to reduce collisions
    private LinkedList<Pair>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        for (Pair pair : buckets[index]) {
            if (pair.key == key) {
                pair.value = value;    // update value
                return;
            }
        }
        buckets[index].add(new Pair(key, value)); // insert new
    }

    public int get(int key) {
        int index = hash(key);
        for (Pair pair : buckets[index]) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1; // not found
    }

//  We use Iterator in remove() because Java does NOT allow removing elements from a LinkedList 
//  during a for-each loop — it causes ConcurrentModificationException.
    public void remove(int key) {
        int index = hash(key);
        Iterator<Pair> it = buckets[index].iterator();
        while (it.hasNext()) {
            Pair pair = it.next();
            if (pair.key == key) {
                it.remove();
                return;
            }
        }
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */