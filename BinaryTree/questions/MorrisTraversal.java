package BinaryTree.questions;

public class MorrisTraversal {
}


//formula left root right

        /*
            Algorithm  - Morris traversal -> constant space complexity (1)

            curr = root initalization

            //steps

        run while loop untill current is not equal to null

            1. if curr has left
                    find predecessor [ left subtree main right most element / vo node jo sabse last main acess hoge inorder krte time ]

                    if pd.right == null [ which means hamara banaya hua cycle ni h yha[ first time visit horha h ] .... otherwise pd.right curr ko point krdeta ]

                        pd.right = curr;                        [forming cycle for returning ]
                        curr = curr.left [ move current to left ...why? bcz in inorder first left is traversed then root then right ....if left available go for left first ]

                    else [ which means pd.right == curr ]  [ which means you have gone throught the cycle and came back to the curr node( already visited node ) ]

                        visit curr
                        pd.right = null;   [ restoring linkedlist ]
                        curr = curr.right [ move current to right ]

            2.else [ curr does not have left child ( means left subtree done go for right as per formula Left root right ) ]
                visit curr
                curr = curr.right

        */


/*

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        //store answer
        List<Integer> list = new ArrayList<>();
        if( root == null ) return list;


        // code

        TreeNode curr = root;

        while( curr != null ){

            //left
            if( curr.left != null ){
                TreeNode pd = curr.left;

                //find predecessor [ which means right most element of left subtree ]
                // mistake 1 - && ke wajah maine || lga diya tha
                while( pd.right != null && pd.right != curr )  pd = pd.right;

                //visiting first time ....create cycle for come back
                if( pd.right  == null ){
                    pd.right = curr;
                    curr = curr.left;

                }else{     //which means pd.right = curr [ leftsubtree fully visited ]

                    list.add( curr.val );
                    curr = curr.right;
                    pd.right = null;
                }

            }
            else {  //which means curr does not have left child ...leftsubtree done , now we can visit this
                list.add( curr.val );
                curr = curr.right;
            }
        }

        return list;

    }
}

 */