/*
Naivd Hariri
David
*/
public class Node implements Comparable<Node>{
    private Element element;

    private Node leftLink;
    private Node rightLink;


    public Node(String target) {
        element = new Element(target);
    }



    @Override
    public int compareTo(Node other) {
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



    @Override
    public String toString() {
        return "BSTNode:" + "\n" +
                "\t"+ "element=" + element.getData() + "\n" +
                "\t" + "leftLink=" + leftLink.getData() + "\n" +
                "\t" + "rightLink=" + rightLink.getData() + "\n";
    }
}