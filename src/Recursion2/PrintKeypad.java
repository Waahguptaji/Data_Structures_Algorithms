package Recursion2;

public class PrintKeypad {

    public static void printKeypad(int input, String outputSoFar){
        if (input == 0 || input == 1) {
            System.out.println(outputSoFar);
            return;
        }

        String helperOutput = helper(input%10);
        for (int i = 0; i <helperOutput.length() ; i++) {
            printKeypad(input / 10, helperOutput.charAt(i) + outputSoFar);
        }

    }

    public static void printKeypad(int input){
        printKeypad(input , "");
    }
    
    public static String helper(int newN){
        if(newN==2)
            return "abc";
        if(newN==3)
            return "def";
        if(newN==4)
            return "ghi";
        if(newN==5)
            return "jkl";
        if(newN==6)
            return "mno";
        if(newN==7)
            return "pqrs";
        if(newN==8)
            return "tuv";
        if(newN==9)
            return "wxyz";
        else
            return "";
    }

    public static void main(String[] args) {
        printKeypad(23);
    }

}
