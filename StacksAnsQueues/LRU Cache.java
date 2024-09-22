class LRUCache {
    class Node{
        int key,val;
        Node prev,next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node head = new Node(0,0), tail = new Node(0,0);
    HashMap<Integer,Node> map = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }
    private void remove(Node node){
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private void insert(Node node){
        map.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        else{
            return -1;
        }


    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));


    }
}