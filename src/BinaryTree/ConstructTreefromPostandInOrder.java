/*
Coding Problem Name: Construct Tree from postorder & inorder
Problem Level: MEDIUM
Problem Description: ####Given Postorder and Inorder traversal of a binary tree, create the binary tree associated with the traversals.You just need to construct the tree and return the root.

#####Note: Assume binary tree contains only unique elements.

`Input format : `

`Line 1 : n (Total number of nodes in binary tree)`

`Line 2 : Post order traversal`

`Line 3 : Inorder Traversal`

`Output Format : `

`Elements are printed level wise, each level in new line (separated by space).`
 #####Sample Input :
    8
    8 4 5 2 6 7 3 1
    4 8 2 5 1 6 3 7

#####Sample Output :
    1
    2 3
    4 5 6 7
    8
*/
package BinaryTree;

import java.util.Scanner;

public class ConstructTreefromPostandInOrder {

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

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] in, int[] post, int inS, int inE, int postS, int postE){
        if (inS > inE) {
            return null;
        }
        int rootData = post[postS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int rootInIndex = -1;
        for (int i = inS; i <= inE ; i++) {
            if (in[i] == rootData) {
                rootInIndex = i;
                break;
            }
        }
        if (rootInIndex == -1) {//in case the rootData isn't found well it didn't happen
            return null;
        }

        int leftInS = inS;
        int leftInE = rootInIndex - 1;
        int leftPostS = postS;
        int leftPostE = leftInE - leftInS;// leftPostE= leftInE - leftInS
        int rightInS = rootInIndex + 1 ;
        int rightInE = inE;
        int rightPostS = leftPostE + 1;
        int rightPostE = postE;

        root.left = buildTreeHelper(in,post,leftInS,leftInE,leftPostS,leftPostE);//We are calling on both left and right
        root.right = buildTreeHelper(in,post,rightInS,rightInE,rightPostS,rightPostE);
        return root;
    }



    public static BinaryTreeNode<Integer> buildTree(int[] in, int[] pre){
        return buildTreeHelper(in, pre,0, in.length - 1, 0, pre.length - 1);
    }

    public static void main(String[] args) {
        int[] in = {4,2,5,1,3,7};
        int[] post = {4,5,2,7,3,1};
        BinaryTreeNode<Integer> root = buildTree(in,post);
        printTreeLevelWise(root);
    }

}
