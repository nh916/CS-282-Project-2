/*
Navid Hariri
David
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {


    public ArrayList <String> fileName;
    public ArrayList<String> fileData;


    public Read(String file1, String file2, String file3, String file4){
//        initialize ArrayList
        fileData = new ArrayList<String>();

//        initialize ArrayList
        fileName = new ArrayList<String>();

//        add all files to ArrayList
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
            }
            catch (FileNotFoundException e) {
//            e.printStackTrace();
                System.out.println("file not found");
            }
            catch (NullPointerException e) {
                System.out.println("file error");
            }
            finally {
                try {
                    scan.close();
                }
                catch (NullPointerException e) {
                    System.out.println("file was never opened or closed");
                }

            }
        }
//        System.out.println(fileData);
    }

// method that takes all the data gathered int the ArrayList of words and inserts them into the trees
    public void insert(){

    }

    public static void main(String[] args){
        /*the Read class requires at least 4 files but you can later add more if needed
        because fileName linkedList is public
        you can just add it to the linkedList if needed*/

        Read read = new Read("file1.txt", "file2.txt", "file3.txt", "file4.txt");

        read.loadData();
//        System.out.println(read.fileData);
//        System.out.println(read.fileData.size());
    }







}
