package Heap.FAQ;



class MedianFinder {

    PriorityQueue<Integer> leftRoom;  //maxheap
    PriorityQueue<Integer> rightRoom; //minheap
    int size = 0;

    public MedianFinder() {
        leftRoom = new PriorityQueue<>(Collections.reverseOrder());
        rightRoom = new PriorityQueue<>();
    }

    public void addNum(int num) {
        size++;
        // 1. Conditional Insert: Put it exactly where it belongs
        if( leftRoom.isEmpty() ) leftRoom.offer( num );
        else if( rightRoom.isEmpty() ){

            if( num >= leftRoom.peek() )
                rightRoom.offer(num);
            else {
                rightRoom.add( leftRoom.poll() );
                leftRoom.add( num );
            }
        }

        else{
            if( num > rightRoom.peek()   ){
                rightRoom.offer( num );
            }else leftRoom.offer( num );

            if( leftRoom.size() > rightRoom.size() + 1  )
                rightRoom.offer( leftRoom.poll() );

            if( rightRoom.size() > leftRoom.size() )
                leftRoom.offer( rightRoom.poll() );

        }
    }

    public double findMedian() {
        if ( size % 2 != 0 ) {
            return leftRoom.peek();
        }
        return ((double)leftRoom.peek() + rightRoom.peek()) / 2.0;
    }
}