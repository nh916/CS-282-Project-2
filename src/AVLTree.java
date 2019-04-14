public class AVLTree extends BST{

    private Node root;

    public AVLTree(){
        root = null;
    }


    @Override
    public Node find(String toFind) {
        return super.find(toFind);
    }


    public void insertAVL(boolean file1, boolean file2, boolean file3, boolean file4, String data) {
        root = insertAVL( new Node(file1, file2, file3, file4, data), root );
    }

    private Node insertAVL( Node x, Node t ) {
        if( t == null )
            return x;

        int compareResult = x.getData().compareTo( t.getData() );

        if( compareResult < 0 ) {
            t.setLeft(insertAVL( x, t.getLeft() ));
            if( height( t.getLeft() ) - height( t.getRight() ) == 2 )
                if( x.getData().compareTo( t.getLeft().getData()) < 0 )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( compareResult > 0 ) {
            t.setRight(insertAVL( x, t.getRight() ));
            if( height( t.getRight() ) - height( t.getLeft() ) == 2 )
                if( x.getData().compareTo( t.getRight().getData()) > 0 )
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
            ;  // Duplicate; do nothing
        t.height = Math.max( height( t.getLeft() ), height( t.getRight() ) ) + 1;
        return t;
    }

    private int height(Node t ) {
        return t == null ? -1 : t.height;
    }

    private Node rotateWithLeftChild(Node k2 ) {
        Node k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.height = Math.max( height( k2.getLeft() ), height( k2.getRight() ) ) + 1;
        k1.height = Math.max( height( k1.getLeft() ), k2.height ) + 1;
        return k1;
    }

    private Node rotateWithRightChild(Node k1 ) {
        Node k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.height = Math.max( height( k1.getLeft() ), height( k1.getRight() ) ) + 1;
        k2.height = Math.max( height( k2.getRight() ), k1.height ) + 1;
        return k2;
    }


    private Node doubleWithLeftChild(Node k3 ) {
        k3.setLeft(rotateWithRightChild( k3.getLeft()));
        return rotateWithLeftChild( k3 );
    }

    private Node doubleWithRightChild(Node k1 ) {
        k1.setRight(rotateWithLeftChild( k1.getRight() ));
        return rotateWithRightChild( k1 );
    }


    public static void main(String[] args){

        AVLTree tree = new AVLTree();
        tree.insertAVL(true, true, true, true, "A");
        tree.insertAVL(true, true, true, true, "B");
        tree.insertAVL(true, true, true, true, "C");

        System.out.println(tree.find("A"));
        System.out.println(tree.find("B"));
        System.out.println(tree.find("C"));
    }




}