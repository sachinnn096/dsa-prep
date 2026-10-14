package BinaryTree.questions;

public class FlattenBinaryTree {
}



/*


class Solution {
    public void flatten(TreeNode root) {

        if( root == null ) return ;

        TreeNode temp = root;

        while( temp != null ){

            TreeNode left = temp.left;
            TreeNode right = temp.right;

            if( left != null ){
                temp.right = left;
                while( left.right != null ) left = left.right;
                left.right = right;
                temp.left = null;
            }
            temp = temp.right;
        }


    }

    //STORING THE NODES INTO ARRAYLIST INTO PREORDER FORMAT
    public void dfs( TreeNode root, ArrayList<TreeNode> pre ){

        if( root == null ) return;

        pre.add( root );
        dfs( root.left, pre );
        dfs( root.right, pre );

    }
}

 */