import java.util.ArrayList;
public class BST {

    private Node root;

    public BST(){
        root = null;
    }

    //    public insert a new String data
    public Node insert(boolean file1, boolean file2, boolean file3, boolean file4, String data){
//        calls insert on the root and the new node to insert
//        root = insert(root, new Node(target));

        return root = insert(root, new Node(file1, file2, file3, file4, data));

    }


    //    protected for all classes that inherit this recursive inserts a new data
    protected Node insert(Node node, Node target) {
//        we are at a leaf, (no lef or right)

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
            if (target.compareTo(node) == 0 || target.equals(node)){
//                todo check to see which one you can then turn on
            }
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
    public void deleteKey(boolean file1, boolean file2, boolean file3, boolean file4, String key) {
        root = deleteRec(root, new Node(file1, file2, file3, file4, key));
    }


    //     A recursive function to insert a new key in BST
    protected Node deleteRec(Node node, Node key){
//         Base Case: If the tree is empty
        if (node == null) {
//            return node;
            return null;
        }

//         Otherwise, recur down the tree
        if (key.getData().compareTo(node.getData()) < 0) {
            node.setLeft(deleteRec(node.getLeft(), key));
        }

        else if (key.getData().compareTo(node.getData()) > 0) {
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
                node.setRight(deleteRec(node.getRight(), new Node(node.getFile1(), node.getFile2(), node.getFile3(), node.getFile4(), node.getData())));
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



    public Node find(String toFind){
        return find(root, new Node(toFind));
    }


    //      all the finds are the same so we should probably put this in somewhere and just reference it over and over
//    this used to take the root and an element now it takes a root and a Node
    protected Node find(Node node, Node toFind){
        if (node == null || node.getData().equals(toFind.getData())){

//        if (node == null || node.getData().compareTo(toFind.getData()) == 0){

//        base case either the node is null or the node is equal to the node given

//        if (node == null ||node.getData() == toFind.getData() ||node.getData().equals(toFind.getData()) || node.getData().compareTo(toFind.getData()) == 0){

//            just checking one more time before returning that this is the exact node looking for
//            if (node.getData().equals(toFind.getData())){

            return node;

//            }

        }
        if (node.getData().compareTo(toFind.getData()) > 0){
            return find(node.getLeft(), toFind);
        }

//        if (node.getData().compareTo(toFind.getData()) == -1){
//            find(node.getRight(), toFind);
//        }

        return find(node.getRight(), toFind);
    }



// todo gives null
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


    // todo fix delete
    public static void main(String[] args){
        BST bst = new BST();
        bst.insert(true, false, false, false, "A");
        bst.insert(false, true, false, false, "B");
        bst.insert(false, true, true, false, "C");

        System.out.println(bst.find("A"));
        System.out.println(bst.find("B"));

        System.out.println(bst.find("C"));

    }
}
