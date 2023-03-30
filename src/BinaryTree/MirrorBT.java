/*Coding Problem Name: Mirror a Binary tree
Problem Level: EASY
Problem Description: ####Mirror the given binary tree. That is, right child of every nodes should become left and left should become right.

![Alt text](	https://ninjasfiles.s3.amazonaws.com/0000000000000485.png)


#####Note : You don't need to print or return the tree, just mirror it.

`Input format : `

`Line 1 : Elements in level order form (separated by space)`

`(If any node does not have left or right child, take -1 in its place)`

`Output format : Elements in level order form (Every level in new line)`

 #####Sample Input 1:
    1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

#####Sample Output 1:
    1
    3 2
    7 6 5 4
#####Sample Input 2:
    5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1

#####Sample Output 2:
    5
    6 10
    3 2
    9
*/
package BinaryTree;

import java.util.Scanner;

public class MirrorBT {

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

    public static void mirrorBT(BinaryTreeNode<Integer> root){
        if (root == null) {
            return;
        }

        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorBT(root.left);
        mirrorBT(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        mirrorBT(root);
        printTreeLevelWise(root);
    }

}
