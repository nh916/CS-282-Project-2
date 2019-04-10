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


    protected void readThenInsert(String file){
        Scanner scan = null;
        String wordFromFile;

        try{
            scan = new Scanner(new FileInputStream(file));
            while (scan.hasNext()) {
                wordFromFile = (scan.nextLine());
                bst.insert(wordFromFile);
                avlTree.insert(wordFromFile);
                splayTree.insertSplay(wordFromFile);
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        catch (NullPointerException e) {
            System.out.println("file error");
        }
        finally {
            if (scan != null) {
                scan.close();
            }
        }
    }


    public void readAndInsertToTreesWithFile(){
        readThenInsert(file1);
        readThenInsert(file2);
        readThenInsert(file3);
        readThenInsert(file4);
    }

//    testing
    public static void main(String[] args){
        Read read = new Read();
        read.readAndInsertToTreesWithFile();
    }

}
