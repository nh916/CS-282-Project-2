public class AVLTree {

    Node root;
    int height;

    public AVLTree(){
        height = 0;
    }

    private int height( Node t ){
        if (t == null){
            return 0;
        }
//        return t == null ? -1 : t.height;
        return t.height;
    }

    public void insert(String toInsert){
        insert(root, new Node(toInsert));
    }


    private Node insert(Node node, Node toInsert){
        if( node == null ){
            return new Node(toInsert.getData());
        }

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

    private Node balance( Node node ){
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


    private Node rotateWithLeftChild( Node k2 ){
//        be sure these make any kind of sense or if the names should be changed because of current element class
        Node k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.height = Math.max(height(k2.getLeft()), height(k2.getRight())) + 1;
        k1.height = Math.max(height(k1.getLeft()), k2.height) + 1;
        return k1;
    }


    private Node doubleWithLeftChild(Node k3){
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }

    private Node remove(Node t, String toRemove){
        if( t == null ){
            return t; // Item not found; do nothing
        }

        if(toRemove.compareTo(t.getData()) < 0){
            t.setLeft(remove(t.getLeft(), toRemove));
        }
        else if(toRemove.compareTo(t.getData()) > 0){
            t.setRight(remove(t.getRight(), toRemove));
        }

// Two children
        else if( t.getLeft() != null && t.getRight() != null ){
            t.setElement(findMin(t.getRight()).element);
            t.setRight(remove(t.element, t.getRight()));
        }
        else {
            t = ( t.getLeft() != null ) ? t.getLeft() : t.getRight();
        }
        return balance(t);
    }





















}










