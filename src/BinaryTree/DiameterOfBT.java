package BinaryTree;

import java.util.Scanner;

 class Pair<T,V>{//Generic class for returning two pair of variable from one method
     T first;
     V second;
}

public class DiameterOfBT {

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes =new QueueUsingLL<>();
        System.out.println("Enter root data:");
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            System.out.println("Enter the left child of"+ front.data);
            int leftChild = s.nextInt();
            if (leftChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
                pendingNodes.enqueue(child);
                front.left = child;
            }

            System.out.println("Enter the right child of"+ front.data);
            int rightChild = s.nextInt();
            if (rightChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
                pendingNodes.enqueue(child);
                front.right = child;
            }
        }
        return root;
    }
    public static void printTreeLevelWise(BinaryTreeNode<Integer> root){
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes =new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        if (root == null) {
            return ;
        }
        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();// root ko nikala

            } catch (QueueEmptyException e) {
                return;
            }
            System.out.print(front.data + ": ");//root ko print karaya
            if (front.left != null){
                System.out.print("L:" + front.left.data + ",");
                pendingNodes.enqueue(front.left);
            }else{// == null
                System.out.print("L:-1 ");
            }

            if (front.right != null){
                System.out.print("R:" + front.right.data );
                pendingNodes.enqueue(front.right);
            }else{// == null
                System.out.print("R:-1 ");
            }
            System.out.println();
        }
    }

/*
    // Non Optimised --> O(nlogn)[for diameter] + O(n)[for height]
    private static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {// Base case
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return  1 + Math.max(lh,rh);
    }

    public static int diameter(BinaryTreeNode<Integer> root){
        if (root == null) {//Base Case
            return 0;
        }

        int option1 = height(root.left) + height(root.right);//when the distant nodes is on left and right
        int option2 = diameter(root.left); //when distant nodes is on the left side
        int option3 = diameter(root.right);//when distant nodes is on the right side

        return Math.max(option1, Math.max(option2,option3));// the diameter is the max of the all option
    }

 */

    //Optimised Solution --> O(n)
    public static Pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root){
        if (root == null) {//Base Case
            Pair<Integer,Integer> output = new Pair<>();
            output.first = 0;
            output.second = 0;
            return output;
        }

        Pair<Integer,Integer> lo = heightDiameter(root.left);
        Pair<Integer,Integer> ro = heightDiameter(root.right);

        int height = 1 + Math.max(lo.first,ro.first);
        int option1 = lo.first + ro.first;
        int option2 = lo.second;
        int option3 = ro.second;
        int diameter = Math.max(option1,Math.max(option2,option3));

        Pair<Integer,Integer> output = new Pair<>();
        output.first = height;
        output.second = diameter;

        return output;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTreeLevelWise(root);
        System.out.println(("height:  " + heightDiameter(root).first));
        System.out.println(("diameter:  " + heightDiameter(root).second));
    }
}
