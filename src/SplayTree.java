public class SplayTree extends BST{
    private Node root;

    private Node nullNode;

    public SplayTree() {

    }

    private Node newNode = null;  // Used between different inserts

    public Node insert(String toInsert){
        return root = insert(new Node(toInsert));
    }




    private Node insert(Node x) {
        if( newNode == null ) {
//            newNode = new Node( null );
        }
        newNode = x;

        if( root == nullNode ) {
//        if( root == null ) {
//            newNode.left = newNode.right = nullNode;
            root = newNode;
        }
        else {
            root = splay( x, root );

            int compareResult = x.compareTo( root );

            if( compareResult < 0 ) {
                newNode.setLeft(root.getLeft());
                newNode.setRight(root);
                root.setLeft(nullNode);
                root = newNode;
            }
            else
            if( compareResult > 0 ) {
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
        return x;
    }




//    private Node header = new Node( null ); // For splay
    private Node header;

    private Node splay( Node x, Node t ) {
        if (header != null) {
            if (header.getLeft() != null){
                header.setLeft(null);
            }
            if (header.getRight() != null) {
                header.setRight(null);
            }
        }

        Node leftTreeMax;
        Node rightTreeMin;

//        header.left = header.right = nullNode;
//        header.setLeft(nullNode);
//        header.setRight(nullNode);

        leftTreeMax = rightTreeMin = header;

//        NullPointer because object element it null but data is trying to be set which is
//        nullNode.setElement(x.getData());   // Guarantee a match

        nullNode = new Node(x.getData());

        for( ; ; )
        {
            int compareResult = x.compareTo( t );

            if( compareResult < 0 )
            {
//
                if (t.getLeft() != null) {
                    if (x.getData().compareTo(t.getLeft().getData()) < 0) {
                        t = rotateWithLeftChild(t);
                    }
                }

                if( t.getLeft() == nullNode || t.getLeft() == null )
                    break;

                // Link Right
//


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
        if (k1 == null){
            return k1;
        }
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
        if (k2 == null){
            return k2;
        }
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        return k2;
    }


    public Node find(String toFind){
        return super.find(toFind);
    }












    public static void main(String[] args){
        SplayTree splay = new SplayTree();
        splay.insert("C");
        splay.insert("B");
        splay.insert("A");

        System.out.println(splay.find("C"));
        System.out.println(splay.find("B"));
        System.out.println(splay.find("A"));

    }

}
