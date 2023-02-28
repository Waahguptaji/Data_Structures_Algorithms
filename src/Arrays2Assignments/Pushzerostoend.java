//##### Sample Input 2:
//    2
//    5
//    0 3 0 2 0
//    4
//    9 0 0 8 2
//

//##### Sample Output 2:
//    3 2 0 0 0
//    9 8 2 0 0
package Arrays2Assignments;

import java.util.Scanner;

public class Pushzerostoend {
    public static void testCase(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of the  TestCase: ");
        int t = sc.nextInt();
        for (int i = 0; i < t ; i++) {
            System.out.println("Enter the size of Array: ");
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < size - 1 ; j++) {
                for (int k = 0; k < size - j - 1  ; k++) {
                    int temp = 0;
                    if (arr[k] <= arr[k+1]) {
                        temp = arr[k];
                        arr[k] = arr[k+1];
                        arr[k+1] = temp;
                    }
                }
            }
            for (int j = 0; j < size ; j++) {
                System.out.println(arr[j]);
            }

        }


    }

    public static void main(String[] args) {
        testCase();

    }
}
