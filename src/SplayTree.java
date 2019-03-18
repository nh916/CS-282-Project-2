public class SplayTree {
    Node root;

    public SplayTree(){
        root = null;
    }

    public void insert(String toInsert){
        insert(root, new Node(toInsert));
    }

    private void insert(Node node, Node toInsert){
        if (node == null){
            node = toInsert;
            return;
        }

    }

    public void remove(String toRemove){
        remove(root, new Node(toRemove));
    }

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










    public Node find(){

    }


}
