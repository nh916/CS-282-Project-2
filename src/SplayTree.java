/*
public class SplayTree {
    Node root;


    */
/*im thinking when we want to:
    find something we splay and then return
    delete something splay then delete from the top
    insert I am not sure about*//*




    public SplayTree(){
        root = null;
    }

    public void insert(String toInsert){
        insert(root, new Node(toInsert));
    }

//    incomplete insert
    private void insert(Node node, Node toInsert){
        if (node == null){
            node = toInsert;
        }

    }

    public void remove(String toRemove){
        remove(root, new Node(toRemove));
    }


//    todo found online and needs to be changed and checked
    private void remove(Node node, Node toRemove){
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





// probably needed to splay after finding or doing something
    private void splay(){

    }




    public Node find(String toFind){
        return find(root, new Node(toFind));
    }

    private Node find(Node node, Node toFind){

    }

    */
/*todo needs to be written out*//*

    public boolean isBST(){
        return isBst(root);
    }

    private boolean isBst(Node node){

    }

}
*/
