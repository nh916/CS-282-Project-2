
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

    public String getWord(){
        return element.getWord();
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
                "\t"+ "element= " + element.getWord() + "\n" +

//                if left link is not null put in leftLink.getData(): else put in "null" for the data
// lets come back and add the file to this node toString as well

                "\t" + "leftLink= " + (leftLink != null ? leftLink.getWord() : "null") + "\n" +
                "\t" + "rightLink= " + (rightLink != null ? rightLink.getWord() : "null") + "\n";
    }
}