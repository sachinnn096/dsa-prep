package HeapImplementation.withArray;

//Max Heap implementation with array



public class Heap {

    //variables
    private int[] array;
    private int capacity;
    private int lastIndex;

    //constructor for initializing the heap
    public Heap( int capacity ){
        this.capacity = capacity;
        this.array = new int[capacity];
        this.lastIndex = -1;
    }


    //
    public int remove(){

        //checking for underflow
        if( lastIndex == -1 )
            throw new IllegalStateException("Heap underflow");

        int value = array[0];                        //extracting the root value
        array[0] = array[lastIndex--];                    //copying the last element to first

        //balance tree downward
        heapifyDownWard();
        return value;
    }

    public void heapifyDownWard(){

        int parent = 0;

        int leftChild = 2 * parent + 1;
        int rightChild = 2 * parent + 2;
        int largestIndex = -1;

        while( leftChild <= lastIndex  ){

            largestIndex = leftChild;     //updating the largest element index

            if( rightChild <= lastIndex && array[rightChild] > array[leftChild] )
                largestIndex = rightChild;

            //only swap in case of child is greater than parent...                  to maintain maxHeap
            if( array[largestIndex] > array[parent] )
                swap( parent,largestIndex );
            else break;

            //updating pointers
            parent = largestIndex;
            leftChild = parent * 2 + 1;
            rightChild = parent * 2 + 2;

        }
    }



    //always add the value to very bottom and as left as possible
    public void insert( int value ){

        //checking for full condition
        if( isFull() )
            throw new IllegalStateException("Heap overflow");

        array[++lastIndex] = value;
        if( lastIndex>0 )
            heapifyUpWard();
    }

    //balance the tree takes                      logN time complexity
    public void heapifyUpWard(){

        int child = lastIndex;
        int parent = (lastIndex-1)/2;

        //balancing the tree from downward to upward
        while( parent >= 0 && array[parent] < array[child] )
        {
            swap( parent, child );
            child = parent;
            parent = ( child - 1 ) / 2;
        }
    }




    //swapping logic of parent and chid when max heap property breaks( parent must be greater or equal to child )
    private void swap( int parent, int child ) {
        int temp = array[parent];
        array[parent] = array[child];
        array[child] = temp;
    }


    //Helper methods
    public boolean isEmpty(){
        return lastIndex == -1;
    }
    public boolean isFull(){
        return capacity-1 == lastIndex;
    }
}




