package BinaryTree.questions;




// top down approach

/*

class public class ChildrenSumProperty {
    {
    public boolean isSumProperty(Node root) {
        //  code here
        if( root == null ) return true;

        return dfs( root );

    }

    //top down approach  - visiting every node
    public boolean dfs( Node root ){

        if( root == null || isLeaf( root ) ) return true;
        // internal node - check for valid children sum property
        if( !isValid( root ) ) return false;

        return dfs( root.left ) && dfs( root.right );

    }

    private boolean isValid( Node root ){
        int sum = 0;

        if( root.left != null )
            sum += root.left.data;
        if( root.right != null )
            sum += root.right.data;

        return sum == root.data;
    }


    public boolean isLeaf( Node root ){

        // leaf does not have any children
        return root.left == null && root.right == null;
    }
}

 */



//bottom up approach

/*
/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */


//bottom up approach
/*

class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if( root == null ) return true;

        return dfs( root ) != -1;

    }

    //top down approach  - visiting every node
    public int dfs( Node root ){
        //base cases
        if( root == null ) return 0;
        if( isLeaf( root ) ) return root.data;


        // internal node - check for valid children sum property
        int left = dfs( root.left );
        int right = dfs( root.right );

        if( left == -1 || right == -1 ) return -1;
        //checking is satisying property
        if( left+right != root.data ) return -1;

        return root.data;

    }




    public boolean isLeaf( Node root ){

        // leaf does not have any children
        return root.left == null && root.right == null;
    }
}
 */