import java.util.Scanner;

public class Driver {

    AVLTree avlTree;
    SplayTree splayTree;
    BST bst;
    Scanner in;
    String typeOfTree;

    public Driver(){
        avlTree =  new AVLTree();
        splayTree = new SplayTree();
        bst = new BST();
        in = new Scanner(System.in);
    }


    private void insert(){
        Scanner input = new Scanner(System.in);

        System.out.println("Word?");
        String insertThisWord = input.nextLine();

        switch (typeOfTree){
            case ("AVL"):{
                avlTree.insert(insertThisWord);
            }
            case ("Splay"):{
                splayTree.insert(insertThisWord);
            }
            case ("BST"):{
                bst.insert(insertThisWord);
            }
            default:{
                System.out.println("That tree does not exist");
            }

        }

    }


    private void delete(){
        Scanner input = new Scanner(System.in);

        System.out.println("Word?");
        String deleteThisWord = input.nextLine();

        switch (typeOfTree){
            case ("AVL"):{
                try {
                    avlTree.delete(deleteThisWord);
                }
                catch (Exception e){
                    System.out.println("err");
                }
            }
            case ("Splay"):{
                try {
                    splayTree.delete(deleteThisWord);
                }
                catch (Exception e ){
                    System.out.println("err");
                }
            }
            case ("BST"):{
                try {
                    bst.deleteKey(deleteThisWord);
                }
                catch (Exception e){
                    System.out.println("err");
                }
            }
            default:{
                System.out.println("That tree does not exist");
            }

        }

    }


    private void find() {
        Scanner input = new Scanner(System.in);

        System.out.println("Word?");
        String findThisWord = input.nextLine();

        switch (typeOfTree){
            case ("AVL"):{
                try {
                    avlTree.find(findThisWord);
                }
                catch (Exception e){
                    System.out.println("err");
                }
            }
            case ("Splay"):{
                try {
                    splayTree.find(findThisWord);
                }
                catch (Exception e ){
                    System.out.println("err");
                }
            }
            case ("BST"):{
                try {
                    bst.find(findThisWord);
                }
                catch (Exception e){
                    System.out.println("err");
                }
            }
            default:{
                System.out.println("That tree does not exist");
            }

        }

    }


    private void help(){
        System.out.println("your options are: ");
        System.out.println("select (select the type of tree)");
        System.out.println("find");
        System.out.println("insert");
        System.out.println("delete");
        System.out.println("quit");
    }


//    this might possibly call for a switch statement of menus
    public void options(){
        Scanner input = new Scanner(System.in);
        System.out.println("what would you like to do?");
        String choice = input.nextLine();

        switch (choice){

            case ("help"):{
                help();
                break;
            }

            case ("select"):{
                System.out.println("type of tree");
                String typeOfTree = in.nextLine();
            }

            case ("insert"):{
                insert();
            }

            case ("delete"):{
                delete();
            }

            case ("find"): {
                find();
            }

            case ("quit"):{
                System.exit(0);
//                flag = false;
            }

            default:{
                System.out.println("Not a valid choice. Please try again.");
            }
        }



    }


    public static void main(String[] args){
        BST binarySearchTree = new BST();
        AVLTree avlTree = new AVLTree();
//        SplayTree splayTree = new SplayTree();

        Read read = new Read("file1.txt", "file2.txt", "file3.txt", "file4.txt");
    }
}
