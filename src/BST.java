import java.util.ArrayList;

public class BST {
    private Node root;

    public BST(){
        root = null;
    }

//    public insert a new String data
    public void insert(String target){
//        calls insert on the root and the new node to insert
//        root = insert(root, new Node(target));
        /*todo check if this is correct or not*/
        root = insert(root, new Node(target));
    }

    /*should this return anything?*/
//    private recursive inserts a new data
    private Node insert(Node node, Node target) {
//        we are at a leaf, (no lef or right)

        /*I did not insert the Node here! todo be careful and make sure to insert*/
        if (node == null) {
            return target;
        }
        if (node.compareTo(target) > 0) {
            // node.key > nNode.key

//            inserting to the left
            node.setLeft(insert(node.getLeft(), target));
        }
//            inserting to the right
        else if (node.compareTo(target) < 0){
            node.setRight(insert(node.getRight(), target));
        }
        else {
            return node;
        }
        /*todo right?*/
        return null;
    }



    //    uses inOrder traversal that checks to see if the tree is verified
    public boolean verifyInorder(){
        return verifyInorder(root);
    }

    private boolean verifyInorder(Node root){
        if (root == null){
            return true;
        }
        else {
            return verifyInorder(root.getLeft()) &&
                    verifyInorder(root.getRight()) &&
                    compare(root, root.getLeft(), true) &&
                    compare(root,root.getRight(),false);
        }

    }

    private boolean compare(Node parent, Node child, boolean isLeft){
        if (child == null){
            return true;
        }
        if (isLeft){
            return parent.compareTo(child) > 0;
        }
        else {
            return parent.compareTo(child) <= 0;
        }
    }


    //    This method mainly calls deleteRec()
    public void deleteKey(String key) {
        root = deleteRec(root, new Element(key));
    }


    //     A recursive function to insert a new key in BST
    private Node deleteRec(Node node, Element key) {
//         Base Case: If the tree is empty
        if (node == null) {
//            return root;
            return node;
        }

//         Otherwise, recur down the tree
        if (key.compareTo(node.getData()) < 0) {
            node.setLeft(deleteRec(node.getLeft(), key));
        }
        else if (key.compareTo(node.getData()) > 0) {
            node.setRight(deleteRec(node.getRight(), key));
        }

        // Two children
        else if (node.getLeft() != null && node.getRight() != null) {
            node.getData() = findMin(node.getRight()).getData();
            node.getRight() = findMin(node.getData(), node.getRight());
        } else {
            node = (node.getLeft() != null) ? node.getLeft(): node.getRight();
        }
        return node;
    }




/*

        // if key is same as root's key, then This is the node
        // to be deleted
        else {
            // node with only one child or no child
            if (node.getLeft() == null) {
                return node.getRight();
            }
            else if (node.getRight() == null) {
                return node.getLeft();
            }

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            else {

                node.setElement(minValue(node.getRight()));
                // Delete the inorder successor
                node.setRight(deleteRec(node.getRight(), new Element(node.getData())));
            }
        }

        return node;
*/


/*
    //    find the successor
    private String minValue(Node node){

//        int minv = root.getData();
//        while (root.getLeft() != null){
//            minv = root.getLeft().getData();
//            root = root.getLeft();
//        }
//        return minv;

        if (node.getLeft() == null){
            return node.getData();
        }
        else {
            return minValue(node.getLeft());
        }

    }
*/


    private Node findMin(Node node){
        if( node == null ){
            return null;
        }
        else if( node.getLeft() == null ){
            return node;
        }
        else {
            return findMin( node.getLeft() );
        }
    }











    public Node find(Element toFind){
        return find(root, toFind);
    }

//    todo should i do this a different way instead of repeating code?
//      all the finds are the same so we should probably put this in somewhere and just reference it over and over
    private Node find(Node node, Element toFind){
//        if (node == null || node.getData() == toFind.getData())

//        base case either the node is null or the node is equal to the node given
        if (node == null || node.getData().compareTo(toFind.getData()) == 0){

//            just checking one more time before returning that this is the exact node looking for
            if (node.getData().equals(toFind.getData())){
                return node;
            }

        }
        if (node.getData().compareTo(toFind.getData()) > 0){
            find(node.getLeft(), toFind);
        }

//        if (node.getData().compareTo(toFind.getData()) == -1){
//            find(node.getRight(), toFind);
//        }

        return find(node.getRight(), toFind);
    }




    ArrayList<String> testing = new ArrayList<String>();
    public void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.getLeft());
        testing.add(node.getData());
//        System.out.println(node.getData());
        inOrder(node.getRight());

    }
















/* todo delete does not work */

    public static void main(String[] args){
        BST bst = new BST();
        bst.insert("the");
        bst.insert("table");
        bst.insert("apple");
        bst.insert("zig zig");

        /*todo this is alphabetical order!
        but how?*/
        bst.inOrder(bst.root);
        System.out.println(bst.testing);


    }






}
