package ru.skillbench.tasks.basics.math;


public class Main {
    public static void main(String[] args) {
        ComplexNumber z = new ComplexNumberImpl("5+2i");
        ComplexNumber x = new ComplexNumberImpl(5,2);
        System.out.println(z.equals(x));

    }
}
