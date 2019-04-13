public class SplayTree extends AVLTree{

    private Node root;


    public SplayTree() {

    }

//    Node newNode = null;


    public void insertSplay(String value){
        insertSplay(new Node(value));
    }

    private void insertSplay(Node value){
        if(root == null){
            root = value;
            return;
        }

        root =  splay(root, value);

        int cmp =  value.compareTo(root);

        if(cmp < 0){
            Node temp = value;
            temp.setLeft(root.getLeft());
            temp.setRight(root);
            root.setLeft(null);
            root = temp;
        }

//        loses right link here
        else if(cmp>0){
            Node temp = value;
//            temp.setRight(temp.getRight());
            temp.setRight(root.getRight());
            temp.setLeft(root);
            root.setRight(null);
            root = temp;

        }
        else root.setElement(value.getData());
    }

    public void delete(String toDelete){
        delete(new Node(toDelete));
    }


    private void delete(Node delValue) {
        Node newTree;

        // If x is found, it will be at the root
        root = splay(root,delValue);
        if( root.compareTo( delValue ) != 0 )
            return;   // Item not found; do nothing

        if( root.getLeft() == null )
            newTree = root.getRight();
        else
        {
            // Find the maximum in the left subtree
            // Splay it to the root; and then attach right child
            newTree = root.getLeft();
            newTree = splay(newTree,delValue );
            newTree.setRight(root.getRight());
        }
        root = newTree;
    }



    public Node find(String toFind){
        return findSplay(new Node(toFind));
    }


    private Node findSplay(Node value){

        root = splay(root,value);
//        String returnStatement = " The value does not exist within the tree";
        int cmp = value.compareTo(root);
        if(cmp == 0){
            return root;
        }
//        else {
            return null;
//        }

    }

    //    private Node header = new Node( null ); // For splay
    private Node splay(Node n, Node value){
        /*Node leftTreeMax, rightTreeMin;

        header.setLeft(nullNode);
        header.setRight(nullNode);
        leftTreeMax = rightTreeMin = header;
        for( ; ; )
        {
            int compareResult = value.compareTo(n.getData() );

            if( compareResult < 0 )
            {
                if( value.compareTo( n.getLeft().getData() ) < 0 )
                    n = rotateLeft(n);
                if( n.getLeft() == null )
                    break;
                // Link Right
                rightTreeMin.setLeft(n);
                rightTreeMin = n;
                n = n.getLeft();
            }
            else if( compareResult > 0 )
            {
                if( value.compareTo( n.getRight().getData() ) > 0 )
                    n = rotateRight(n);
                if( n.getRight() == null )
                    break;
                // Link Left
                leftTreeMax.setRight(n);
                leftTreeMax = n;
                n = n.getRight();
            }
            else
                break;
        }

        leftTreeMax.setRight(n.getLeft());
        rightTreeMin.setLeft(n.getRight());
        n.setLeft(header.getRight());
        n.setRight(header.getLeft());
        return n;*/

        if(n == null) return null;

        int cmp1 = value.compareTo(n);

        if(cmp1 < 0) {
            //value not in tree, so done
            if (n.getLeft() == null) return n;

            int cmp2 = value.compareTo(n.getLeft());

            if (cmp2 < 0) {
                n.getLeft().setLeft(splay(n.getLeft().getLeft(),value));
                n = rotateRight(n);
            }
            else if (cmp2 > 0) {
                n.getLeft().setRight(splay(n.getLeft().getRight(),value));
                if (n.getLeft().getRight() != null)
                    n.setLeft(rotateLeft(n.getLeft()));

            }
            if(n.getLeft() == null) return n;
            else return rotateRight(n);
        }
        else if(cmp1 > 0){
            if(n.getRight() == null) return n;

            int cmp2 = value.compareTo(n.getRight());
            if(cmp2 < 0){
                n.getRight().setLeft(splay(n.getRight().getLeft(),value));

                if(n.getRight().getLeft() != null){
                    n.setRight(rotateRight(n.getRight()));
                }

            }
            else if(cmp2 > 0){
                n.getRight().setRight(splay(n.getRight().getRight(),value));
                n = rotateLeft(n);


            }

            if(n.getRight() == null) return n;
            else return rotateLeft(n);

        }
        else return n;


    }


    private Node rotateLeft(Node n){
        Node temp = n.getRight();
        n.setRight(temp.getLeft());
        temp.setLeft(n);
        return temp;
    }

    private Node rotateRight(Node n){
        Node temp =  n.getLeft();
        n.setLeft(temp.getRight());
        temp.setRight(n);
        return temp;

    }

//    private void inOrderSplay(Node n){
//        if(n == null) return;
//        inOrderSplay(n.getLeft());
//        System.out.print(n.getData() + " ");
//        inOrderSplay(n.getRight());
//    }


//    for testing
    public void jump(){
        return;
    }



    public static void main(String[] args){
        SplayTree tree2 = new SplayTree();
//        String cases = "LL";
//
//        switch (cases) {
//            case "LL":
//                tree2.insertSplay("C");
//                tree2.insertSplay("B");
//                tree2.insertSplay("A");
//                break;
//            case "RR":
//                tree2.insertSplay("A");
//                tree2.insertSplay("B");
//                tree2.insertSplay("C");
//
//                break;
//            case "LR":
//                tree2.insertSplay("C");
//                tree2.insertSplay("A");
//                tree2.insertSplay("B");
//
//                break;
//            case "RL":
//                tree2.insertSplay("A");
//                tree2.insertSplay("C");
//                tree2.insertSplay("B");
//                break;
//            default:
//                System.out.println("hit the else case!");
//                break;
//        }
//
//        tree2.jump();

        tree2.insert("a");
        tree2.insert("b");
        tree2.insert("c");


    }




}
