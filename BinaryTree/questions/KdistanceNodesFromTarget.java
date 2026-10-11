package BinaryTree.questions;

public class KdistanceNodesFromTarget {
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();
        if( root == null ) return res;

        backtrack( root, res, k, target );
        return res;


    }

    public int backtrack( TreeNode root, List<Integer> res, int k, TreeNode target ){
        //base case
        if( root == null ) return -1;   //not found
        if( root == target ){
            // exploring whole tree as target as root node [ leftSubtree + rightSubtree  ] remaining - > upper tree only
            exploreDownward( root, 0, k , res );
            return k == 0 ? -1 : 1;  //giving back to parent ... bcz it is at one unit from target      // -1 means stop propogating
            // special case k == 0 means only add target, if you return 1 then it enforce to find any subtree left/right again because left or right != -1
            // to handle this return -1 // for parent assume no target was found ... now we stop unncessary travesal

        }

        // searching for the target node
        int leftDist  = backtrack( root.left, res, k, target );
        int rightDist = backtrack( root.right, res, k, target );


        if( leftDist != -1 ){   // target found in left side
            if( leftDist == k ){  // curr node is k distance from target
                res.add( root.val );
                return -1;
            }else{
                exploreDownward( root.right, leftDist + 1, k, res ); // leftdist < k means you can find in rightsubtree
                return leftDist+1;
            }
        }

        if( rightDist != -1 ){
            if( rightDist == k ){   // target is found in rightSubtree
                res.add( root.val );
                return -1;  // because now distance of upward nodes will be > k , so we can't find ans ....that's why we stop propogating upward
            }else{
                exploreDownward( root.left, rightDist+1, k, res );  // rightDist < k , you have space to find in leftside
                return rightDist+1;
            }

        }

        return -1;   //means target is neither found in left or right subtree

    }


    public void exploreDownward( TreeNode root,int dis,int k, List<Integer> res ){

        if( root == null ) return;
        if( dis == k ){
            res.add( root.val );
            return;
        }

        exploreDownward( root.left, dis + 1, k, res );
        exploreDownward( root.right, dis + 1, k, res );

    }
}


 */