package Heap.FAQ;



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        if( lists == null || lists.length == 0 ) return null;
        if( lists.length == 1 ) return lists[0];


        ListNode dummyHead = new ListNode( -1 );
        ListNode curr = dummyHead;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>( (a,b)->Integer.compare( a.val,b.val ) );

        //adding the head pointer of all the sorted list into heap
        for( ListNode node : lists ) {
            if(  node != null )
                minHeap.offer( node );
        }

        //making a single list using dummyHead pointer
        while( !minHeap.isEmpty() ){

            ListNode minNode = minHeap.poll();

            curr.next = minNode;
            curr = curr.next;

            minNode = minNode.next;
            if( minNode != null ) minHeap.offer( minNode );
        }

        return dummyHead.next;

    }
}


 */