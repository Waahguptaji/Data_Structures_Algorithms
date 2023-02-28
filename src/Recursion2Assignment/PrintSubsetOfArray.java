package Recursion2Assignment;

public class PrintSubsetOfArray {
    public static void printSubsetOfArray(int input[], int output[], int startIndex) {
        //Base Case
        if (startIndex == input.length) {
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        //Case one, output contains element of input array at startIndex
        int newOutput[] = new int[output.length + 1];
        for (int i = 0; i < output.length; i++) { // here we copying the first element in the newoutput
            newOutput[i] = output[i];
        }
        newOutput[output.length] = input[startIndex];
        printSubsetOfArray(input,newOutput , startIndex + 1);

        //Case 2, output does not contain element of input array at startIndex
        printSubsetOfArray(input, output, startIndex + 1);
    }

    public static void printSubset(int input[]){

        printSubsetOfArray(input, new int[0],0);
    }

    public static void main(String[] args) {
        int input[] = {15,20,12};
        printSubset(input);
    }
}




