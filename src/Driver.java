import java.util.Scanner;

public class Driver {

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



    private void select(String typeOfTree) {
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


    private void BST(){

    }

    private void avl(){

    }

    private void splay(){

    }




    private void help(){
        System.out.println("your options are: ");
        System.out.println("select (select the type of tree)");
        System.out.println("find");
        System.out.println("insert");
        System.out.println("delete");
        System.out.println("quit");
    }


    private void options(){
        System.out.println("what would you like to do?");
        String choice = input.nextLine();


        while (!choice.equals("quit")){
            switch (choice){

                case ("help"):{
                    help();
                    break;
                }


                case ("select"):{
                    System.out.println("type of tree");
                    String typeOfTree = input.nextLine();
                    select(typeOfTree);
                    break;
                }

                case ("insert"):{
                    System.out.println("word?");
                    String wordToInsert;
                    wordToInsert = input.nextLine();

                    if (wantsBST){
                        bst.insert(wordToInsert);
                    }
                    else if (wantsAVL){
                        avlTree.insert(wordToInsert);
                    }
                    else if (wantsSplay){
                        splayTree.insertSplay(wordToInsert);
                    }
                    else {
                        defaultCase();
                    }

                }

                case ("delete"):{
                    System.out.println("word?");
                    String wordToDelete;
                    wordToDelete = input.nextLine();

                    try {
                        if (wantsBST){
                            bst.deleteKey(wordToDelete);
                        }
                        else if (wantsAVL){
                            avlTree.delete(wordToDelete);
                        }
                        else if (wantsSplay){
                            splayTree.delete(wordToDelete);
                        }
                        else {
                            defaultCase();
                        }
                    }
                    catch (NullPointerException e){
                        System.out.println("Null pointer!!");
                    }
                    catch (Exception e){
                        System.out.println("you have produced an exception congratulations");
                    }

                }

                case ("find"): {
                    System.out.println("word?");
                    String wordToFind;
                    wordToFind = input.nextLine();

                    try {
                        if (wantsBST){
                            bst.find(wordToFind);
                        }
                        else if (wantsAVL){
                            avlTree.find(wordToFind);
                        }
                        else if (wantsSplay){
                            splayTree.findSplay(wordToFind);
                        }
                        else {
                            defaultCase();
                        }
                    }

//                which exception would it be
                    catch (NullPointerException e){
                        System.out.println("what you were looking for created a null pointer");
                    }
                    catch (Exception e ){
                        System.out.println("Exception");
                    }

                }

                default:{
                    defaultCase();
                }
            }
        }
    }


    public static void main(String[] args){
        Driver driver = new Driver();
//
//        Read read = new Read("file1.txt", "file2.txt", "file3.txt", "file4.txt");

        driver.options();
    }
}
