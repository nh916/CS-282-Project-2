public class AVLTree {

    Node root;

    public AVLTree(){

    }

    public void insert(String toInsert){
        insert(root, new Node(toInsert));
    }


    private Node insert(Node node, Node toInsert){
        if( node == null ){
            new Node(toInsert.getData());
        }
//        int compareResult = x.compareTo( t.element );

        if( node.compareTo(toInsert) < 0 ){
//            node.getLeft() = insert( x, t.left );
            node.setLeft(insert(node.getLeft(), toInsert));
        }
        else if( node.compareTo(toInsert) > 0 ){
//            t.right = insert( x, t.right );
            node.setRight(insert(node.getRight(), toInsert));
        }
        else{
             // Duplicate; do nothing
//            return balance( t );
//            return toInsert;
        }
//        todo becareful here! is this really null or something else?
        return null;
    }

/*    private void insert(Node node, Node toInsert){

    }*/

    public void delete(String toDelete){

    }


}
