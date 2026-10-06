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

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        //checking if no node or one node
        if( root == null || root.left == null && root.right == null ) return true;

        return DFS( root.left,root.right );


    }

    public boolean DFS( TreeNode p1,TreeNode p2 ){

        //base case
        if( p1 == null || p2 == null ){
            if( p1 != p2 ) return false;
            return true;  //means both are null
        }
        //  another base case  --> execution will come here only if both pointers are not null
        if( p1.val != p2.val ) return false;

        // now perform dfs
        boolean left = DFS( p1.left, p2.right );
        boolean right = DFS( p1.right, p2.left );

        if( !left || !right ) return false;
        return true;

    }
}

 */