/*
* Assignment Coding Problem
Problem Name: Next larger element
Problem Level: MEDIUM
Problem Description: ####Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.
#####Return NULL if no node is present with value greater than n.

`Input format : `

`Line 1 : Integer n`

`Line 2 : Elements in level order form separated by space (as per done in class). Order is - `

`Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `

`Output format : Node with value just greater than n.`
 #####Sample Input 1 :
    18
    10 3 20 30 40 2 40 50 0 0 0 0

#####Sample Output 1 :
    20

#####Sample Input 2 :
    21
    10 3 20 30 40 2 40 50 0 0 0 0

#####Sample Output 2:
    30*/

package TreesAssignments;

import java.util.Scanner;


/*The idea is maintaining a node pointer res, which will contain the final resultant node.
        Traverse the tree and check if root data is greater than x. If so, then compare the root data with res data.
        If root data is greater than n and less than res data update res.*/
public class NextLargerElement {

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

    static TreeNode<Integer> nextLarger;

    public static void nextLargerElementHelper(TreeNode<Integer> root, int n) {
        if (root == null) {
            return;
        }
        // if root is less than nextLargest but
        // greater than x, update nextLargest
        if (root.data > n) {
            if (nextLarger == null || nextLarger.data > root.data) {
                nextLarger = root;
            }
        }
        for(int i = 0; i < root.children.size(); i++) {
            nextLargerElementHelper(root.children.get(i), n);
        }
        return;
    }

   // Function to find next Greater element
    // of x in tree
     static int nextLargerElement(TreeNode<Integer> root, int n)
    {
        nextLarger = null;
        // calling helper function
         nextLargerElementHelper(root,n);
         return nextLarger.data;
    }

    public static void main(String[] args) throws QueueEmptyException {
        TreeNode<Integer> root = takeInputLevelWise();
//        printLevelWise(root);
        System.out.println(nextLargerElement(root, 6));
    }
}
