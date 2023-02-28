//Check whether the array sorted or not Recursively.
package Recursion1;

public class CheckSortArray {
    public static boolean checkSort1(int input[]) {
        //Base case
        if (input.length <= 1) {
            return true;
        }

        //SmallProblem- here we are creating a n-1 length array
        int smallInput[] = new int[input.length - 1];
        for (int i = 1; i < smallInput.length ; i++) {
            smallInput[i-1] = input[i];// here we are copying the element of input in the smallInput except the first element
        }
        boolean smallAns = checkSort1(smallInput);
        if(!smallAns){
            return true;
        }

        //processing
        if (input[0] <= input[1]){
            return true;
        }else {
            return false;
        }
    }


    public static void main(String[] args) {
        int input[] ={1,2,3,4,5};
        System.out.println(checkSort1(input));
    }

}
