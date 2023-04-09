package BinarySearchTree;

import java.util.Scanner;

public class IsBSTOptimised2 {
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

    //More Optimised Solution but same Time Complexity of O(n)
    public static boolean isBSTOptimised2(BinaryTreeNode<Integer> root, int min, int max){
        if (root == null) {//Base Case
            return true;
        }

        if (root.data < min || root.data > max){
            return false;
        }

        boolean isLeftOk = isBSTOptimised2(root.left, min, root.data - 1);
        boolean isRightOk = isBSTOptimised2(root.right, root.data, max);

        return isLeftOk && isRightOk;
    }

}
