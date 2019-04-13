
public class Element implements Comparable<String> {

    private String data;

    public Element (String data){
        this.data = data;
    }


    @Override
    public int compareTo(String element){
        return data.compareTo(element);
    }



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
