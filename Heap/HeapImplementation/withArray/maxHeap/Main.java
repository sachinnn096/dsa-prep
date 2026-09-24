package Heap.HeapImplementation.withArray.maxHeap;

class Main{
    public static void main(String[] args) {

        Heap maxHeap = new Heap(10);

        maxHeap.insert( 7 );
        maxHeap.insert( 17 );
        maxHeap.insert( 2 );
        maxHeap.insert( 255 );
        maxHeap.insert( 765 );
        maxHeap.insert( 24 );
        maxHeap.insert( 653 );
        maxHeap.insert( 266 );

        System.out.println( maxHeap.remove() );
        System.out.println( maxHeap.remove() );
        System.out.println( maxHeap.remove() );
        System.out.println( maxHeap.remove() );
        maxHeap.insert(1154536);
        System.out.println( maxHeap.remove() );





    }
}
