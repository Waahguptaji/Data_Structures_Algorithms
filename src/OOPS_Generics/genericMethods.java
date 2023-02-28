package OOPS_Generics;
// for to create a method or function generic we have to <T> besides the static
public class genericMethods {

    public static<T extends PrintInterface> void printArray(T a[]){// here we are creating a type T in a method or function
//                   ⬆️
//                  for generic Bound extends is used for both Class and Interface
        for (int i = 0; i < 10 ; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer a[] = new Integer[10];
        for (int i = 0; i <10 ; i++) {
            a[i] = i +1;
        }

        String s[] = new  String[10];
        for (int i = 0; i <10 ; i++) {
            s[i] = "abc";
        }

//        printArray(a);
//        printArray(s);

        Student b[] = new  Student[10];
        for (int i = 0; i <10 ; i++) {
            b[i] = new Student();
        }
        printArray(b);// this is allowed because student implements the print interface because generic has bound it

    }
}
