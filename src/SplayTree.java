public class SplayTree extends BST{

    Node root;

    public SplayTree(){
        root = new Node(null);
    }



    private Node header = new Node( null ); // For splay
    private Node newNode = null;  // Used between different inserts


    public Node insert( String x ){
        if( newNode == null ) {
            newNode = new Node(null);
        }
        newNode.setElement(x);

        if( root == nullNode ) {
            newNode.left = newNode.right = nullNode;
            root = newNode;
        }
        else {
            root = splay( x, root );

            int compareResult = x.compareTo( root.getData() );

            if( compareResult < 0 ) {
                newNode.setLeft(root.getLeft());
                newNode.setRight(root);
                root.setLeft(nullNode);
                root = newNode;
            }
            else
            if( compareResult > 0 ) {
                newNode.setRight(root.getRight());
                newNode.setLeft(root);
                root.setRight(nullNode);
                root = newNode;
            }
            else
                return;   // No duplicates
        }
        newNode = null;   // So next insert will call new
    }


    @Override
    public Node find(String toFind){
        return super.find(toFind);
    }


    public void remove(String x) {
        Node newTree;

        // If x is found, it will be at the root
        root = splay( x, root );
        if(root.getData().compareTo( x ) != 0)
            return;   // Item not found; do nothing

        if(root.getLeft() == nullNode)
            newTree = root.getRight();
        else {
            // Find the maximum in the left subtree
            // Splay it to the root; and then attach right child
            newTree = root.getLeft();
            newTree = splay( x, newTree );
            newTree.setRight(root.getRight());
        }
        root = newTree;
    }





    public void delete(String toDelete){
        super.deleteKey(toDelete);
    }




    public static void main(String[] args){
        SplayTree splayTree= new SplayTree();


    }






}