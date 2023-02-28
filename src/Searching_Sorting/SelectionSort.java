package Searching_Sorting;

public class SelectionSort {
    public static void selectionSort(int input[]){
        for (int i = 0; i < input.length - 1 ; i++) { // here -1 because the minimum element will swipe itself with other
            int min = input[i]; // here we assuming i th element as min
            int minIndex = i; // here we need index of minimum element for swapping with its other element
            for (int j = i+1; j < input.length ; j++) {// it is because upto i element is sorted we need to sort from i+1
                if (input[j] < min) {
                    min = input[j]; // updating minimum
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // swapping of minimum element with the other compared element
                input[minIndex] = input[i];
                input[i] = min;
            }
        }
    }

    public static void main(String[] args) {
        int input[] = {0,6,0,1,2,2,1,1,0};
        selectionSort(input);
        for (int i = 0; i < input.length ; i++) {
            System.out.println(input[i] + " ");

        }
    }
}
