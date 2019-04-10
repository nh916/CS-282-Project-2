public class SplayTree extends BST{
    public Node root;

    public SplayTree() {
        root = null;
    }

    public void insertSplay(String value){
        if(root == null){
            root = new Node(value);
            return;
        }


        root =  splay(root, value);
        int cmp =  value.compareTo(root.getData());
        if(cmp < 0){
            Node temp = new Node(value);
            temp.setLeft(root.getLeft());
            temp.setRight(root);
            root.setLeft(null);
            root = temp;
        }
        else{
            Node temp = new Node(value);
            temp.setRight(temp.getRight());
            temp.setLeft(root.getRight());
            root.setRight(null);
            root = temp;

        }


    }
    public void delete(String delValue){
        if(root == null) return; //empty tree

        root = splay(root, delValue); // brings deleted value up to root

        int cmp = delValue.compareTo(root.getData());
        if(cmp == 0){
            if(root.getLeft() == null) root = root.getRight();
            else{
                Node newRoot = root.getRight();
                root = root.getLeft();
                splay(root,delValue);
                root.setRight(newRoot);
            }
        }
    }

    public String findSplay(String value){
        root = splay(root,value);
        String returnStatement = " The value does not exist within the tree";
        int cmp = value.compareTo(root.getData());
        if(cmp == 0) return root.getData();
        else return returnStatement;




    }


    private Node splay(Node n, String value){
        if(n == null) return null;

        int cmp1 = value.compareTo(n.getData());
        if(cmp1 < 0) {
            //value not in tree, so done
            if (n.getLeft() == null) return n;

            int cmp2 = value.compareTo(n.getLeft().getData());
            if (cmp2 < 0) {
                n.getLeft().setLeft(splay(n.getLeft().getLeft(),value));
                n = rotateRight(n.getRight());
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

            int cmp2 = value.compareTo(n.getRight().getData());
            if(cmp2 < 0){
                n.getRight().setLeft(splay(n.getRight().getLeft(),value));

                if(n.getRight().getLeft() != null) n.setRight(rotateRight(n.getRight()));

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
        temp.setLeft(n);
        return temp;

    }

    public static void main(String[] args){
        SplayTree splay = new SplayTree();
        splay.insertSplay("tree");
        splay.insertSplay("apple");
        splay.insertSplay("test");
        splay.insertSplay("co");
        splay.insertSplay("ji");








    }

}
