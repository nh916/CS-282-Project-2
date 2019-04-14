public class AVLTree extends BST{

    private Node root;

    public AVLTree(){
        super();
        root = null;
    }

    @Override
    public Node find(String findThis){
        return super.find(root, new Node(findThis));
    }

    public Node insert(boolean file1, boolean file2, boolean file3, boolean file4, String data){
        return root = insertAVL(new Node(file1, file2, file3, file4, data), root);
    }


    private Node insertAVL(Node x, Node t) {
        if (t == null) {
            return x;
        }

//        todo can take out getData if i wanted...
        int compareResult = x.getData().compareTo(t.getData());

        if (compareResult < 0) {
            t.setLeft(insertAVL(x, t.getLeft()));
            if (height(t.getLeft()) - height(t.getRight()) == 2) {
                if (x.getData().compareTo(t.getLeft().getData()) < 0) {
                    t = rotateWithLeftChild(t);
                }
                else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (compareResult > 0) {
            t.setRight(insertAVL(x, t.getRight()));
            if (height(t.getRight()) - height(t.getLeft()) == 2) {
                if (x.getData().compareTo(t.getRight().getData()) > 0) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else {
            // Duplicate; do nothing

        }
//        just here because the code put it here
        t.height = Math.max( height( t.getLeft() ), height( t.getRight())) + 1;
        return t;
    }

    private int height( Node t ) {
        return t == null ? -1 : t.height;

//        if (t == null){
//            return -1;
//        }
//        else {
//            return t.height;
//        }

    }

    private Node rotateWithLeftChild( Node k2 ) {
        Node k1 = k2.getLeft();
        if (k2.getLeft() == null){
            return k2;
        }
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.height = Math.max(height(k2.getLeft()), height(k2.getRight())) + 1;
        k1.height = Math.max(height(k1.getLeft()), k2.height) + 1;
        return k1;

    }

    private Node rotateWithRightChild( Node k1 ) {
        Node k2 = k1.getRight();
        if (k1.getRight() == null){
            return k1;
        }
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.height = Math.max(height(k1.getLeft()), height(k1.getRight())) + 1;
        k2.height = Math.max(height(k2.getRight()), k1.height) + 1;
        return k2;

    }

    private Node doubleWithLeftChild( Node k3 ) {
        k3.setLeft(rotateWithRightChild( k3.getLeft() ));
        return rotateWithLeftChild( k3 );
    }

    private Node doubleWithRightChild( Node k1 ) {
        k1.setRight(rotateWithLeftChild( k1.getRight() ));
        return rotateWithRightChild( k1 );
    }


    public void delete(String toDelete){
        delete(root, new Node(toDelete));
    }

    private void delete(Node root, Node toDelete){
        super.deleteRec(root, toDelete);
        balance(root);
    }



    private static final int ALLOWED_IMBALANCE = 1;
    // Assume t is either balanced or within one of being balanced
    private Node balance( Node t ){
        if( t == null ){
            return t;
        }
        if( height( t.getLeft() ) - height( t.getRight() ) > ALLOWED_IMBALANCE ){
            if( height( t.getLeft().getLeft() ) >= height( t.getLeft().getRight() ) ){
                t = rotateWithLeftChild( t );
            }
            else {
                t = doubleWithLeftChild( t );
            }
        }
        else {
            if( height( t.getRight() ) - height( t.getLeft() ) > ALLOWED_IMBALANCE ){
                if( height( t.getRight().getRight() ) >= height( t.getRight().getLeft() ) ){
                    t = rotateWithRightChild( t );
                }
                else {
                    t = doubleWithRightChild( t );
                }
            }
        }
        t.height = Math.max( height( t.getLeft() ), height( t.getRight() ) ) + 1;
        return t;
    }







    public static void main(String[] args){
        AVLTree tree = new AVLTree();

        String cases = "LR";

        if (cases.equals("LL")){
            tree.insert(false, false, false, false, "C");
            tree.insert(false, false, false, false, "B");
            tree.insert(false, false, false, false, "A");


//            tree.insert("0");
//            tree.insert("-1");
//            tree.insert("-2");
//            tree.insert("-3");


        }

        else if (cases.equals("RR")){
            tree.insert(false, false, false, false,"A");
            tree.insert(false, false, false, false,"B");
            tree.insert(false, false, false, false,"C");

//            tree.insert("4");
//            tree.insert("5");
//            tree.insert("6");
        }

        else if (cases.equals("LR")){
            tree.insert(false, false, false, false,"C");
            tree.insert(false, false, false, false,"A");
            tree.insert(false, false, false, false,"B");
//            tree.insert("5");
//            tree.insert("4");
        }
        else if (cases.equals("RL")){
            tree.insert(false, false, false, false,"A");
            tree.insert(false, false, false, false,"C");
            tree.insert(false, false, false, false,"B");
        }
        else {
            System.out.println("hit the else case!");
        }


//        tree.insert("Y");
//        tree.insert("D");
//        tree.insert("T");
//        tree.insert("H");
//
        System.out.println(tree.find("A"));
        System.out.println(tree.find("B"));
        System.out.println(tree.find("C"));
//
//        System.out.println(tree.find("Y"));
//        System.out.println(tree.find("D"));
//        System.out.println(tree.find("T"));
//        System.out.println(tree.find("H"));
//
//
//
//
//        tree.delete("D");
//
//
//        System.out.println("deleted");
//
//
//        System.out.println(tree.find("A"));
//        System.out.println(tree.find("B"));
//        System.out.println(tree.find("C"));
//
//        System.out.println(tree.find("Y"));
//        System.out.println(tree.find("D"));
//        System.out.println(tree.find("T"));
//        System.out.println(tree.find("H"));

tree.delete("A");
        System.out.println(tree.find("A"));
        System.out.println(tree.find("B"));
        System.out.println(tree.find("C"));

    }


}