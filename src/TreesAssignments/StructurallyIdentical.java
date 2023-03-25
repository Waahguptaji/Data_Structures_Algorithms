/*
 ssignment Coding Problem Name: Structurally identical
Problem Level: MEDIUM
Problem Description: ####Given two Generic trees, return true if they are structurally identical i.e. they are made of nodes with the same values arranged in the same way.

`Input format : `

`Line 1 : Tree 1 elements in level order form separated by space (as per done in class). Order is - `

`Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `

`Line 2 : Tree 2 elements in level order form separated by space (as per done in class). Order is - `

`Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `

`Output format : true or false`
 #####Sample Input 1 :
    10 3 20 30 40 2 40 50 0 0 0 0
    10 3 20 30 40 2 40 50 0 0 0 0

#####Sample Output 1 :
    true

#####Sample Input 2 :
    10 3 20 30 40 2 40 50 0 0 0 0
    10 3 2 30 40 2 40 50 0 0 0 0

#####Sample Output 2:
    false*/

package TreesAssignments;

import java.util.Scanner;

public class StructurallyIdentical {
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

    public static Boolean identicalOrNot(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if(root1.children.size() != root2.children.size()){
            return false;
        }
        if (root1.data == root2.data) {//BAse CAse
            return true;
        }
        for (int i = 0; i < root1.children.size() ; i++) {
            if (identicalOrNot(root1.children.get(i), root2.children.get(i))) {
                return  true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws QueueEmptyException {
        TreeNode<Integer> root1 = takeInputLevelWise();
        TreeNode<Integer> root2 = takeInputLevelWise();

        System.out.println(identicalOrNot(root1, root2));
    }
}
