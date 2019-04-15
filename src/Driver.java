import java.util.Scanner;

public class Driver extends Read {

    private AVLTree avlTree;
    private SplayTree splayTree;
    private BST bst;

    private Scanner input;

    private boolean wantsBST;
    private boolean wantsAVL;
    private boolean wantsSplay;


    public Driver(){
        avlTree =  new AVLTree();
        splayTree = new SplayTree();
        bst = new BST();

        input = new Scanner(System.in);

        wantsBST = false;
        wantsAVL = false;
        wantsSplay = false;
    }



    private void select() {
        System.out.println("type of tree");
        String typeOfTree = input.nextLine();

        switch (typeOfTree) {

            case ("BST"): {
                wantsBST = true;
                wantsAVL = false;
                wantsSplay = false;
                break;
            }
            case ("AVL"): {
                wantsBST = false;
                wantsAVL = true;
                wantsSplay = false;
                break;
            }
            case ("Splay"): {
                wantsBST = false;
                wantsAVL = false;
                wantsSplay = true;
                break;
            }
            default: {
                defaultCase();
                break;
            }
        }
    }



    private void defaultCase(){
        System.out.println("Not a valid choice. Please try again.");
    }


//    private void BST(){
//
//    }
//
//    private void avl(){
//
//    }
//
//    private void splay(){
//
//    }




    private void help(){
        System.out.println("your options are: ");
        System.out.println("select (select the type of tree)");
        System.out.println("find");
        System.out.println("insert");
        System.out.println("delete");
        System.out.println("quit");
    }


    private void options(){
        String choice;

        boolean flag = true;

        while (flag){

            System.out.println("what would you like to do?");
            choice = input.nextLine();

            switch (choice){

                case ("help"):{
                    help();
                    break;
                }


                case ("select"):{
                    select();
                    break;
                }

                case ("insert"):{
                    String filesToInsertInto;
                    boolean file1 = false;
                    boolean file2 = false;
                    boolean file3 = false;
                    boolean file4 = false;

//                    String files[] = new String[4];
                    System.out.println("Which file?");
                    filesToInsertInto = input.nextLine();
                    String[] files = filesToInsertInto.split(",");

                    for (int i = 0; i < files.length; i++) {
                        switch (files[i]) {
                            case "1":
                                file1 = true;
                                break;
                            case "2":
                                file2 = true;
                                break;
                            case "3":
                                file3 = true;
                                break;
                            case "4":
                                file4 = true;
                                break;
                            default:
                                System.out.println("hit the else case in the if statement for files");
                                break;
                        }
                    }

                    System.out.println("word?");
                    String wordToInsert;
                    wordToInsert = input.nextLine();

                    if (wantsBST){
                        bst.insert(file1, file2, file3, file4, wordToInsert);
                        break;
                    }
                    else if (wantsAVL){
                        avlTree.insert(file1, file2, file3, file4, wordToInsert);
                        break;
                    }
                    else if (wantsSplay){
                        splayTree.insertSplay(file1, file2, file3, file4, wordToInsert);
                        break;
                    }
                    else if (!wantsBST && !wantsAVL && !wantsSplay){
                        System.out.println("please select tree!!!!");
                        select();
                        break;
                    }
                    else {
                        defaultCase();
                        break;
                    }

                }

                case ("delete"):{
                    boolean file1 = true;
                    boolean file2 = true;
                    boolean file3 = true;
                    boolean file4 = true;
                    String filesToDeleteFrom;

                    System.out.println("word?");
                    String wordToDelete;
                    wordToDelete = input.nextLine();

                    System.out.println("Which file?");
                    filesToDeleteFrom = input.nextLine();

                    String[] files = filesToDeleteFrom.split(",");

                    for (int i = 0; i < files.length; i++) {
                        switch (files[i]) {
                            case "1":
                                file1 = false;
                                break;
                            case "2":
                                file2 = false;
                                break;
                            case "3":
                                file3 = false;
                                break;
                            case "4":
                                file4 = false;
                                break;
                            default:
                                System.out.println("hit the else case in the if statement for files");
                                break;
                        }
                    }


                    try {
                        if (wantsBST){
                            bst.deleteKey(file1, file2, file3, file4, wordToDelete);
                            break;
                        }
                        else if (wantsAVL){
                            avlTree.delete(file1, file2, file3, file4, wordToDelete);
                            break;
                        }
                        else if (wantsSplay){ //todo currently not fixed for splay
                            splayTree.delete(wordToDelete);
                            break;
                        }
                        else if (!wantsBST && !wantsAVL && !wantsSplay){
                            System.out.println("please select tree!!!!");
                            select();
                        }
                        else {
                            defaultCase();
                            break;
                        }
                    }
                    catch (NullPointerException e){
                        System.out.println("Null pointer!!");
                        break;
                    }
                    catch (Exception e){
                        System.out.println("you have produced an exception congratulations");
                        break;
                    }

                }

                case ("find"): {
                    System.out.println("word?");
                    String wordToFind;
                    wordToFind = input.nextLine();

                    try {
                        if (wantsBST){
                            if (bst.find(wordToFind) == null){
                                System.out.println("word not found");
                                break;
                            }
                            else if (bst.find(wordToFind).equals(wordToFind)){
                                System.out.println(bst.find(wordToFind));
                                break;
                            }
                            else {
                                System.out.println("something went wrong in BST");
                            }
                        }
                        else if (wantsAVL){
                            if (avlTree.find(wordToFind) == null){
                                System.out.println("word not found");
                                break;
                            }
                            else if (avlTree.find(wordToFind).equals(wordToFind)) {
                                System.out.println(avlTree.find(wordToFind));
                                break;
                            }
                            else {
                                System.out.println("something went wrong in find AVL");
                                break;
                            }
                        }
                        else if (wantsSplay){
                            if (splayTree.find(wordToFind) == null){
                                System.out.println("word not found");
                                break;
                            }
                            else if (splayTree.find(wordToFind).equals(wordToFind)){
                                System.out.println(splayTree.find(wordToFind));
                                break;
                            }
                            else {
                                System.out.println("something went wrong in find SPLAY");
                                break;
                            }
                        }
                        else if (!wantsBST && !wantsAVL && !wantsSplay){
                            System.out.println("please select tree!!!!");
                            select();
                        }
                        else {
                            defaultCase();
                            break;
                        }
                    }

//                which exception would it be
                    catch (NullPointerException e){
                        System.out.println("what you were looking for created a null pointer");
                        break;
                    }
                    catch (Exception e ){
                        System.out.println("Exception");
                        break;
                    }

                }

                case ("quit"): {
                    flag = false;
                    break;
                }

                default:{
                    defaultCase();
                    break;
                }
            }
        }
    }


    public static void main(String[] args){
        Driver driver = new Driver();
// not inserting into the tree into
        driver.readAndInsertToTreesWithFile();
        driver.options();
    }
}
