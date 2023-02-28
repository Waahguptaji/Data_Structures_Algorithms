package OOPS_Generics;

// why generics used?
/* because we donot want to create a class that it could only take a one type of data,
that's why we are using the generics.
*/
public class PairUse {

    public static void main(String[] args) {

//        Pair<String,String> p = new Pair<>("aa", "bb");
                       //or
        Pair<String, String> p = new Pair<String, String>("aa", "bb");//here we are telling the type
        p.setFirst("def");//here automatically updated the type in all
        String s = p.getFirst();

//        Pair p1 = new Pair(1,2); we will not do this because it creates p1 as object and object can take any type
//        p1.setFirst("abc");

/*        Pair<int> p2 = new Pair<int>(1,2); // this is not valid because we can use generics in class only int is a primitive data type,
                                              we cannot create its object*/
        //instead we have a class named Integer we can use this to create an integer.
        Pair<Integer,String> p2 = new Pair<>(1,"temp");
        //we have inBuilt classes for the primitive data type bool, char etc like Boolean and Character
        Pair<Character,Boolean> p3 = new Pair<Character, Boolean>('a',false);


        int a = 10;
        int b = 20;
        int c= 30;

        //We are two pass three data type in Pair without creating a triple class
        Pair<Integer,Integer> internalPair = new Pair<>(a, b);
        Pair<Pair<Integer,Integer>, Integer> p4 = new Pair<>(internalPair, c);

        System.out.println(p4.getFirst());//Here we are printing the third integer
        System.out.println(p4.getFirst().getFirst());//Here we are printing the first integer
        System.out.println(p4.getFirst().getSecond());//Here we are printing the second integer


    }
}