class LRUCache {
    class ListNode{
        int key;
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    HashMap<Integer,ListNode> hmap = new HashMap<>();
    ListNode head = new ListNode(-1,-1);
    ListNode tail = new ListNode(-1,-1);
    int capacity;
    public LRUCache(int capacity) {
        this.capacity =  capacity;
        head.next = tail;
        tail.prev = head;
    }

    public  void deleteNode(ListNode node){

        ListNode n = node.next;
        ListNode p = node.prev;

        p.next = n;
        n.prev = p;
    }

    public  void addFront(ListNode node){

        ListNode n = head.next;
        
        head.next = node;
        node.prev = head;

        node.next = n;
        n.prev = node;

    }
    
    public int get(int key) {
        
        if(hmap.containsKey(key)){
            ListNode node = hmap.get(key);
            deleteNode(node);
            addFront(node);

            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if(hmap.containsKey(key)){
            ListNode node = hmap.get(key);
            if(node.val!=value){
                node.val = value;
            }

            deleteNode(node);
            addFront(node);

            return;
        }


        if(hmap.size()==capacity){
            ListNode node = tail.prev;
            hmap.remove(node.key);
            deleteNode(node);
        }

        ListNode newNode = new ListNode(key,value);
        hmap.put(key,newNode);
        addFront(newNode);

        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */