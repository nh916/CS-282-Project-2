public class AVLTree extends BST{

    Node root;
    int height;

    public AVLTree(){
        super();
        height = 0;
    }







    public Node insert(String toInsert){
       root = super.insert(root, new Node(toInsert));
       return balance(new Node(toInsert));
    }


//    private Node insert(Node node, Node toInsert){
//        if( node == null ){
//            return new Node(toInsert.getData());
//        }
//
//        if(node.compareTo(toInsert) < 0){
////            node.getLeft() = insert( x, t.left );
//            node.setLeft(insert(node.getLeft(), toInsert));
//        }
//        else if(node.compareTo(toInsert) > 0){
////            t.right = insert( x, t.right );
//            node.setRight(insert(node.getRight(), toInsert));
//        }
//        else{
//             // Duplicate; do nothing
////            todo i believe we need to keep track of duplicates so we cant just do nothing. it has to be stored somewhere
//            return balance(toInsert);
////            return toInsert;
//        }
////        todo becareful here! is this really null or something else?
//        return node;
//    }
//
//
//    public Node find(String toFind){
//        return find(root, new Node(toFind));
//    }
//
//
//
//    //    straight out copied from the BST class
////    todo duplicate code
//    private Node find(Node node, Node toFind){
////        if (node == null || node.getData() == toFind.getData())
//
////        base case either the node is null or the node is equal to the node given
//        if (node == null || node.getData().compareTo(toFind.getData()) == 0){
//
////            just checking one more time before returning that this is the exact node looking for
//            if (node.getData().equals(toFind.getData())){
//                return node;
//            }
//
//        }
//        if (node.getData().compareTo(toFind.getData()) > 0){
//            find(node.getLeft(), toFind);
//        }
//
////        if (node.getData().compareTo(toFind.getData()) == -1){
////            find(node.getRight(), toFind);
////        }
//
//        return find(node.getRight(), toFind);
//    }







    private int height(Node t){
//        if (t == null){
//            return 0;
//        }
//
//        return t.height;

        return t == null ? -1 : t.height;
    }


    private static final int ALLOWED_IMBALANCE = 1;


    private Node balance(Node node){
        if( node == null ){
            return node;
        }
        if( height(node.getLeft()) - height(node.getRight()) > ALLOWED_IMBALANCE ){
            if(height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())){
                node = rotateWithLeftChild( node );
            }
            else {
                node = doubleWithLeftChild( node );
            }
        }
        else {
            if( height(node.getRight()) - height(node.getLeft()) > ALLOWED_IMBALANCE ){
                if( height(node.getRight().getRight()) >= height( node.getRight().getLeft()) ){
                    node = rotateWithRightChild(node);
                }
                else {
                    node = doubleWithRightChild(node);
                }
                node.height = Math.max( height(node.getLeft()), height(node.getRight()) ) + 1;
            }
        }
        return node;
    }


    private Node rotateWithLeftChild(Node k2){
//        be sure these make any kind of sense or if the names should be changed because of current element class
        Node k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.height = Math.max(height(k2.getLeft()), height(k2.getRight())) + 1;
        k1.height = Math.max(height(k1.getLeft()), k2.height) + 1;
        return k1;
    }

//    todo is this even right?
    private Node rotateWithRightChild(Node nodeToRotate){
        Node k1 = nodeToRotate.getRight();
        nodeToRotate.setRight(k1.getLeft());
        k1.setLeft(nodeToRotate);
        nodeToRotate.height = Math.max(height(nodeToRotate.getRight()), height(nodeToRotate.getLeft())) + 1;
        k1.height = Math.max(height(k1.getRight()), nodeToRotate.height) + 1;
        return k1;
    }


    private Node doubleWithLeftChild(Node k3){
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }

    /*todo check this*/
    private Node doubleWithRightChild(Node k3){
        k3.setRight(rotateWithLeftChild(k3.getRight()));
        return rotateWithRightChild(k3);
    }

/*    public Node remove(String toRemove){
        *//*wrong second argument*//*
        return remove(root, new Node(toRemove));
    }*/

//    needs to be heavily changed
//        from the arguments to the methods and the variable names
    private Node remove(Node t, String toRemove){
        if( t == null ){
            // Item not found; do nothing
            return t;
        }

        if(toRemove.compareTo(t.getData()) < 0){
            t.setLeft(remove(t.getLeft(), toRemove));
        }
        else if(toRemove.compareTo(t.getData()) > 0){
            t.setRight(remove(t.getRight(), toRemove));
        }

// Two children
        else if( t.getLeft() != null && t.getRight() != null ){

//            t.setElement(findMin(t.getRight()).element);
            t.setElement(findMin(t.getRight()).getData());

//            is this a longer way of writing the above or is it different?
            /*            Node minFound = findMin(t.getRight());
            t.setElement(minFound.getData());*/

//            t.setRight(remove(t.element, t.getRight()));
            t.setRight(remove(t.getRight(), t.getData()));
        }
        else {
//            again. hate shorthand
            t = ( t.getLeft() != null ) ? t.getLeft() : t.getRight();
        }
        return balance(t);
    }


    private Node findMin(Node node){
        if(node == null){
            return null;
        }
        else if(node.getLeft() == null){
            return node;
        }
        else {
            return findMin(node.getLeft());
        }
    }



    // iteratively find the max.
//    not needed but have the code so why not. just in case
    private Node findMax(Node t){
        if( t != null ){
            while( t.getRight() != null ){
                t = t.getRight();
            }
        }
        return t;
    }




//
//    /* Print nodes at the given level */
//    void printGivenLevel (Node root ,int level) {
//        if (root == null)
//            return;
//        if (level == 1)
//            System.out.print(root.getData() + " ");
//        else if (level > 1)
//        {
//            printGivenLevel(root.getLeft(), level-1);
//            printGivenLevel(root.getRight(), level-1);
//        }
//    }
//
//
//    /* function to print level order traversal of tree*/
//    public void printLevelOrder() {
//        int h = height(root);
//        int i;
//        for (i=1; i<=h; i++) {
//            System.out.println();
//            printGivenLevel(root, i);
//        }
//    }






    public static void main(String[] args){
        AVLTree tree = new AVLTree();
        tree.insert("the");
        tree.insert("table");
        tree.insert("apple");
        tree.insert("zig zig");


        tree.inOrder(tree.root);
        System.out.println(tree.testing);

//        tree.printLevelOrder();
//
//        tree.printGivenLevel(tree.root, 0);
//        tree.printGivenLevel(tree.root, 1);
//        tree.printGivenLevel(tree.root, 2);
//        tree.printGivenLevel(tree.root, 3);
//        tree.printGivenLevel(tree.root, 4);

    }




}
