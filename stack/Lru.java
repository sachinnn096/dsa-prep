package stack;


class Lru {

    static class Node{

        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key,int value){
            this.key = key;
            this.value = value;


        }

    }

    // to access the value of key in constant time
    static Map<Integer,Node> map ;
    static int size;
    static int capacity;

    static Node head;
    static Node tail;






    LRUCache(int cap) {
        // code here
        this.capacity = cap;
        map = new HashMap<>();
        //pointers dummy nodes
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
        size = 0;


    }

    public static int get(int key) {
        //  code here

        if( !map.containsKey( key ) ) return -1;


        Node curr = map.get( key );
        moveToHead( curr );
        return curr.value;

    }


    public static void put(int key, int value) {
        //  code here

        if( !map.containsKey( key ) ){

            Node newNode = new Node( key, value );
            addNode( newNode );
            map.put( key,newNode );

            size++;

            if( size > capacity ){
                map.remove( tail.prev.key );
                deleteNode( tail.prev );
                size--;
            }
        }
        //key already present in the map
        else{

            Node current = map.get(key);
            current.value = value;
            moveToHead( current );

        }
    }

    public static void moveToHead( Node current ){

        deleteNode( current );
        addNode( current );

    }

    public static void deleteNode(Node current){

        Node prev = current.prev;
        Node next = current.next;

        prev.next = next;
        next.prev = prev;

    }

    public static void addNode(Node current){
        current.next = head.next;
        head.next.prev = current;
        current.prev = head;
        head.next = current;

    }
}
