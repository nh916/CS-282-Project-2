public class Node implements Comparable<Node>{
    private Element element;

    private Node leftLink;
    private Node rightLink;

    int height;

    public Node(boolean file1, boolean file2, boolean file3, boolean file4, String data) {
        element = new Element(file1, file2, file3, file4, data);
        height = 0;
    }

    public Node(String data){
        element = new Element(data);
    }


    @Override
    public int compareTo(Node other) {
//        todo might be able to release it from here!
        if (other == null){
            return 0;
        }
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

//        if (node == null){
//            rightLink = null;
//        }
    }


    public boolean getFile1(){
        return element.file1;
    }

    public boolean getFile2(){
        return element.file2;
    }

    public boolean getFile3(){
        return element.file3;
    }

    public boolean getFile4(){
        return element.file4;
    }

    public void setFile1(boolean file1){
        element.file1 = file1;
    }

    public void setFile2(boolean file2){
        element.file2 = file2;
    }

    public void setFile3(boolean file3){
        element.file3 = file3;
    }

    public void setFile4(boolean file4){
        element.file4 = file4;
    }





    @Override
    public String toString() {
        return "Node:" + "\n" +
                "\t"+ "element= " + element.getData() + "\n" +
//                if left link is not null put in leftLink.getData(): else put in "null" for the data
                "\t" + "leftLink= " + (leftLink != null ? leftLink.getData() : "null") + "\n" +
                "\t" + "rightLink= " + (rightLink != null ? rightLink.getData() : "null") + "\n" +
                "\t" + "files= " + element.toString();
        //        return element.toString();
    }
}