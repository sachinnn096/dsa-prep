package Heap.FAQ;
//  hint sort both arrays
// create a matrix add the cell 0 0
// figure which cell can be next minimum sum combinaton

import java.util.*;

class MinSumCombination {

    class Triplet{
        int sum;
        int i;
        int j;
        public Triplet( int sum, int i ,int j ){
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {



        return findKPairs( nums1, nums2, k );

    }

    private List<List<Integer>> findKPairs( int[] nums1, int[] nums2, int k ){

        int n1 = nums1.length;
        int n2 = nums2.length;

        //store pairs
        List<List<Integer>> res = new ArrayList<>();
        //min heap on basis of sum
        PriorityQueue<Triplet> pq = new PriorityQueue<>( (a,b)->Integer.compare( a.sum,b.sum ) );
        // keep track of which cell is visited index (row) -> HashSet
        Map<Integer,Set<Integer>> visited = new HashMap<>();

        for( int i = 0 ; i < nums1.length ; i++ ){
            visited.put( i,new HashSet<>() );
        }

        //adding (0,0) cell
        pq.offer( new Triplet( nums1[0]+nums2[0], 0, 0 ) );

        visited.get(0).add(0);   //marking the globally know minsumpair visited

        while( k > 0 ){
            //fetching minimum sum pair
            int sum = pq.peek().sum;
            int i = pq.peek().i;
            int j = pq.peek().j;

            res.add( Arrays.asList( nums1[i],nums2[j] ) );   //adding pair to result
            //removing the top most element
            pq.poll();
            k--;

            //looking for next smaller pairs

            if( i+1 < n1 && !visited.get(i+1).contains(j) ){
                //adding to heap
                pq.offer( new Triplet( nums1[i+1]+nums2[j], i+1 , j ) );
                //marking as visited
                visited.get(i+1).add(j);
            }

            if( j+1 < n2 && !visited.get(i).contains(j+1) ){
                //adding to heap
                pq.offer( new Triplet( nums1[i]+nums2[j+1], i , j+1 ) );
                //marking as visited
                visited.get(i).add(j+1);
            }

        }
        return res;
    }
}