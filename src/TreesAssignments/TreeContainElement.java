/*
Assignment Coding Problem Name: Check if generic tree contain element x
Problem Level: MEDIUM
Problem Description: ####Given a generic tree and an integer x, check if x is present in the given tree or not. Return true if x is present, return false otherwise.

`Input format : `

`Line 1 : Integer x`

`Line 2 : Elements in level order form separated by space (as per done in class). Order is - `

`Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `

`Output format : true or false`
 #####Sample Input 1 :
    40
    10 3 20 30 40 2 40 50 0 0 0 0

#####Sample Output 1 :
    true

#####Sample Input 2 :
    4
    10 3 20 30 40 2 40 50 0 0 0 0

#####Sample Output 2:
    false */
package TreesAssignments;

import java.util.Scanner;

public class TreeContainElement {

    public static TreeNode<Integer> takeInputLevelWise() throws QueueEmptyException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root data: ");
        int rootData = sc.nextInt();
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> frontNode = pendingNodes.dequeue();
            System.out.println("Enter the number of child of" + frontNode.data );
            int numChild = sc.nextInt();
            for (int i = 0; i <numChild ; i++) {
                System.out.println("Enter" + (i+1) + "th child of" + frontNode.data);
                int child = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(child);
                frontNode.children.add(childNode);
                pendingNodes.enqueue(childNode);
            }
        }
        return root;
    }
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

    public static boolean ifContainX(TreeNode<Integer> root, int x){
        if (root == null) {
            return false;
        }

        if (root.data == x) {
            return true;
        }

        for (int i = 0; i <root.children.size() ; i++) {
            if (ifContainX(root.children.get(i), x)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws QueueEmptyException {
        TreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println(ifContainX(root, 1));
    }


}
