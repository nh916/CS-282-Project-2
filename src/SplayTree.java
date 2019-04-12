public class SplayTree extends AVLTree{
    private Node root;

    private Node nullNode;

    public SplayTree() {
        root = new Node(null);
//        root.setLeft(null);
//        root.setRight(null);

        nullNode = new Node(null);
    }

//    different than book's code for now

    private Node newNode = new Node(null);  // Used between different inserts

    public Node insert(String toInsert){
        return insert(new Node(toInsert));
    }


//    change the method signature || arguments
    public Node insert(Node x) {
        if(newNode == null){
            newNode = new Node(null);
        }
        newNode.setElement(x);

        if(root == nullNode) {
            newNode.setLeft(nullNode);
            newNode.setRight(nullNode);
            root = newNode;
        }
        else {
            root = splay(x, root);

            int compareResult = x.compareTo( root.getData() );

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
//            else{
////                deviation from books
//                return nullNode;   // No duplicates
//            }
        }
        newNode = null;   // So next insert will call new
        return nullNode;
    }



    private Node header = new Node( null ); // For splay

    private Node splay( String x, Node t ) {
        Node leftTreeMax, rightTreeMin;

        header.setLeft(nullNode);
        header.setRight(nullNode);

        leftTreeMax = rightTreeMin = header;

        nullNode.setElement(x); ;   // Guarantee a match

        for( ; ; ) {
            int compareResult = x.compareTo( t.getData() );

            if( compareResult < 0 ) {
                if( x.compareTo( t.getLeft().getData() ) < 0 )
                    t = super.rotateWithLeftChild( t );
                if( t.getLeft() == nullNode )
                    break;
                // Link Right
                rightTreeMin.setLeft(t);
                rightTreeMin = t;
                t = t.getLeft();
            }
            else if( compareResult > 0 ) {
                if( x.compareTo( t.getRight().getData() ) > 0 )
                    t = super.rotateWithRightChild( t );
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


















    public static void main(String[] args){
        SplayTree splay = new SplayTree();
        splay.insert("C");
        splay.insert("B");
        splay.insert("A");
//        splay.insert("co");
//        splay.insert("ji");
    }

}
