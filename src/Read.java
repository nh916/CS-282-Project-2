import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Read {


    public LinkedList <String> fileName;
    public ArrayList<String> fileData;


    public Read(String file1, String file2, String file3, String file4){
        fileData = new ArrayList<String>();

        fileName = new LinkedList<String>();
        fileName.add(file1);
        fileName.add(file2);
        fileName.add(file3);
        fileName.add(file4);
    }


    public void loadData(){
        Scanner scan = null;

        for (int i = 0; i <fileName.size(); i++) {
            try {
                scan = new Scanner(new FileInputStream(fileName.get(i)));
                while (scan.hasNext()) {
                    fileData.add(scan.nextLine());
                }
            } catch (FileNotFoundException e) {
//            e.printStackTrace();
                System.out.println("file not found");
            } catch (NullPointerException e) {
                System.out.println("file error");
            } finally {
                try {
                    scan.close();
                } catch (NullPointerException e) {
                    System.out.println("file was never opened or closed");
                }

            }
        }
        System.out.println(fileData);
    }

    public static void main(String[] args){
        Read read = new Read("file1.txt", "file2.txt", "file3.txt", "file4.txt");

        read.loadData();
        System.out.println(read.fileData.size());
    }







}
