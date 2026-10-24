public class RecoverBST {
}


/**
        obervation 1 2 3 4 5 6 7
    swap adjacent vaues
                    1 2 4 3 5 6 7
                now you only pair where prev .val > curr.val
                swap both and you are done

    if value swapped are not adjacent
                 1 2 3 4 5 6 7 8
                 1 7 3 4 5 6 2 8
                first pair [ 7,3 ]  second pair[ 6 , 2 ]
    here swap first[0]  with the second[1]
        so you got the approach

    // hint - use morris traversal


/*
class Solution {
    public void recoverTree(TreeNode root) {
        // store the unorder pair
        TreeNode[] pair = { null, null };

        TreeNode prev = null;
        TreeNode curr = root;

        // applying morris traversal
        while( curr != null ){

            // if have left child
            if( curr.left != null ){
                // finding predecessor of curr
                TreeNode pd = findPredecessor( curr );

                // case if predecessor points to null -> no loop [First time visit ]
                if( pd.right == null ){
                    pd.right = curr;  // connecting for later comeback traversal
                    curr = curr.left;  // moving current pointer to left subtree

                }else{
                    validateAdacentPair( prev, curr, pair);
                    pd.right = null;         // removing the loop
                    prev = curr; // storing this nodes as previous for next ndoe
                    curr = curr.right;  // moving to next node
                }

            }else{  // mean left subtree does not exits

                // previous will not exits only in case of Inorder first node[ smallest value ]
                if( prev != null ){
                    validateAdacentPair( prev, curr, pair );
                }
                prev = curr;   // updating this as prev for next inorder sequence
                curr = curr.right;  // moving to next
            }

        }

        //swapping values
        int temp = pair[0].val;
        pair[0].val = pair[1].val;
        pair[1].val = temp;



    }

    public TreeNode findPredecessor( TreeNode root ){
        TreeNode pred = root.left;

        while(  pred.right != null && pred.right != root) pred = pred.right;

        return pred;
    }
    public void validateAdacentPair(TreeNode prev, TreeNode curr, TreeNode[] pointers ){

        if( prev.val > curr.val ){

            pointers[1] = curr;
            if( pointers[0] == null ) pointers[0] = prev;
        }

    }
}


 */