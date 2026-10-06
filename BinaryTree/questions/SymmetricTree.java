package BinaryTree.questions;


/**
 //thought process
 in order to see weather the tree is mirror or not if itself along the center
 we need to move in opossite direction
 that's the only way ...which confirm that tree will overlap along the center

 so
 we will perform dfs &
 if p1 -> is going left
 then make p2 -> going right
 if p1 -> is going right
 then make p2 going left;


 */

/*
/**
        //thought process
         in order to see weather the tree is mirror or not if itself along the center
         we need to move in opossite direction
            that's the only way ...which confirm that tree will overlap along the center

            so
            we will perform dfs &
                if p1 -> is going left
                    then make p2 -> going right
                if p1 -> is going right
                    then make p2 going left;


 /*

class Solution {
    public boolean isSymmetric(TreeNode root) {
        //checking if no node or one node
        if( root == null ) return true;

        return isMirror( root.left,root.right );


    }

    public boolean isMirror( TreeNode p1,TreeNode p2 ){

        //base case
        if( p1 == null || p2 == null ) return p1 == p2;

        if( p1.val != p2.val ) return false;                    //case  --> execution will come here only if both pointers are not null

        return isMirror( p1.left, p2.right ) && isMirror( p1.right, p2.left );      // // if any subtree returns false, we should return false;

    }
}



*/