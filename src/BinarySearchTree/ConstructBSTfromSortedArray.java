package BinarySearchTree;

public class ConstructBSTfromSortedArray {

    public static BinaryTreeNode<Integer> constructBST(int[] input, int sI, int eI){
        if (input.length == 0) {
            return null;
        }
        return constructBSTHelper(input, 0, input.length - 1);
    }


    public static BinaryTreeNode<Integer> constructBSTHelper(int[] input, int sI, int eI){
        if (sI > eI) {
            return null;
        }

        int mid = ( sI + eI ) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(input[mid]);// here we are makin the mid root of the binarysearch tree we creating

        root.left = constructBST(input,sI, mid - 1);//recursive call for left and right
        root.right = constructBST(input,mid + 1, eI);

        return root;
    }


}
