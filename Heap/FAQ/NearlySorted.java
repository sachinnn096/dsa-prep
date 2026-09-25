package Heap.FAQ;


import java.util.PriorityQueue;

class NearlySorted {
    public void nearlySorted(int[] arr, int k) {
        // code here


        //idea - create a min heap
        // add all elements in to heap
        //remove one by one

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        int ind = 0;

        for( int i = 0 ; i < arr.length ; i++ ){

            //adding possible candidates into heap for answer index ind
            pq.add( arr[i] );

            if( i >= k ){
                arr[ind++] = pq.remove();
            }
        }

        while( !pq.isEmpty() ){
            arr[ind++] = pq.remove();
        }
        //time complexity = n*longn
        //space n
    }
}
