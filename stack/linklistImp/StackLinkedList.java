package stack.linklistImp;

public class StackLinkedList<T> {

    //Node class
    private class Node {
        private T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
        //method to get data
        public T getData(){
            return this.data;
        }
    }
    //Node class completed


    private Node Head;

    public StackLinkedList(){
        Head = null;
    }

    //push
    public void push( T data ){
        Node newNode = new Node(data);

        //special case
//        if( Head == null ){
//            Head = newNode;
//            return;
//        }
        //random case
        newNode.next = Head;
        Head = newNode;
    }

    //pop

    public T pop(){
        if( Head == null )
            throw new RuntimeException("underflow:");

        T poppedValue = (T) Head.getData();
        Head = Head.next;
        return poppedValue;
    }
    //empty
    public boolean isEmpty(){
        return Head == null;
    }

    public T peek(){
        if( Head == null )
            throw new RuntimeException("underflow:");
        return (T)Head.getData();
    }

}
