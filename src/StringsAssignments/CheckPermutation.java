/*Problem Description: #### Given two strings, S and T, check if they are permutations of each other. Return true or false.
#### Permutation means - length of both the strings should same and should contain same set of characters. Order of characters doesn't matter.
##### Note : Input strings contain only lowercase english alphabets.
*/

package StringsAssignments;

import java.util.Scanner;

public class CheckPermutation {
    public static boolean checkPermutation(String str1, String str2){
        boolean check = false;
        for (int i = 0; i < str1.length() ; i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                     check = true;
                }else {
                    check = false;
                }
            }
        }
        return check;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String1: ");
        String str1 = sc.nextLine();
        str1 =str1.toLowerCase();
        System.out.println("Enter the String2: ");
        String str2 = sc.nextLine();
        str2 = str2.toLowerCase();
        System.out.println(checkPermutation(str1,str2));
    }

}
