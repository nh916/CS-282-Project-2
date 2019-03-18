import java.util.Scanner;

public class Driver {


//    this might possibly call for a switch statement of menus
    public void options(){
        Scanner input = new Scanner(System.in);
        System.out.println("what would you like to do?");
        String choice = input.nextLine();

        switch (choice){
            case ("insert"):{

            }
            case ("delete"):{

            }

            case ("find"): {

            }

            case ("quit"):{
                System.exit(0);
            }

            default:{
                System.out.println("Not a valid choice. Please try again.");
            }
        }



    }


    public static void main(String[] args){
        BST binarySearchTree = new BST();
        AVLTree avlTree = new AVLTree();
        SplayTree splayTree = new SplayTree();

        Read read = new Read("file1.txt", "file2.txt", "file3.txt", "file4.txt");
    }
}
