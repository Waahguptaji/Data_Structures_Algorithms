package OOPS;

public class ComplexNumber {
    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }


    public void setReal(int r) {
        this.real = r;
    }


    public void setImaginary(int i) {
        this.imaginary = i;
    }

    public void add(ComplexNumber c2){
        this.real = this.real + c2.real;
        this.imaginary = this.imaginary + c2.imaginary;
    }

    public void multiply(ComplexNumber c2){
        this.real = this.real * c2.real;
        this.imaginary = this.imaginary * c2.imaginary;
    }

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2){
        int newReal = c1.real + c2.real;
        int newImaginary = c1.imaginary + c2.imaginary;
        ComplexNumber c = new ComplexNumber(newReal, newImaginary);
        return c;
    }

    public void print(){
        System.out.println(real + " + " + imaginary + "i");
    }

    public ComplexNumber conjugate(){
        int newReal = real;
        int newImaginary = -imaginary;
        ComplexNumber c = new ComplexNumber(newReal, newImaginary);
        return c;
    }

}
