package Searching_Sorting;

import java.util.Scanner;

public class MergeSort {
    public static int[] mergeSort(int[] arr1, int[] arr2) { // Here function will return the new Merged array
       int i = 0;
       int j = 0;
       int k = 0;
       int[] ans = new int[arr1.length + arr2.length];
       while( i < arr1.length && j < arr2.length ){
           if (arr1[i] < arr2[j]) { // if arr1 element is lesser than arr2 element than it going to take place in the new third array.
               ans[k] = arr1[i];
               i++;
               k++;
           }else{// if arr1 element is greater than arr2 element then arr 2 element will go in new third array.
               ans[k] = arr2[j];
               j++;
               k++;
           }
       }
       // if above condition not met that means one of the two arrays had exhausted their elements as the rest element of one array is left--
        // --and those are sorted already we just copy it in the new Array.
       while(i < arr1.length){
           ans[k] = arr1[i];
           i++;
           k++;
       }
       while(j < arr2.length){
           ans[k] = arr2[j];
           j++;
           k++;
       }
       return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {7,8,9,10};
        int[] ans = mergeSort(arr1, arr2);
        for (int i = 0; i <ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        }
}
