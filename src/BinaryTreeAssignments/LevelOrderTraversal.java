/*
Assignment Coding Problem Name: Level order traversal
Problem Level: MEDIUM
Problem Description: ####Given a binary tree, print the level order traversal. Make sure each level start in new line.

`Input format : `

`Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.`

`Output Format : `

`Elements are printed level wise, each level in new line (separated by space).`
 #####Sample Input :
    5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1

#####Sample Output :
    5
    6 10
    2 3
    9
*/

package BinaryTreeAssignments;


import java.util.Scanner;

public class LevelOrderTraversal {
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

    public static void levelOrderTraversal(BinaryTreeNode<Integer> root){
        if (root == null) {
            return;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()){;
            BinaryTreeNode<Integer> front;
            try {
                front= pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return;
            }

            System.out.print(front.data + " ");
            if (front.left != null) {
                pendingNodes.enqueue(front.left);
            }
            if (front.right != null) {
                pendingNodes.enqueue(front.right);
            }
        }
        return;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        levelOrderTraversal(root);
    }

}
