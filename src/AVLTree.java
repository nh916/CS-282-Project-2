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

    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers 
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to getRight() rotate subtree rooted with y 
    // See the diagram given above. 
    Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        // Perform rotation 
        x.setRight(y);
        y.setLeft(T2);

        // Update heights 
        y.height = max(height(y.getLeft()), height(y.getRight())) + 1;
        x.height = max(height(x.getLeft()), height(x.getRight())) + 1;

        // Return new root 
        return x;
    }

    // A utility function to getLeft() rotate subtree rooted with x 
    // See the diagram given above. 
    Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        // Perform rotation 
        y.setLeft(x);
        x.setRight(T2);

        //  Update heights 
        x.height = max(height(x.getLeft()), height(x.getRight())) + 1;
        y.height = max(height(y.getLeft()), height(y.getRight())) + 1;

        // Return new root 
        return y;
    }

    // Get Balance factor of node N 
    private int getBalance(Node N) {
        if (N == null) {
            return 0;
        }

        return height(N.getLeft()) - height(N.getRight());
    }

    public Node insert(String toInsert){
        return root = insert(root, new Node(toInsert));
    }


    private Node insert(Node node, Node key) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return key;

        if (node.compareTo(key) > 0) {
            node.setLeft(insert(node.getLeft(), key));
        }
        else if (node.compareTo(key) < 0) {
            node.setRight(insert(node.getRight(), key));
        }
        else { // Duplicate keys not allowed
            return node;
        }

//        2. Update height of this ancestor node
        node.height = 1 + max(height(node.getLeft()), height(node.getRight()));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // getLeft() getLeft() Case
        if (balance > 1 && key.compareTo(node.getLeft()) < 0) {
            return rightRotate(node);
        }

        // getRight() getRight() Case
        if (balance < -1 && key.compareTo(node.getRight()) > 0) {
            return leftRotate(node);
        }

        // getLeft() getRight() Case
        if (balance > 1 && key.compareTo(node.getRight()) > 0 ) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }


        // getRight() getLeft() Case
        if (balance < -1 && key.compareTo(node.getLeft()) < 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }




        /* return the (unchanged) node pointer */
        return node;
    }







    public static void main(String[] args){
        AVLTree tree = new AVLTree();

        String cases = "RL";


        if (cases.equals("LL")){
            tree.insert("3");
            tree.insert("2");
            tree.insert("1");


//            tree.insert("0");
//            tree.insert("-1");
//            tree.insert("-2");
//            tree.insert("-3");


        }

        else if (cases.equals("RR")){
            tree.insert("1");
            tree.insert("2");
            tree.insert("3");

//            tree.insert("4");
//            tree.insert("5");
//            tree.insert("6");
        }

        else if (cases.equals("LR"){
            tree.insert("3");
            tree.insert("1");
            tree.insert("2");
        }
        else if (cases.equals("RL")){
            tree.insert("1");
            tree.insert("3");
            tree.insert("2");
        }
        else {
            System.out.println("hit the else case!");
        }



//        tree.insert("20");
//        tree.insert("10");
//        tree.insert("11");

        System.out.println(tree.find("1"));
        System.out.println(tree.find("3"));
        System.out.println(tree.find("2"));



//        System.out.println(tree.find("20"));
//        System.out.println(tree.find("10"));
//        System.out.println(tree.find("11"));

    }
    
    
}
