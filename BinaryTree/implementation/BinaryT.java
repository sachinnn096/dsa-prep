package BinaryTree.implementation;

//understand the prerequisite first
// a b c d e f g - > given preorder traversal

// we can not make a single binary tree from this preOrder because we don't know at which node the left subtree is going to end
// give it a try to make a unique binary tree  -> answer no

// a b -1 -1 c = preOrder travesal  -1 represent the the node of child is null
// now give it a try to make a unique binary tree - answer yes

public class BinaryT {

    //node class structure
    class Node{
        int data;
        Node left;
        Node right;

        public Node( int data ){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    int ind = 0;
//    Node root;

    // assume you have this array [a b -1 -1 c ]       build a tree using ind pointer
    public Node buildTree( int[] arr ){

        //base case
        if( ind >= arr.length ) return null;
        // found a dead end
        if( arr[ind] == -1 ){
            ind++;
            return null;
        }

        Node root = new Node( arr[ind++] );

        root.left = buildTree( arr );
        root.right = buildTree( arr );
        return root;     // assume you have only one element then this root will be returned
    }

    public void preOrderTraversal( Node root ){

        if( root == null ) return ;

        System.out.print(root.data+" ");
        preOrderTraversal( root.left );
        preOrderTraversal( root.right );

    }

    public static void main(String[] args) {
        int[] preorder = { 1,2,-1,-1,3,4,-1,-1,5 };

        BinaryT b1 = new BinaryT();

        Node root = b1.buildTree(preorder);
        b1.preOrderTraversal(root);

    }
}


