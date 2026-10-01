package Heap.FAQ;

import java.util.Collections;
import java.util.PriorityQueue;


class MedianFinder {

    PriorityQueue<Integer> left;  //maxheap
    PriorityQueue<Integer> right; //minheap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // 1. Conditional Insert: Put it exactly where it belongs

        if( left.isEmpty() || left.peek() > num )
            left.offer( num );
        else
            right.offer( num );

        //balancing the both halves
        if( right.size() > left.size() ){
            left.offer( right.peek() );
            right.poll();

        }else if( left.size() > right.size() + 1 ){
            right.offer( left.peek() );
            left.poll();
        }



    }

    public double findMedian() {
        if ( left.size() != right.size() ) {
            return left.peek();
        }
        return ((double)left.peek() + right.peek()) / 2.0;
    }
    class MedianFinder {

        PriorityQueue<Integer> left;  //maxheap
        PriorityQueue<Integer> right; //minheap

        public MedianFinder() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {

            // 1. Conditional Insert: Put it exactly where it belongs

            if( left.isEmpty() || left.peek() > num )
                left.offer( num );
            else
                right.offer( num );

            //balancing the both halves
            if( right.size() > left.size() ){
                left.offer( right.peek() );
                right.poll();

            }else if( left.size() > right.size() + 1 ){
                right.offer( left.peek() );
                left.poll();
            }



        }

        public double findMedian() {
            if ( left.size() != right.size() ) {
                return left.peek();
            }
            return ((double)left.peek() + right.peek()) / 2.0;
        }
    }