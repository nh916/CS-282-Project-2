public class Element implements Comparable<String> {

    private String data;
//    boolean[] whichFileWordIsIn;

    boolean file1;
    boolean file2;
    boolean file3;
    boolean file4;

    public Element (boolean file1, boolean file2, boolean file3, boolean file4, String data){
        this.data = data;

        this.file1 = file1;
        this.file2 = file2;
        this.file3 = file3;
        this.file4 = file4;

    }

    public Element(String data){
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
        return "" + data + " is in " + (file1 ? "file 1 " : "") + (file2 ? "file 2 " : "") + (file3 ? "file 3 " : "") + (file4 ? "file 4 " : "");
    }






}
