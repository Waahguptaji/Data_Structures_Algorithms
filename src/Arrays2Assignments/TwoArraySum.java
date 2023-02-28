package Arrays2Assignments;

import java.util.Scanner;

public class TwoArraySum {
    //FOr better understanding watch pepcoding video on this

    public static void twoArraySum(int arr1[], int arr2[],int output[]){
        // we starting to add from the right to left
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;
        int k = Math.max(arr1.length, arr2.length); //k is the last index of output array
        while(i>= 0 && j>= 0){// if both array has elements in it.
            int sum = arr1[i] + arr2[j] + carry;
            carry = sum/10; //here we are getting the carry which need to store in forward array
            output[k] = sum%10;// here we doing modulus for getting the base to store in current
            i--;
            j--;
            k--;
        }

        while(i>= 0){// if no element left in arr2 so we just simply add the element of arr1 and the carry if any.
            int sum = arr1[i] + carry;
            carry = sum/10;
            output[k] = sum%10;
            i--;
            k--;
        }

        while(j>= 0){// if no element left in arr2 so we just simply add the element of arr1 and the carry if any.
            int sum = arr1[j] + carry;
            carry = sum/10;
            output[k] = sum%10;
            j--;
            k--;
        }
        output[0] = carry; //if there is any carry in the last we put it on the zero element as we take size of output + 1 that size of largest array
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array1: ");
        int n1 = sc.nextInt();
        int arr1[] =new int[n1];
        for (int i = 0; i < n1 ; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the Size of Array2: ");
        int n2 = sc.nextInt();
        int arr2[] =new int[n2];
        for (int i = 0; i < n2 ; i++) {
            arr2[i] = sc.nextInt();
        }
        int output[] =new int[Math.max(n1, n2) + 1 ];// we taking + 1 for extra carry

        twoArraySum(arr1, arr2, output);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i] + " ");
        }


    }
}
