package OOPS;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {// Constructor
        this.numerator = numerator; //here we are assigning the numerator the value of we get from local numerator.
        if (denominator == 0) {
            // TODO error out
        }
        this.denominator = denominator;//here we are assigning the denominator the value of we get from local denominator.
        simplify();//it is to simplify the fraction as soon as somebody changes the num or denominator
    }


    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }


    public void setNumerator(int n) {
        this.numerator = n;
        simplify();
    }

    public void setDenominator(int d) throws ZeroDenominatorException {// to tell that it can throw exception
        if (d == 0) {
            ZeroDenominatorException e = new ZeroDenominatorException();
            throw e;//for throwing exception
        }
        this.denominator = d;
        simplify();
    }

    public void print() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    private void simplify() {
        int gcd = 1;
        int smaller = Math.min(numerator, denominator);
        for (int i = 2; i <= smaller; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }


    public static Fraction add(Fraction f1, Fraction f2) {// here we are creating a static Function that will return fr
        int newNum = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        int newDen = f1.denominator + f2.denominator;
        Fraction fr = new Fraction(newNum, newDen);
        return fr;
    }

    public void add(Fraction f2) {
        //this.numerator uska numerator jispe call ho rhi hai
        this.numerator = this.numerator * f2.denominator + this.denominator * f2.numerator;
        this.denominator = this.denominator + f2.denominator;
        simplify();
    }

    public void multiply(Fraction f2) {
        this.numerator = this.numerator * f2.numerator;
        this.denominator = this.denominator * f2.denominator;
        simplify();
    }



}
