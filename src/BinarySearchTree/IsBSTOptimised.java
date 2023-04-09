package BinarySearchTree;

class Pair<T,V>{//Generic class for returning two pair of variable from one method
    T first;
    V second;
}

public class IsBSTOptimised {

    public static Pair<Boolean,Pair<Integer,Integer>> isBST(BinaryTreeNode<Integer> root){//here we are not making a triplet we adjusting it int to the pair class
        if (root == null) {//Base Case
            Pair<Boolean,Pair<Integer,Integer>> output = new Pair<>();
            output.first = true;//it means if null then isBST is set to true
            output.second = new Pair<Integer,Integer>();
            output.second.first = Integer.MAX_VALUE;//here we are setting the value of minimum
            output.second.second = Integer.MAX_VALUE;//here we are setting the of maximum
            return output;
        }

        Pair<Boolean,Pair<Integer,Integer>> leftOutput = isBST(root.left);
        Pair<Boolean,Pair<Integer,Integer>> rightOutput = isBST(root.right);
        int min = Math.min(root.data,Math.min(leftOutput.second.first,rightOutput.second.first));
        int max = Math.max(root.data,Math.max(leftOutput.second.second,rightOutput.second.second));
        boolean isBST = (root.data > leftOutput.second.second) && (root.data <= rightOutput.second.first) // root ka data left ke max se bada hona chaiye and root ka data right ke min se chota hona chaiye
                         && leftOutput.first && rightOutput.first;//and right and left both should BSt
        Pair<Boolean,Pair<Integer,Integer>> output = new Pair<>();
        output.first = isBST;
        output.second = new Pair<Integer,Integer>();
        output.second.first = min;
        output.second.second = max;
        return output;
    }

    public static void main(String[] args) {

    }
}
