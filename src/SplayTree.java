public class SplayTree{
    private Node root;

    private Node nullNode;

    public SplayTree() {
//        root.setLeft(null);
//        root.setRight(null);

    }

//    different than book's code for now

    private Node newNode;  // Used between different inserts

    public Node insert(String toInsert){
        return insert(new Node(toInsert));
    }




    private Node insert(Node x) {
        if( newNode == null )
//            newNode = new Node( null );
        newNode = x;

        if( root == nullNode ) {
//            newNode.left = newNode.right = nullNode;
            root = newNode;
        }
        else
        {
            root = splay( x, root );

            int compareResult = x.compareTo( root );

            if( compareResult < 0 )
            {
                newNode.setLeft(root.getLeft());
                newNode.setRight(root);
                root.setLeft(nullNode);
                root = newNode;
            }
            else
            if( compareResult > 0 )
            {
                newNode.setRight(root.getRight());
                newNode.setLeft(root);
                root.setRight(nullNode);
                root = newNode;
            }
//            else
//                return;   // No duplicates
        }
        newNode = null;   // So next insert will call new
        //            not sure if this should return null or some other node. thank you next!
        return null;
    }




//    private Node header = new Node( null ); // For splay
    private Node header;

    private Node splay( Node x, Node t ) {
        Node leftTreeMax, rightTreeMin;

//        header.left = header.right = nullNode;
        header.setLeft(nullNode);
        header.setRight(nullNode);



        leftTreeMax = rightTreeMin = header;

        nullNode.setElement(x.getData());   // Guarantee a match

        for( ; ; )
        {
            int compareResult = x.compareTo( t );

            if( compareResult < 0 )
            {
                if( x.getData().compareTo( t.getLeft().getData() ) < 0 )
                    t = rotateWithLeftChild( t );
                if( t.getLeft() == nullNode )
                    break;
                // Link Right
                rightTreeMin.setLeft(t);
                rightTreeMin = t;
                t = t.getLeft();
            }
            else if( compareResult > 0 )
            {
                if( x.getData().compareTo( t.getRight().getData() ) > 0 )
                    t = rotateWithRightChild( t );
                if( t.getRight() == nullNode )
                    break;
                // Link Left
                leftTreeMax.setRight(t);
                leftTreeMax = t;
                t = t.getRight();
            }
            else
                break;
        }

        leftTreeMax.setRight(t.getLeft());
        rightTreeMin.setLeft(t.getRight());
        t.setLeft(header.getRight());
        t.setRight(header.getLeft());
        return t;
    }






    private  Node rotateWithLeftChild( Node k2 ) {
        Node k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     */
    private  Node rotateWithRightChild( Node k1 ) {
        Node k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        return k2;
    }
















    public static void main(String[] args){
        SplayTree splay = new SplayTree();
        splay.insert("C");
        splay.insert("B");
        splay.insert("A");
//        splay.insert("co");
//        splay.insert("ji");
    }

}
