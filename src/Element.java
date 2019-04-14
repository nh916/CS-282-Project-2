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

    public boolean getFile1() {
        return file1;
    }

    public boolean getFile2() {
        return file2;
    }

    public boolean getFile3() {
        return file3;
    }

    public boolean getFile4() {
        return file4;
    }


    public void setFile1(boolean file1) {
        this.file1 = file1;
    }

    public void setFile2(boolean file2) {
        this.file2 = file2;
    }

    public void setFile3(boolean file3) {
        this.file3 = file3;
    }

    public void setFile4(boolean file4) {
        this.file4 = file4;
    }




    @Override
    public String toString() {
        return "" + data + " is in " + (file1 ? "file 1 " : "") + (file2 ? "file 2 " : "") + (file3 ? "file 3 " : "") + (file4 ? "file 4 " : "");
    }






}
