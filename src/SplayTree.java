public class SplayTree extends BST{
//    private Node root;

    private Node root;
    private Node nullNode;

    public SplayTree(){

    }


    public void insertSplay(String toInsert){
        insertSplay(new Node(toInsert));
    }


    private Node newNode = null;  // Used between different inserts



    /**
     * Insert into the tree.
     * @param x the item to insert.
     */
    public void insertSplay( Node x )
    {
        if( newNode == null ) {
//            newNode = new BinaryNode<AnyType>( null );
            newNode = null;
        }
//        newNode.element = x;
        newNode = x;

        if( root == nullNode )
        {
            newNode.setLeft(nullNode);
            newNode.setRight(nullNode);
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
            else
                return;   // No duplicates
        }
        newNode = null;   // So next insert will call new
    }

//    private BinaryNode<AnyType> header = new BinaryNode<AnyType>( null ); // For splay

    private Node header = null;


    /**
     * Internal method to perform a top-down splay.
     * The last accessed node becomes the new root.
     * @param x the target item to splay around.
     * @param t the root of the subtree to splay.
     * @return the subtree after the splay.
     */
    private Node splay( Node x, Node t )
    {
        Node leftTreeMax, rightTreeMin;

        if (header != null){
            header.setLeft(nullNode);
            header.setRight(nullNode);
        }



        leftTreeMax = rightTreeMin = header;

//        nullNode.element = x;   // Guarantee a match

        nullNode = x;
        for( ; ; )
        {
            int compareResult = x.compareTo( t );

            if( compareResult < 0 )
            {
                if( x.compareTo( t.getLeft() ) < 0 ){
                    t = rotateWithLeftChild( t );
                }

                if( t.getLeft() == nullNode ){
                    break;
                }

                // Link Right
                rightTreeMin.setLeft(t);
                rightTreeMin = t;
                t = t.getLeft();
            }
            else if( compareResult > 0 )
            {
                if( x.compareTo( t.getRight() ) > 0 )
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



    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1.
     */
    private static <AnyType> Node rotateWithLeftChild( Node k2 )
    {
        Node k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     */
    private static <AnyType> Node rotateWithRightChild( Node k1 )
    {
        Node k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        return k2;
    }


    @Override
    public Node find(String toFind) {
        return super.find(toFind);
    }





    public static void main(String[] args){
        SplayTree splay = new SplayTree();
        splay.insertSplay("C");
        splay.insertSplay("B");
        splay.insertSplay("B");

        System.out.println(splay.find("C"));
        System.out.println(splay.find("B"));
        System.out.println(splay.find("A"));

    }

}
