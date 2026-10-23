class LRUCache {

     class ListNode {
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

     int capacity ;
     ListNode head = new ListNode(-1,-1);
     ListNode tail = new ListNode(-1,-1);
     HashMap <Integer,ListNode> hmap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void deleteNode(ListNode node){
        ListNode p = node.prev;
        ListNode n = node.next;

        p.next = n;
        n.prev = p;
    }

    public void addFront(ListNode node){

        ListNode n = head.next;

        head.next = node;
        node.prev = head;

        n.prev = node;
        node.next = n;


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
                node.val = value;
            deleteNode(node);
            addFront(node);
            
            return;
        }

        ListNode newNode = new ListNode(key,value);

        if(hmap.size()==capacity){
            ListNode node = tail.prev;
            hmap.remove(tail.prev.key);
            deleteNode(node);
        }

        hmap.put(key,newNode);
        addFront(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */