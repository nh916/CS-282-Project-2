//import java.util.Scanner;
//
//public class Driver extends Read{
//
////    private AVLTree avlTree;
////    private SplayTree splayTree;
////    private BST bst;
//
//    private Scanner input;
//
//    private boolean wantsBST;
//    private boolean wantsAVL;
//    private boolean wantsSplay;
//
//
//    public Driver(){
////        avlTree =  new AVLTree();
////        splayTree = new SplayTree();
////        bst = new BST();
//
//        input = new Scanner(System.in);
//
//        wantsBST = false;
//        wantsAVL = false;
//        wantsSplay = false;
//    }
//
//
//
//    private void select() {
//        System.out.println("type of tree");
//        String typeOfTree = input.nextLine();
//
//        switch (typeOfTree) {
//
//            case ("BST"): {
//                wantsBST = true;
//                wantsAVL = false;
//                wantsSplay = false;
//                break;
//            }
//            case ("AVL"): {
//                wantsBST = false;
//                wantsAVL = true;
//                wantsSplay = false;
//                break;
//            }
//            case ("Splay"): {
//                wantsBST = false;
//                wantsAVL = false;
//                wantsSplay = true;
//                break;
//            }
//            default: {
//                defaultCase();
//                break;
//            }
//        }
//    }
//
//
//
//    private void defaultCase(){
//        System.out.println("Not a valid choice. Please try again.");
//    }
//
//
////    private void BST(){
////
////    }
////
////    private void avl(){
////
////    }
////
////    private void splay(){
////
////    }
//
//
//
//
//    private void help(){
//        System.out.println("your options are: ");
//        System.out.println("select (select the type of tree)");
//        System.out.println("find");
//        System.out.println("insert");
//        System.out.println("delete");
//        System.out.println("quit");
//    }
//
//
//    private void options(){
//        String choice = "";
//
//        while (!choice.equals("quit")){
//
//            System.out.println("what would you like to do?");
//            choice = input.nextLine();
//
//            switch (choice){
//
//                case ("help"):{
//                    help();
//                    break;
//                }
//
//
//                case ("select"):{
//                    select();
//                    break;
//                }
//
//                case ("insert"):{
//                    System.out.println("word?");
//                    String wordToInsert;
//                    wordToInsert = input.nextLine();
//
//                    if (wantsBST){
//                        bst.insert(wordToInsert);
//                        break;
//                    }
//                    else if (wantsAVL){
//                        avlTree.insert(wordToInsert);
//                        break;
//                    }
//                    else if (wantsSplay){
//                        splayTree.insertSplay(wordToInsert);
//                        break;
//                    }
//                    else if (!wantsBST && !wantsAVL && !wantsSplay){
//                        System.out.println("please select tree!!!!");
//                        select();
//                        break;
//                    }
//                    else {
//                        defaultCase();
//                        break;
//                    }
//
//                }
//
//                case ("delete"):{
//                    System.out.println("word?");
//                    String wordToDelete;
//                    wordToDelete = input.nextLine();
//
//                    try {
//                        if (wantsBST){
//                            bst.deleteKey(wordToDelete);
//                            break;
//                        }
//                        else if (wantsAVL){
//                            avlTree.delete(wordToDelete);
//                            break;
//                        }
//                        else if (wantsSplay){
//                            splayTree.delete(wordToDelete);
//                            break;
//                        }
//                        else if (!wantsBST && !wantsAVL && !wantsSplay){
//                            System.out.println("please select tree!!!!");
//                            select();
//                        }
//                        else {
//                            defaultCase();
//                            break;
//                        }
//                    }
//                    catch (NullPointerException e){
//                        System.out.println("Null pointer!!");
//                        break;
//                    }
//                    catch (Exception e){
//                        System.out.println("you have produced an exception congratulations");
//                        break;
//                    }
//
//                }
//
//                case ("find"): {
//                    System.out.println("word?");
//                    String wordToFind;
//                    wordToFind = input.nextLine();
//
//                    try {
//                        if (wantsBST){
//                            if (bst.find(wordToFind) == null){
//                                System.out.println("word not found");
//                                break;
//                            }
//                            else if (bst.find(wordToFind).equals(wordToFind)){
//                                System.out.println(bst.find(wordToFind));
//                                break;
//                            }
//                            else {
//                                System.out.println("something went wrong in BST");
//                            }
//                        }
//                        else if (wantsAVL){
//                            if (avlTree.find(wordToFind) == null){
//                                System.out.println("word not found");
//                                break;
//                            }
//                            else if (avlTree.find(wordToFind).equals(wordToFind)) {
//                                System.out.println(avlTree.find(wordToFind));
//                                break;
//                            }
//                            else {
//                                System.out.println("something went wrong in find AVL");
//                                break;
//                            }
//                        }
//                        else if (wantsSplay){
//                            if (splayTree.find(wordToFind) == null){
//                                System.out.println("word not found");
//                                break;
//                            }
//                            else if (splayTree.find(wordToFind).equals(wordToFind)){
//                                System.out.println(splayTree.find(wordToFind));
//                                break;
//                            }
//                            else {
//                                System.out.println("something went wrong in find SPLAY");
//                                break;
//                            }
//
//                        }
//                        else if (!wantsBST && !wantsAVL && !wantsSplay){
//                            System.out.println("please select tree!!!!");
//                            select();
//                        }
//                        else {
//                            defaultCase();
//                            break;
//                        }
//                    }
//
////                which exception would it be
//                    catch (NullPointerException e){
//                        System.out.println("what you were looking for created a null pointer");
//                        break;
//                    }
//                    catch (Exception e ){
//                        System.out.println("Exception");
//                        break;
//                    }
//
//                }
//
//                case ("quit"): {
//                    break;
//                }
//
//                default:{
//                    defaultCase();
//                    break;
//                }
//            }
//        }
//    }
//
//
//    public static void main(String[] args){
//        Driver driver = new Driver();
//// not inserting into the tree into
//        driver.readAndInsertToTreesWithFile();
//        driver.options();
//    }
//}
