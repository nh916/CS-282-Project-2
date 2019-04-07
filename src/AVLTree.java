public class AVLTree extends BST{

    Node root;

    public AVLTree(){
        super();
    }

    @Override
    public Node find(String findThis){
        return super.find(root, new Element(findThis));
    }



/*    public Node delete(String deleteThis){
        return balance(super.deleteRec(root,new Element(deleteThis)));
    }*/




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



    /*// tried fixing the balance with sending it to the same node. however same result given

    private int height(Node t){
        if (t == null){
            return -1;
        }

            return t.height;

//        todo transalted this code to the long version
//        return (t == null) ? -1 : t.height;
    }


    private static final int ALLOWED_IMBALANCE = 1;

    private Node balance(Node node){
        if( node == null ){
            return node;
        }
        if(height(node.getLeft()) - height(node.getRight()) > ALLOWED_IMBALANCE ){
            if(height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())){
                node = rotateWithLeftChild(node);
            }
            else {
                node = doubleWithLeftChild(node);
            }
        }
        else {
            if(height(node.getRight()) - height(node.getLeft()) > ALLOWED_IMBALANCE ){
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
        k2.height = Math.max( height(k2.getLeft()), height(k2.getRight()) ) + 1;
        k1.height = Math.max(height(k1.getLeft()), k2.height) + 1;
        return k1;
    }

//    todo is this even right?
    private Node rotateWithRightChild(Node k2){
        Node k1 = k2.getRight();
        k2.setRight(k1.getLeft());
        k1.setLeft(k2);
        k2.height = Math.max(height(k2.getRight()), height(k2.getLeft())) + 1;
        k1.height = Math.max(height(k1.getRight()), k2.height) + 1;
        return k1;
    }


    private Node doubleWithLeftChild(Node k3){
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }

    */
    /*todo check this*/
    /*
    private Node doubleWithRightChild(Node k3){
        k3.setRight(rotateWithLeftChild(k3.getRight()));
        return rotateWithRightChild(k3);
    }
*/






//    todo princeton code
    /*@Override
    public Node insert(String toInsert){
        root = super.insert(root, new Node(toInsert));
//       return balance(new Node(toInsert));

        root.size = 1 + size(root.getLeft()) + size(root.getRight());
        root.height = 1 + Math.max(height(root.getLeft()), height(root.getRight()));
        return balance(find(toInsert));

*//*        // Update balance factor and height values.
        update(new Node(toInsert));

        // Re-balance tree.
        return balance(root);*//*

//        return balance(find(root.getData()));
//        return balance(root);
//        return balance(root = super.insert(root, new Node (toInsert)));
    }*/


    /*private void update(Node node) {

        int leftNodeHeight  = (node.getLeft()  == null) ? -1 : node.getLeft().height;
        int rightNodeHeight = (node.getRight() == null) ? -1 : node.getRight().height;

        // Update this node's height.
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

        // Update balance factor.
        node.bf = rightNodeHeight - leftNodeHeight;

    }



    // Re-balance a node if its balance factor is +2 or -2.
    private Node balance(Node node) {

        // Left heavy subtree.
        if (node.bf == -2) {

            // Left-Left case.
            if (node.getLeft().bf <= 0) {
                return leftLeftCase(node);

                // Left-Right case.
            } else {
                return leftRightCase(node);
            }

            // Right heavy subtree needs balancing.
        } else if (node.bf == +2) {

            // Right-Right case.
            if (node.getRight().bf >= 0) {
                return rightRightCase(node);

                // Right-Left case.
            } else {
                return rightLeftCase(node);
            }

        }
        // Node either has a balance factor of 0, +1 or -1 which is fine.
        return node;
    }


        private Node leftLeftCase(Node node) {
            return rightRotation(node);
        }

        private Node leftRightCase(Node node) {
            node.setLeft(leftRotation(node.getLeft()));
            return leftLeftCase(node);
        }

        private Node rightRightCase(Node node) {
            return leftRotation(node);
        }

        private Node rightLeftCase(Node node) {
            node.setRight(rightRotation(node.getRight()));
            return rightRightCase(node);
        }

        private Node leftRotation(Node node) {
            Node newParent = node.getRight();
            node.setRight(newParent.getLeft());
            newParent.setLeft(node);
            update(node);
            update(newParent);
            return newParent;
        }

        private Node rightRotation(Node node) {
            Node newParent = node.getLeft();
            node.setLeft(newParent.getRight());
            newParent.setRight(node);
            update(node);
            update(newParent);
            return newParent;
        }*/





    /*todo this is the put method from princeton*/
/*    public Node put(String toInsert){
        return root = put(root, new Node(toInsert));
    }

*//*      Inserts the key-value pair in the subtree. It overrides the old value
      with the new value if the symbol table already contains the specified key
      and deletes the specified key (and its associated value) from this symbol
      table if the specified value is {@code null}.

      @param x the subtree
      @param key the key
      @param val the value
      @return the subtree*//*
    private Node put(Node root, Node target) {
        if (root == null) {
            return target;
        }
        int cmp = root.compareTo(target);
        if (cmp < 0) {
            root.setLeft(put(root.getLeft(), target));
        }
        else if (cmp > 0) {
            root.setRight(put(root.getRight(), target));
        }
        else {
            root.setElement(target.getData());
            return root;
        }
        root.size = 1 + size(root.getLeft()) + size(root.getRight());
        root.height = 1 + Math.max(height(root.getLeft()), height(root.getRight()));
        return balance(root);
    }*/



    /*private Node balance(Node x) {
        if (balanceFactor(x) < -1) {
            if (balanceFactor(x.getRight()) > 0) {
                x.setRight(rotateRight(x.getRight()));
            }
            x = rotateLeft(x);
        }
        else if (balanceFactor(x) > 1) {
            if (balanceFactor(x.getLeft()) < 0) {
                x.setLeft(rotateLeft(x.getLeft()));
            }
            x = rotateRight(x);
        }
        return x;
    }

    private int balanceFactor(Node x) {
        return height(x.getLeft()) - height(x.getRight());
    }

    private int height(Node x) {
        if (x == null) {
            return -1;
        }
        return x.height;
    }


    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    private Node rotateRight(Node x) {
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);
        y.size = x.size;
        x.size = 1 + size(x.getLeft()) + size(x.getRight());
        x.height = 1 + Math.max(height(x.getLeft()), height(x.getRight()));
        y.height = 1 + Math.max(height(y.getLeft()), height(y.getRight()));
        return y;
    }

    private Node rotateLeft(Node x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        y.size = x.size;
        x.size = 1 + size(x.getLeft()) + size(x.getRight());
        x.height = 1 + Math.max(height(x.getLeft()), height(x.getRight()));
        y.height = 1 + Math.max(height(y.getLeft()), height(y.getRight()));
        return y;
    }*/





//  todo this is the book code

    public Node insert(String toInsert) {
       return (root = insert(new Node(toInsert), root));
    }




    protected Node insert( Node target, Node root ) {
        if( root == null ) {
            return target;
        }
        int compareResult = target.compareTo(root);

        if( compareResult < 0 ) {
            root.setLeft(insert( target, root.getLeft() ));
            if( height( root.getLeft() ) - height( root.getRight() ) == 2) {
                if (target.compareTo(root.getLeft()) < 0) {
                    root = rotateWithLeftChild(root);
                }
                else {
                    root = doubleWithLeftChild(root);
                }
            }
        }
        else if( compareResult > 0 ) {
            root.setRight(insert( target, root.getRight() ));
            if( height( root.getRight() ) - height( root.getLeft() ) == 2 ) {
                if (target.compareTo(root.getRight()) > 0) {
                    root = rotateWithRightChild(root);
                }
                else {
                    root = doubleWithRightChild(root);
                }
            }
        }
        else {
            // Duplicate; do nothing
            root.height = Math.max(height(root.getLeft()), height(root.getRight())) + 1;
        }
        return root;
    }

    private int height( Node t ) {
//        return t == null ? -1 : t.height;
        if (t == null){
            return -1;
        }
        if (t.getLeft() != null){
            t.height+=1;
            height(t.getLeft());
            return t.height;
        }
        if (t.getRight() != null){
            t.height+=1;
            height(t.getRight());
            return t.height;
        }
        return 0;
//        return t.height;
    }



//    my own code trying to go down to a leaf node and then go all the way back up. but realized bst only goes down
/*    private void leftSubTree(Node node){
 *//*       Node leftLeafNode;
        while (node.getLeft() != null){
            leftLeafNode = node.getLeft();
            node.height+= 1;
            balanceFactor(node.getLeft());
        }*//*

        if (node.getLeft() != null){
            leftSubTree(node.getLeft());
        }
    }*/


    private int maxDepth(Node node) {
        if (node == null)
            return 0;
        else {
//             compute the depth of each subtree
            int lDepth = maxDepth(node.getLeft());
            int rDepth = maxDepth(node.getRight());

//             use the larger one
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
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


//      Return the height of node t, or -1, if null.






//      Rotate binary tree node with right child.
//      For AVL trees, this is a single rotation for case 4.
//      Update heights, then return new root.

    private Node rotateWithRightChild( Node k1 ) {
        Node k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.height = Math.max( height( k1.getLeft() ), height( k1.getRight() ) ) + 1;
        k2.height = Math.max( height( k2.getRight() ), k1.height ) + 1;
        return k2;
    }


//      Double rotate binary tree node: first left child
//      with its right child; then node k3 with new left child.
//      For AVL trees, this is a double rotation for case 2.
//      Update heights, then return new root.

    private Node doubleWithLeftChild( Node k3 ) {
        k3.setLeft(rotateWithRightChild( k3.getLeft() ));
        return rotateWithLeftChild( k3 );
    }


//      Double rotate binary tree node: first right child
//      with its left child; then node k1 with new right child.
//      For AVL trees, this is a double rotation for case 3.
//      Update heights, then return new root.

    private Node doubleWithRightChild( Node k1 ) {
        k1.setRight(rotateWithLeftChild( k1.getRight() ));
        return rotateWithRightChild( k1 );
    }





















//    unneeded
//    private Node remove(Node t, String toRemove){
//        if( t == null ){
//            // Item not found; do nothing
//            return t;
//        }
//
//        if(toRemove.compareTo(t.getData()) < 0){
//            t.setLeft(remove(t.getLeft(), toRemove));
//        }
//        else if(toRemove.compareTo(t.getData()) > 0){
//            t.setRight(remove(t.getRight(), toRemove));
//        }
//
//// Two children
//        else if( t.getLeft() != null && t.getRight() != null ){
//
////            t.setElement(findMin(t.getRight()).element);
//            t.setElement(findMin(t.getRight()).getData());
//
////            is this a longer way of writing the above or is it different?
//            /*            Node minFound = findMin(t.getRight());
//            t.setElement(minFound.getData());*/
//
////            t.setRight(remove(t.element, t.getRight()));
//            t.setRight(remove(t.getRight(), t.getData()));
//        }
//        else {
////            again. hate shorthand
//            t = ( t.getLeft() != null ) ? t.getLeft() : t.getRight();
//        }
//        return balance(t);
//    }
//
//
//    private Node findMin(Node node){
//        if(node == null){
//            return null;
//        }
//        else if(node.getLeft() == null){
//            return node;
//        }
//        else {
//            return findMin(node.getLeft());
//        }
//    }
//
//
//
//    // iteratively find the max.
////    not needed but have the code so why not. just in case
//    private Node findMax(Node t){
//        if( t != null ){
//            while( t.getRight() != null ){
//                t = t.getRight();
//            }
//        }
//        return t;
//    }












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

/*        tree.insert("the");
        tree.insert("table");
        tree.insert("apple");*/

        tree.insert("20");
        tree.insert("30");
        tree.insert("3220");
        tree.insert("2");
        tree.insert("5");




/*        tree.insert("50");
        tree.insert("25");
        tree.insert("30");
        tree.insert("10");
        tree.insert("8");
        tree.insert("5");
        tree.insert("80");
        tree.insert("2");*/





//        tree.insert("zig zig");
//        tree.insert("123456");


        System.out.println(tree.find("20"));
        System.out.println(tree.find("30"));
        System.out.println(tree.find("3220"));
        System.out.println(tree.find("2"));
        System.out.println(tree.find("5"));



// too many rotations and this combo is currently not working. gives me back a fucked up tree
/*
        System.out.println(tree.find("50"));
        System.out.println(tree.find("25"));
        System.out.println(tree.find("30"));
        System.out.println(tree.find("10"));
        System.out.println(tree.find("8"));
        System.out.println(tree.find("5"));
        System.out.println(tree.find("80"));
        System.out.println(tree.find("2"));
*/





//        System.out.println(tree.find("zig zig"));
//        System.out.println(tree.find("123456"));

//        tree.delete("the");

//        tree.testing.clear();
//        tree.inOrder(tree.root);
//        System.out.println(tree.testing);




    }




}
