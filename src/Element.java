public class Element implements Comparable<String> {

    private String data;

    public Element (String data){
        this.data = data;
    }


//    @Override
//    public int compareTo(String element){
////        if the new element is bigger return 1
//        if (data.compareTo(element) > 0){
//            return 1;
//        }
////        if new element is smaller return 2
//        else if (data.compareTo(element) < 0){
//            return -1;
//        }
////        if its equal to the element return 0
//        else {
//            return 0;
//        }
//    }

    @Override
    public int compareTo(String element){
        return data.compareTo(element);
    }


/*    @Override
    public int compareTo(E element){
        Element temp = (Element) element;
        if ()
    }*/


    public void setData(String newData){
        this.data = newData;
    }

    public String getData(){
        return data;
    }

    @Override
    public String toString() {
        return "" + data;
    }

}
