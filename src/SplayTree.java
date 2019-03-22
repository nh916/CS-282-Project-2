import java.util.ArrayList;

public class SplayTree {
    Node root;


//im thinking when we want to:
//    find something we splay and then return
//    delete something splay then delete from the top
//    insert I am not sure about




    public SplayTree(){
        root = null;
    }

/*    public void insert(String toInsert){
        insert(root, new Node(toInsert));
    }

//    incomplete insert
    private void insert(Node node, Node toInsert){
        if (node == null){
            node = toInsert;
        }

    }*/

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
        else {
            node.setRight(insert(node.getRight(), target));
        }
        return node;
    }








/*    public void remove(String toRemove){
        remove(root, new Node(toRemove));
    }*/


// todo duplicating code again from the bst. need to just refrence a code
    //    This method mainly calls deleteRec()
    public void deleteKey(String key) {
        root = deleteRec(root, new Element(key));
    }


    //     A recursive function to insert a new key in BST
    private Node deleteRec(Node node, Element key){
//         Base Case: If the tree is empty
        if (node == null) {
//            return root;
            return null;
        }

//         Otherwise, recur down the tree
        if (key.compareTo(node.getData()) > 0) {
            node.setLeft(deleteRec(node.getLeft(), key));
        }

        else if (key.compareTo(node.getData()) < 0) {
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
                node.setRight(deleteRec(node.getRight(), new Element(node.getData())));
            }
        }

        return node;
    }

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













//    todo found online and needs to be changed and checked
//      i think it would be similar to the bst delete and then a splay method
    /*private void remove(Node node, Node toRemove){
        if (root == null) {
//            empty tree
            return;
        }
        node = splay(root, key);

        int cmp = key.compareTo(root.key);

        if (cmp == 0) {
            if (node.getLeft() == null) {
                node = node.getRight();
            }
            else {
                Node x = node.getRight();
                node = node.getLeft();
                splay(node, key);
                root.getRight() = x;
            }
        }

        // else: it wasn't in the tree to remove
    }
*/




// probably needed to splay after finding or doing something
    private void splay(){

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




//todo needs to be written out

//    public boolean isBST(){
//        return isBst(root);
//    }
//
//    private boolean isBst(Node node){
//
//    }

// here to test the insertions
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

    public static void main(String[] args){
        SplayTree splayTree = new SplayTree();
        splayTree.insert("the");
        splayTree.insert("table");
        splayTree.insert("apple");
        splayTree.insert("zig zig");
        splayTree.insert("new key");

        splayTree.inOrder(splayTree.root);
        System.out.println(splayTree.testing);

        splayTree.deleteKey("zig zig");

        /*todo this is alphabetical order!
        but how?*/


        splayTree.inOrder(splayTree.root);
        System.out.println(splayTree.testing);


    }


}
