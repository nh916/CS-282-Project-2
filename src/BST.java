import java.util.ArrayList;

public class BST {
    private Node root;

    public BST(){
        root = null;
    }

    //    public insert a new String data
    public Node insert(String fileWordIsFrom, String word){
//        calls insert on the root and the new node to insert
//        root = insert(root, new Node(target));

        root = insert(root, new Node(fileWordIsFrom, word));
        return null;
    }





//    protected for all classes that inherit this recursive inserts a new data
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
//            duplicate data
        }
        return node;
    }



    //    uses inOrder traversal that checks to see if the tree is verified
    public boolean verifyInorder(){
        return verifyInorder(root);
    }

    protected boolean verifyInorder(Node root){
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


    protected boolean compare(Node parent, Node child, boolean isLeft){
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
    public void delete(String fileWordIsFrom, String word) {
        root = deleteRec(root, new Node(fileWordIsFrom, word));
    }


    //     A recursive function to insert a new key in BST
    protected Node deleteRec(Node node, Node key){
//         Base Case: If the tree is empty
        if (node == null) {
//            return node;
            return null;
        }

//         Otherwise, recur down the tree
        if (key.compareTo(node) < 0) {
            node.setLeft(deleteRec(node.getLeft(), key));
        }

        else if (key.compareTo(node) > 0) {
            node.setRight(deleteRec(node.getRight(), key));
        }

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
                node.setRight(deleteRec(node.getRight(), node));
            }
        }

        return node;
    }

    //    find the successor
    protected String minValue(Node node){

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


    public Node find(String fileWordIsFrom, String wordToFind){
        return find(root, new Node(fileWordIsFrom, wordToFind));
    }


//      all the finds are the same so we should probably put this in somewhere and just reference it over and over
    protected Node find(Node node, Node toFind){
        if (node == null || node.equals(toFind)){

//            just trying to be through lol :) lol
//        if (node == null ||node.getData() == toFind.getData() ||node.getData().equals(toFind.getData()) || node.getData().compareTo(toFind.getData()) == 0){

                return node;
        }
        if (node.compareTo(toFind) > 0){
            return find(node.getLeft(), toFind);
        }

//        if (node.getData().compareTo(toFind.getData()) == -1){
//            find(node.getRight(), toFind);
//        }

        return find(node.getRight(), toFind);
    }




//    protected Node find(Node node, Element name){
//        if(node != null){
//            if(node.getData().equals(name)){
//                return node;
//            }
//            else {
//                Node foundNode = find(node.getLeft(), name);
//                if(foundNode == null) {
//                    foundNode = find(node.getRight(), name);
//                }
//                return foundNode;
//            }
//        }
//        else {
//            return null;
//        }
//    }


//    recursively find min
    protected Node findMin(Node node) {
        if(node == null){
            return null;
        }
        else if(node.getLeft() == null)
            return node;
        return findMin(node.getLeft());
    }


// iteratively find max
    protected Node findMax(Node node) {
        if( node != null )
            while( node.getRight() != null ){
                node = node.getRight();
            }
        return node;
    }

    protected ArrayList<String> testing = new ArrayList<String>();

    protected void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.getLeft());
        testing.add(node.getData());
//        System.out.println(node.getData());
        inOrder(node.getRight());

    }


    public static void main(String[] args){
        BST bstTree = new BST();

        bstTree.insert("file1", "hello");
        bstTree.insert("file1", "table");
        bstTree.insert("file 2", "are");
        bstTree.insert("file3", "sup sup");

        System.out.println(bstTree.find("file1", "hello"));
        System.out.println(bstTree.find("file1", "table"));
        System.out.println(bstTree.find("file 2", "are"));
        System.out.println(bstTree.find("file3", "sup sup"));
    }


}
