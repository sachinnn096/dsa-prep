package BST;

public class KthLargestFollowup {


    // only need to maintain the leftcounter only

    public static void main(String[] args) {

//        KthLargestFollowup obj = new KthLargestFollowup();
//
//
//        Node root = null;
//
//        int arr[] =  {9,4,12,6,5,7,2,19};
//
//        for( int i : arr ){
//            Box x = obj.insert( root, i);
//            root = x.node();
//        }
//        System.out.println();
//        System.out.println( obj.findkthlargest(root,3) );
//
//        obj.delete(root,6);
//        System.out.println( obj.findkthlargest(root,3) );
//
//        obj.inorder( root );

    }

    public void inorder(Node root){
        if( root == null ) return ;

        inorder(root.left);
        System.out.println(root.val+" "+root.leftC);
        inorder(root.right);

    }

    // node class
    class Node {
        int val;
        int leftC;
        Node left;
        Node right;

      // constructor
        public  Node(int val) {
            this.val = val;
            this.leftC = 0;
            this.left = null;
            this.right = null;
        }
    }

    // return type for the insert function

    public record Box(Node node, boolean inserted) {}


// insert function
//  insertion - key exits case handled

    public Box insert(Node root, int key) {
        //recursive insertion Code
        // base case
        if (root == null) {
            Node newNode = new Node(key);
            return new Box(newNode, true); // true represent node is inserted into bst

        } else if (root.val == key) {
            return new Box(root, false); // already present
        } else if (key > root.val) {

            Box box = insert(root.right, key);
            root.right = box.node();

            if (box.inserted()) return new Box(root, true);  // we have maintained only leftC

        } else {

            Box box = insert(root.left, key);
            root.left = box.node();

            if (box.inserted()) {  //  means node is inserted into its left subtree
                root.leftC++;
                return new Box(root, true);
            }
        }
        return new Box(root, false);
    }



//delete func - not exist case handled
    public Box delete(Node root, int key) {
        //base case
        if (root == null) {
            return new Box(null, false);
        }
        // found the value
        if (root.val == key) {

            Node temp = deleteHelper(root);
            return new Box(temp, true);

        }else if (key > root.val) {

            Box box = delete(root.right, key);
            root.right = box.node();

            if (box.inserted()) return new Box(root, true);

        } else {

           Box box = delete(root.left, key);
            root.left = box.node();

            if (box.inserted()) {  // mean node  is delted somewhere
                root.leftC--;
                return new Box(root, true);
            }
        }

        return new Box(root, false);
    }

    // delete function

    //delete helper
// delete node either can be leaf or middle [ one child or two child ]
    public Node deleteHelper(Node root) {

        // in case of leaf
        if (root.left == null && root.right == null) return null;
        // in case of one children

        if (root.left == null) return root.right;
        if (root.right == null) return  root.left;

        // logic for handling deletenode with 2 children
        Node temp = root.left;

        while (temp.right != null) temp = temp.right;  // finding pred

        temp.right = root.right;
        return root.left;
    }


    public int findKthSmallest( Node root,int k ){

        if( root == null ) return -1;   // not found

        if( root.leftC + 1 == k ) return root.val;

        if( k <= root.leftC )
            return findKthSmallest(root.left,k);
        else
            return findKthSmallest( root.right, k - root.leftC-1 );

    }

}







