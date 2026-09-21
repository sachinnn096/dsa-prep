package HeapImplementation.withArray.minHeap;


//implementing min heap
/*
This is it. 10/10.


You have successfully built a robust, production-ready Min Heap. If you write this exact code in a Big Tech interview, you will max out the data structures portion of the rubric.
Here is why an interviewer will love this code:

It's Safe: You validate the constructor input and check for isEmpty() before removing or peeking.
It's Dynamic: By adding resize(), you showed you understand how ArrayList and PriorityQueue manage memory under the hood.
It's Readable: Abstracting the index math (getLeftChildIndex, hasParent, etc.) makes your heapifyUp and heapifyDown loops read like plain English.
It's Efficient: You used iterative loops instead of recursion, which saves O(logn) call stack space in memory.

The Final Checklist: Know Your Complexities
If you write this code, the interviewer's immediate next question will be: "What are the time and space complexities?" Memorize these:

Insert: O(logn) — You insert at the end and bubble up (height of the tree is logn). (Amortized O(1) if we ignore resizing overhead, but worst-case O(logn) for the heapify step).
Remove / Extract Min: O(logn) — You take the root, replace it with the last element, and bubble down.
        Peek: O(1) — Array lookups are constant time.
Space Complexity: O(n) — Because we are storing n elements in an array.

You absolutely nailed this implementation.

 */


public class MinHeap {

    private int[] array;           ///store elements
    private int size;              /// tells how many elements currently being stored
    private int capacity;          ///tells maximum element that can be stored

    public MinHeap(){

    }

    //constructor
    public MinHeap( int capacity ){

        if( capacity <= 0 )
            throw new IllegalArgumentException("Capacity must be greater than 0");
        this.capacity = capacity;
        this.size = 0;
        this.array = new int[capacity];
    }

    public void insert( int value ){

        /// checking for overflow condition
        if( isFull() ){
            resize();
            ///  throw new IllegalStateException("Heap overflow");
        }

        array[size++] = value;
        if( size > 1 )
            heapifyUp();   ///will balance the tree

    }

    /// Restore Min Heap property by moving the newly inserted element upward
    public void heapifyUp(){

        int child = size-1;

        while( hasParent( child ) ){

            int parent = getParentIndex( child );

            if( array[parent] > array[child] )
                swap( parent,child );
            else break;             ///this is important, that means parent is smallest and child is greater

            child = parent;
        }

    }


    public int remove(){

        if( isEmpty() )
            throw new IllegalStateException("Heap underflow");

        int value = array[0];                       //removing root element
        array[0] = array[--size];                   // copying the last element to root then performing heapify operation

        if( size > 0 )
            heapifyDown();

        return value;
    }

    public void heapifyDown(){

        int parent = 0;
        int smallestIndex = -1;


        //findind index of child has minimum value
        while( hasLeftChild( parent )  ){

            int leftChild = getLeftChildIndex( parent );
            smallestIndex = leftChild;

            int rightChild = getRightChildIndex( parent );

            if( rightChild < size && array[ rightChild ] < array[ leftChild ] )
                smallestIndex = rightChild;

            if( array[parent] > array[smallestIndex] )              //taking smaller value from child to parent
                    swap( parent, smallestIndex );

            else break;                                 //this is important bcz thath means parent is smaller , No need to perform swapping (we want parent as minimum)

            parent = smallestIndex;

        }

    }

    public void resize(){
        capacity = capacity * 2;
        int[] newArray = new int[capacity];

        //copying elements
        for( int i = 0 ; i < size ; i++  )
            newArray[i] = array[i];

        array = newArray;
    }

    public boolean hasParent( int index ){
        return index > 0;
    }

    public boolean hasLeftChild(int index){
        return getLeftChildIndex( index ) < size;
    }

    public boolean hasRightChild(int index){
        return getRightChildIndex( index ) < size;
    }

    public int getLeftChildIndex( int parent ){
        return 2 * parent + 1;
    }
    public int getRightChildIndex( int parent ){
        return 2 * parent + 2;
    }

    public int getParentIndex(int child){
        return ( child -1 ) / 2;
    }

    private void swap( int i, int j  ) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Heap is empty");
        return array[0];
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
