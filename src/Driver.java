import java.util.Scanner;

public class Driver {

    AVLTree avlTree;
    SplayTree splayTree;
    BST bst;

    public Driver(){
        avlTree =  new AVLTree();
        splayTree = new SplayTree();
        bst = new BST();
    }




    private void insert(){
        Scanner input = new Scanner(System.in);

        System.out.println("Which file?");
//        this part is not working. i dont know how to only get those files and then only load those file data into the arraylist
        String insertThisFile = input.nextLine();

        System.out.println("word");
        String insertThis = input.nextLine();
//        insertion is not done yet???
        System.out.println("Insertion Done");


        System.out.println("what tree would you like to insert " + insertThis + " into?");
        System.out.println("type \"AVL\" for just AVL tree");
        System.out.println("type \"Splay\" for just Splay tree");
        System.out.println("type \"BST\" for just BST");
        System.out.println("type \"ALL\" to insert into all three trees");

        String insertIntoThisTree = input.nextLine();

        switch (insertIntoThisTree){
            case ("AVL"):{
                avlTree.insert(insertThis);
                break;
            }
            case ("Splay"):{
                splayTree.insert(insertThis);
                break;
            }
            case ("BST"):{
                bst.insert(insertThis);
                break;
            }
            case ("All"):{
                avlTree.insert(insertThis);
                splayTree.insert(insertThis);
                bst.insert(insertThis);
                break;
            }
        }
    }


    private void delete(){
        Scanner input = new Scanner(System.in);
        System.out.println("Word?");
        String deleteThis = input.nextLine();

        System.out.println("what tree would you like to delete " + deleteThis + " from?");
        System.out.println("type \"AVL\" for just AVL tree");
        System.out.println("type \"Splay\" for just Splay tree");
        System.out.println("type \"BST\" for just BST");
        System.out.println("type \"ALL\" to insert into all three trees");

        String deleteFromThisTree = input.nextLine();

        switch (deleteFromThisTree){
            case ("AVL"):{
                avlTree.delete(deleteThis);
                break;
            }
            case ("Splay"):{
                splayTree.deleteKey(deleteThis);
                break;
            }
            case ("BST"):{
                bst.deleteKey(deleteThis);
                break;
            }
            case ("All"):{
                avlTree.delete(deleteThis);
                splayTree.deleteKey(deleteThis);
                bst.deleteKey(deleteThis);
                break;
            }
        }
    }



    private void find() {
        Scanner input = new Scanner(System.in);
        System.out.println("Word?");
        String findThis = input.nextLine();

        System.out.println("what tree would you like to find " + findThis + " from?");
        System.out.println("type \"AVL\" for just AVL tree");
        System.out.println("type \"Splay\" for just Splay tree");
        System.out.println("type \"BST\" for just BST");
        System.out.println("type \"ALL\" to insert into all three trees");

        String findFromThisTree = input.nextLine();

        switch (findFromThisTree) {
            case ("AVL"): {
                avlTree.find(findThis);
                break;
            }
            case ("Splay"): {
                splayTree.find(findThis);
                break;
            }
            case ("BST"): {
                bst.find(findThis);
                break;
            }
            case ("All"): {
                avlTree.find(findThis);
                splayTree.find(findThis);
                bst.find(findThis);
                break;
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
                String typeOfTree = input.nextLine();

                switch (typeOfTree){
                    case ("AVL"):{

                    }
                    case ("BST"):{

                    }

                    case ("Splay"):{

                    }

                }


            }
            case ("insert"):{

                insert();
                break;
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
//        read.loadData();
//        read.insertDataFromFile();
    }
}
