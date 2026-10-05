package BinaryTree.questions;



//for every node find left subtree depth and right subtree depth

/*
class DiameterOfBinaryTree {

    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {

        //base case
        if( root == null ) return 0;
        diameter = 0;

        findDepth( root );
        return diameter;

    }
//depth first search


    private int findDepth( TreeNode root ){

        //base case
        if( root == null ) return 0;

        int left = findDepth( root.left );
        int right = findDepth( root.right );

        diameter = Math.max( left+right , diameter );

        return Math.max( left,right ) + 1;

    }
}


 */