/*
* Coding Problem
Problem Name: Quick Sort
Problem Level: MEDIUM
Problem Description: #### Sort an array A using Quick Sort.

#### Change in the input array itself. So no need to return or print anything.
<br>

##### Input format :
    Line 1 : Integer n i.e. Array size
    Line 2 : Array elements (separated by space)

##### Output format :
    Array elements in increasing order (separated by space)*/

package Recursion2;

public class QuickSort {
     static void quickSort(int input[], int sI, int eI){
        //Base Case
        if(sI >= eI){
            return;
        }
       int pivotpos = partition(input,sI,eI);
        //Part-1
         quickSort(input, sI, pivotpos-1);
         //Part-2
         quickSort(input, pivotpos+1, eI);
    }

    static private int partition(int input[], int sI,int eI){
         //find Pivot
        int pivot = input[sI];
        int count =0;

        //finding the pivot position
        for (int i = sI+1; i <= eI; i++) {
            if (pivot >= input[i]) {
                count++;
            }

        }
       int pivotpos = sI + count;
        //Placing Pivot at its Position by swaping
        int temp = input[pivotpos];
        input[pivotpos]= input[sI];
        input[sI] = temp;
        //Ensure towards left <= pivot and towards >pivot.
        int i = sI;
        int j = eI;
        while (i < j){
            if (input[i] <= pivot ) {
                i++;
            }
            else if(input[j] > pivot) {
                j--;
            }else {
                temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        return pivotpos;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,6,7,8,9,1,3};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

}
