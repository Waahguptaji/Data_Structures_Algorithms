/*
Problem Name: Tower of Hanoi
Problem Level: MEDIUM
Problem Description: #### Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move all disks from source rod to destination rod using third rod (say auxiliary). The rules are :
    1) Only one disk can be moved at a time.
    2) A disk can be moved only if it is on the top of a rod.
    3) No disk can be placed on the top of a smaller disk.

#### Print the steps required to move n disks from source rod to destination rod.
#### Source Rod is named as 'a', auxiliary rod as 'c' and destination rod as 'b'.

##### Input Format :
    Integer n

##### Output Format :
    Steps in different lines (in one line print source and destination rod name separated by space)*/
package Recursion1Assignment;

import java.util.Scanner;

public class TowerOfHanoi {
    public static  void toh(int n, char a , char b , char c ){
        //Base Case
        if (n == 0) {
            return;
        }

        /*RightCall*/ toh(n-1, a, c ,b);//will print the instruction to move n-1 disk from a to c using b
        /*In*/        System.out.println( a + " -> " + b);
        /*LeftCall*/ toh(n-1,c, b, a);//will print the instruction to move n-1 disk from c to b using a

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of Disks: ");
        int n = sc.nextInt();
        char a = 'a';
        char b = 'b';
        char c = 'c';
        toh(n,a,b,c);
    }
}
