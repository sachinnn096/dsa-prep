package BST;

public class DeleteANode {
}

/*
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if( root == null ) return null;

        if( key > root.val ){  // node mere right main h jakr delete krdo but chain kharb mt krna
            root.right = deleteNode( root.right,key );
        }else if( key < root.val ){
            root.left = deleteNode( root.left,key );
        }else{  // delete node found

            if( root.left == null ) return root.right;
            else if( root.right == null ) return root.left;
            else {  // case h left & right children dono present h

                // find left subtree prede
                // copy predecessor.val into delete node
                // delete the predecessor

                TreeNode inPredecessor = findLeftPredecessor( root.left );
                // copying the predcessor value into deletenode [ bst property maintained ]
                root.val = inPredecessor.val;
                // uske left se delete hona h toh result to accept krega na
                root.left = deleteNode( root.left, root.val );
            }
        }
        return root;
    }

    // find predecessor means value which is maximum for current subtree
    // it will be found as right as possible
    public TreeNode findLeftPredecessor( TreeNode root ){

        while( root.right != null ){
            root = root.right;
        }
        return root;
    }

}


 */