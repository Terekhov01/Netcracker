package ru.skillbench.tasks.basics.math;

import java.util.Arrays;
import java.util.Objects;

public class ComplexNumberImpl implements ComplexNumber{
    private double re;
    private double im;

    public ComplexNumberImpl(double re, double im){
        this.re = re;
        this.im = im;
    }

    public ComplexNumberImpl(String value){
        if(value.contains("*") || value.contains("j")) throw new NumberFormatException();
        char[] arr = value.toCharArray();
        String number = "";
        if(arr[arr.length - 1] == 'i') {
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] == '+' || arr[i] == '-') {
                    number = arr[i] + number;
                    if (number.length() == 1)
                        im = Double.parseDouble(number + 1);
                    else
                        im = Double.parseDouble(number);
                    number = "";
                    for (int j = 0; j < i; j++) {
                        number = number + arr[j];
                    }
                    if (!number.isEmpty()) {
                        re = Double.parseDouble(number);
                        number = "";
                    }
                    break;
                }
                number = arr[i] + number;
            }
            if (!number.isEmpty())
                im = Double.parseDouble(number);

        }
        else{
            for (int j=0;j<arr.length;j++){
                number = number + arr[j];
            }
            if (!number.isEmpty())
                re = Double.parseDouble(number);
        }
    }

    public ComplexNumberImpl(){
        re=0; im=0;
    }

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        return im == 0;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        if(value.contains("*") || value.contains("j")) throw new NumberFormatException();
        char[] arr = value.toCharArray();
        String number = "";
        if(arr[arr.length - 1] == 'i') {
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] == '+' || arr[i] == '-') {
                    number = arr[i] + number;
                    if (number.length() == 1)
                        im = Double.parseDouble(number + 1);
                    else
                        im = Double.parseDouble(number);
                    number = "";
                    for (int j = 0; j < i; j++) {
                        number = number + arr[j];
                    }
                    if (!number.isEmpty()) {
                        re = Double.parseDouble(number);
                        number = "";
                    }
                    else
                        re = 0;
                    break;
                }
                number = arr[i] + number;
            }
            if (!number.isEmpty()) {
                im = Double.parseDouble(number);
                re = 0;
            }
        }
        else{
            im = 0;
            for (int j=0;j<arr.length;j++){
                number = number + arr[j];
            }
            if (!number.isEmpty())
                re = Double.parseDouble(number);
        }
    }

    @Override
    public ComplexNumber copy() {
        return new ComplexNumberImpl(this.re, this.im);
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return this.copy();
    }

    public String toString(){
        if(re == 0 && im != 0){
            return im + "i";
        }
        if(re != 0 && im == 0){
            return ""+re;
        }
        if(re != 0 && im != 0){
            if(im > 0)
                return re + "+" + im + "i";
            return "" + re + im + "i";
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumberImpl that = (ComplexNumberImpl) o;
        return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    @Override
    public int compareTo(ComplexNumber other) {
        double mod1 = Math.pow(this.re,2)+Math.pow(this.im,2);
        double mod2 = Math.pow(other.getRe(),2)+Math.pow(other.getIm(),2);
        if (mod1 < mod2)
            return -1;
        if (mod1 == mod2)
            return 0;
        return 1;
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        this.set(-re,-im);
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.set(this.re + arg2.getRe(), this.im + arg2.getIm());
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        this.set(this.re*arg2.getRe() - this.im*arg2.getIm(),
                this.im*arg2.getRe() + this.re*arg2.getIm());
        return this;
    }
}
