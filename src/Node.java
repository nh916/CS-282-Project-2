/*
Naivd Hariri
David
*/
public class Node implements Comparable<Node>{
    private Element element;

    private Node leftLink;
    private Node rightLink;

    public int height;


    public Node(String target) {
        element = new Element(target);
        height = 0;
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

// this portion is just for the avl nodes
    public void AVLHeight(){

    }

    @Override
    public String toString() {
        return "Node:" + "\n" +
                "\t"+ "element= " + element.getData() + "\n" +
                "\t" + "leftLink= " + leftLink.getData() + "\n" +
                "\t" + "rightLink= " + rightLink.getData() + "\n";
    }
}