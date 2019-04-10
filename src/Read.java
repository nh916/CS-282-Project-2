import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read {

    private BST bst;
    private AVLTree avlTree;
    private SplayTree splayTree;


    private String file1;
    private String file2;
    private String file3;
    private String file4;


    public Read() {
        file1 = "file1.txt";
        file2 = "file2.txt";
        file3 = "file3.txt";
        file4 = "file4.txt";
        bst = new BST();
        avlTree = new AVLTree();
        splayTree = new SplayTree();
    }


    public void readAndInsertToTrees(){
        Scanner scan = null;
        String wordFromFile;

        try {

//            todo duplicate code?
            scan = new Scanner(new FileInputStream(file1));
            while (scan.hasNext()) {
                wordFromFile = (scan.nextLine());
                bst.insert( wordFromFile);
                avlTree.insert(wordFromFile);

                splayTree.insertSplay(wordFromFile);
            }

            scan = new Scanner(new FileInputStream(file2));
            while (scan.hasNext()) {
                wordFromFile = (scan.nextLine());
                bst.insert( wordFromFile);
                avlTree.insert( wordFromFile);
                splayTree.insertSplay(wordFromFile);
            }

            scan = new Scanner(new FileInputStream(file3));
            while (scan.hasNext()) {
                wordFromFile = (scan.nextLine());
                bst.insert( wordFromFile);
                avlTree.insert( wordFromFile);
                splayTree.insertSplay(wordFromFile);
            }

            scan = new Scanner(new FileInputStream(file4));
            while (scan.hasNext()) {
                wordFromFile = (scan.nextLine());
                bst.insert(wordFromFile);
                avlTree.insert(wordFromFile);
                splayTree.insertSplay(wordFromFile);
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



//// method that takes all the data gathered int the ArrayList of words and inserts them into the trees
//    public void insertDataFromFile(){
//        BST bst = new BST();
//        AVLTree avlTree = new AVLTree();
////        SplayTree splayTree = new SplayTree();
//
//        /*todo whats gonna happen to the duplicates. how do i store them? a number perhaps saying how many there are or an ArrayList in the node*/
//        for (int i = 0; i < fileData.size(); i++) {
//            bst.insert(fileData.get(i));
//            avlTree.insert(fileData.get(i));
////            splayTree.insert(fileData.get(i));
//        }
//    }


    public static void main(String[] args){
        Read read = new Read();
        read.readAndInsertToTrees();

    }


}
