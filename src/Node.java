
public class Node implements Comparable<Node>{
    private Element element;

    private Node leftLink;
    private Node rightLink;

    int height;




    public Node(String file, String word) {
        element = new Element(file, word);
        height = 0;
    }



    @Override
    public int compareTo(Node other) {
//        if (other == null){
//            return 0;
//        }
        return element.compareTo(other.getData());

    }



    public Element getElement () {
        return element;
    }

    public String getData(){
        return element.getData();
    }

    public Node getLeft () {
        return leftLink;
    }


    public Node getRight () {
        return rightLink;
    }


    public void setElement (String target){
        element.setData(target);
    }


    public void setLeft (Node node) {
        leftLink = node;
    }


    public void setRight (Node node) {
        rightLink = node;
    }

    // this portion is just for the avl nodes
    private int height( Node t ){
        return t == null ? -1 : t.height;
    }

    @Override
    public String toString() {
        return "Node:" + "\n" +
                "\t"+ "element= " + element.getData() + "\n" +

//                if left link is not null put in leftLink.getData(): else put in "null" for the data

                "\t" + "leftLink= " + (leftLink != null ? leftLink.getData() : "null") + "\n" +
                "\t" + "rightLink= " + (rightLink != null ? rightLink.getData() : "null") + "\n";
    }
}