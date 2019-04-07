public class AVLTree extends BST{

    private Node root;

    public AVLTree(){
        super();
        root = null;
    }

    @Override
    public Node find(String findThis){
        return super.find(root, new Element(findThis));
    }


    public Node insert(String x){
        return root = insert( x, root );
    }


    private Node insert( String x, Node t ) {
        if (t == null)
            return new Node(x);

        int compareResult = x.compareTo(t.getData());

        if (compareResult < 0) {
            t.setLeft(insert(x, t.getLeft()));
            if (height(t.getLeft()) - height(t.getRight()) == 2) {
                if (x.compareTo(t.getLeft().getData()) < 0) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (compareResult > 0) {
            t.setRight(insert(x, t.getRight()));
            if (height(t.getRight()) - height(t.getLeft()) == 2) {
                if (x.compareTo(t.getRight().getData()) > 0) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else {
            // Duplicate; do nothing
        }
        return t;
    }

        private int height( Node t ) {
//        return t == null ? -1 : t.height;

        if (t == null){
            return -1;
        }
        else {
            return t.height;
        }

    }

    private Node rotateWithLeftChild( Node k2 ) {
        Node k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.height = Math.max( height( k2.getLeft() ), height( k2.getRight() ) ) + 1;
        k1.height = Math.max( height( k1.getLeft() ), k2.height ) + 1;
        return k1;
    }

    private Node rotateWithRightChild( Node k1 ) {
        Node k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.height = Math.max( height( k1.getLeft() ), height( k1.getRight() ) ) + 1;
        k2.height = Math.max( height( k2.getRight() ), k1.height ) + 1;
        return k2;
    }

    private Node doubleWithLeftChild( Node k3 ) {
        k3.setLeft(rotateWithRightChild( k3.getLeft() ));
        return rotateWithLeftChild( k3 );
    }

    private Node doubleWithRightChild( Node k1 ) {
        k1.setLeft(rotateWithLeftChild( k1.getRight() ));
        return rotateWithRightChild( k1 );
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args){
        AVLTree tree = new AVLTree();
        tree.insert("3");
        tree.insert("2");
        tree.insert("1");
//        tree.insert("20");
//        tree.insert("10");
//        tree.insert("11");

        System.out.println(tree.find("3"));
        System.out.println(tree.find("2"));
        System.out.println(tree.find("1"));
//        System.out.println(tree.find("20"));
//        System.out.println(tree.find("10"));
//        System.out.println(tree.find("11"));
    }
    
    
}
