package BinaryTree.questions;

public class ConstructBinaryTreeFromPreIn {
}


/*
class Solution {

    private int rootIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        // special case
        if( preorder == null || inorder == null || preorder.length != inorder.length ) return null;

        int[] rootIndex = {0};

        Map<Integer,Integer> map = new HashMap<>();  //store the index , value or inorder elements

        for( int i = 0 ; i < inorder.length ; i++ ){
            map.put( inorder[i],i );
        }

        return buildTree( preorder, 0, inorder.length - 1, map,rootIndex );

    }


    public TreeNode buildTree( int[] preorder, int inStart, int inEnd,Map<Integer,Integer> map, int[] rootIndex ){

        // create a root node
        // find range of inorder elements that belongs to left subtree of root
        // find the range of inorder elements belongs to right subtree of root

        //base case
        if( inStart > inEnd ) return null;

        int rootVal = preorder[ rootIndex[0]++ ];
        TreeNode root = new TreeNode( rootVal );  // creating root node for subtree

        int mid = map.get( rootVal );  // segregating leftSubtree & right subtree

        //left
        root.left = buildTree( preorder, inStart,mid-1,map,rootIndex );
        //right
        root.right = buildTree( preorder, mid+1, inEnd, map, rootIndex );
        return root;

    }
}


 */