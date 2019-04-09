public class Element implements Comparable<String> {

    private String word;
    private String file;

    public Element (String file, String word){
        this.file = file;
        this.word = word;
    }



    @Override
    public int compareTo(String element){
        return word.compareTo(element);

    }


    public void setData(String newData){
        this.word = newData;
    }

    public String getWord(){
        return word;
    }

    public String getFile(){
        return file;
    }

    @Override
    public String toString() {
        return word + "from " + file;
    }

}