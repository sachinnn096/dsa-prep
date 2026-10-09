package BinaryTree.questions;

public class LCA {
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
    private boolean first = false;
    private boolean second = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if( root == null ) return null;
        first = false;
        second = false;

        TreeNode ans = findPaths( root, p, q );
        if( ans != null && first && second )
            return ans;
        return null;
    }

    public TreeNode findPaths( TreeNode root, TreeNode p,TreeNode q){
        //base case
        if( root == null ) return null;



        TreeNode left = findPaths( root.left, p, q );
        TreeNode right = findPaths( root.right, p ,q );

        //case 1
        if( root == p ) first = true;  //found first
        if( root == q ) second = true;

        if( root == p || root == q ) return root;

        if( left != null && right != null ){
            return root;
        }

        if( left != null ){
            return left;
        }
        if( right != null ) {
            return right;
        }
        return null;
    }
}

 */