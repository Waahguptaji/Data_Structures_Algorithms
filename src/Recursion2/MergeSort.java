package Recursion2;

public class MergeSort {
    static void mergeSort(int input[], int sI, int eI){
        if(sI >= eI){
            return;
        }
        int mid = (sI + eI)/2;
        //Part-1
        mergeSort(input, sI, mid);
        //Part-2
        mergeSort(input,mid+1, eI);
        merge(input, sI , eI);
    }

    private static void merge(int input[], int sI, int eI ) {
        int mid = (sI + eI)/2;

        int ans[] = new int[eI - sI + 1];// this is created for storing small elements while we are merging and comparing.
        int i = sI;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= eI){//the comparison is in between two slots within array so i can go the last index of first slot that is mid
                                    // and j can go the last index of second slot that is eI.

            if(input[i] <= input[j]) {// if input[i] element is lesser than input[j] element than it going to take place in the new third array ans.
                ans[k] = input[i];
                i++;
                k++;
            }
            else {// if input[j] element is lesser than input[i] element than it going to take place in the new third array ans.
                ans[k] = input[j];
                j++;
                k++;
            }
        }

        // if above condition not met that means one of the two part of input array had exhausted their elements as the rest element of one part is left--
        // --and those are sorted already we just copy it in the new Array.
        while(i <= mid){
            ans[k] = input[i];
            i++;
            k++;
        }
        while(j <= eI){
            ans[k] = input[j];
            j++;
            k++;
        }

        //after merging the answer is in ans[] array, so we had to copy ans[] elements in the input[] array.
        for (int index = 0; index < ans.length ; index++) {
            input[sI + index] = ans[index]; // we add starting index because it is no everytime it is zero
                                           // sometimes we can also sort a given segment in input[] array.
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,2,8,9,1,3};
        mergeSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
