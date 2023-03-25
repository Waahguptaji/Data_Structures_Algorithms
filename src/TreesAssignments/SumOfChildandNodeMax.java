/*
Assignment Coding Problem Name: Node having sum of children and node is max
Problem Level: MEDIUM
Problem Description: ####Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.

`Input format : `

`Line 1 : Elements in level order form separated by space (as per done in class). Order is - `

`Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `

`Output format : Node with maximum sum.`
 #####Sample Input 1 :
    5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0

#####Sample Output 1 :
    1 */
package TreesAssignments;

import java.util.Scanner;

public class SumOfChildandNodeMax {
    //    Taking Input Level Wise using Queues
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root data:");
        int rootData = sc.nextInt();
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("Enter the number of child of " + frontNode.data);
                int numChildren = sc.nextInt();
                for (int i = 0; i < numChildren; i++) {
                    System.out.println("Enter " + (i + 1) + "th child of" + frontNode.data);
                    int child = sc.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    frontNode.children.add(childNode);//connecting the childNode and the frontNode
                    pendingNodes.enqueue(childNode);//here we add the childNode because maybe it contains children further
                }
            } catch (QueueEmptyException e) {
                //it will not come here
            }
        }
        return root;
    }
    //    printing tree Level Wise using Queues
    public static void printLevelWise(TreeNode<Integer> root) throws QueueEmptyException {
        if (root == null) {
            return;
        }

        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {// until queue became empty
            TreeNode<Integer> frontNode = pendingNodes.dequeue();// root ko nikala
            System.out.print(frontNode.data + ": ");//root ko print karaya
            for (int i = 0; i < frontNode.children.size(); i++) {//phir uske bacho tak traverse karaya
                System.out.print(frontNode.children.get(i).data + ",");// phir bachhe print kara liye
                pendingNodes.enqueue(frontNode.children.get(i));//phir baccho ko queue mai bhej dia
            }
            System.out.println();
        }

    }

    public static int maxSumOfNodeChild(TreeNode<Integer> root){
        if (root == null) {
            return 0;
        }

        int maxSum = 0;
        int childNodeSum = 0;
        if (root.children.size() == 0) {
            return childNodeSum;
        }
        for (int i = 0; i <root.children.size() ; i++) {
             childNodeSum = childNodeSum + maxSumOfNodeChild(root.children.get(i));
            if (maxSum < childNodeSum) {
                maxSum = childNodeSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) throws QueueEmptyException {
        TreeNode<Integer> root = takeInputLevelWise();
        System.out.println(maxSumOfNodeChild(root));

    }
}
