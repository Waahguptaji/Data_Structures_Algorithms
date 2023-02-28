package OOPS;

public class ComplexNumberUse {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(2,3);
        c1.print();

        c1.setReal(10);
        c1.setImaginary(30);
        c1.print();
        //c1=> 10 + 30i

        ComplexNumber c2 = new ComplexNumber(1,5);
        c1.add(c2);
        c1.print();
        // c1=> 11 + 35i
        c2.print();
        // c2=> 1 + 5i

        ComplexNumber c3 = new ComplexNumber(3,2);
        c3.multiply(c2);
        c3.print();
        // c3 => 3 + 10i
        c2.print();
        // c2=> 1 + 5i

        ComplexNumber c4 = ComplexNumber.add(c1,c3);// here we are calling the add function using Class because we create a static function
        c1.print();
        //c1=> 11 + 35i
        c3.print();
        // c3 => 3 + 10i
        c4.print();
        // c4 => 14 + 45i


        ComplexNumber c5 = c1.conjugate();
        c5.print();
    }
}
