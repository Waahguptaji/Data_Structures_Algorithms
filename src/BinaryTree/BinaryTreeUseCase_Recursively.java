package BinaryTree;

import java.util.Scanner;

public class BinaryTreeUseCase_Recursively<T> {

    //Taking input Recursively
    public static BinaryTreeNode<Integer> takeInput(Scanner s){
        int rootData;
        System.out.println("Enter the root DAta:");
        rootData = s.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        if (root.data == -1) {
            return null;
        }
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }
    //Printing the Binary Tree Recursively
    public static void printTree(BinaryTreeNode<Integer> root){
        if (root == null) {
            return;
        }
        String tobePrinted = root.data + "";
        if (root.left != null) {
            tobePrinted += "L: " + root.left.data +",";
        }
        if (root.right != null) {
            tobePrinted += "R: " + root.right.data;
        }
        System.out.println(tobePrinted);
        printTree(root.left);
        printTree(root.right);
    }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInput(s);
        printTree(root);
        s.close();
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
//        root.left = node1;
//        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
//        root.right = node2;
    }
}
