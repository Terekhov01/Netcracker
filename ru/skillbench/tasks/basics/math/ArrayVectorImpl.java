package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector{
    double[] elements;

    public ArrayVectorImpl(double... elems){
        elements = elems;
    }

    public ArrayVectorImpl(){}

    @Override
    public void set(double... elements) {
        this.elements = elements;
    }

    @Override
    public double[] get() {
        return elements;
    }

    @Override
    public ArrayVector clone() {
        ArrayVectorImpl copy = new ArrayVectorImpl();
        copy.elements = elements.clone();
        return copy;
    }

    @Override
    public int getSize() {
        return elements.length;
    }

    @Override
    public void set(int index, double value) {
        if(index >= elements.length) {
            double[] newElems = new double[index+1];
            for(int i=0;i<elements.length;i++){
                newElems[i] = elements[i];
            }
            newElems[index] = value;
            elements = newElems;
        }
        else if (index >= 0){
            elements[index] = value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= elements.length) throw new ArrayIndexOutOfBoundsException();
        return elements[index];
    }

    @Override
    public double getMax() {
        return Arrays.stream(elements).max().getAsDouble();
    }

    @Override
    public double getMin() {
        return Arrays.stream(elements).min().getAsDouble();
    }

    @Override
    public void sortAscending() {
        elements = Arrays.stream(elements).sorted().toArray();
    }

    @Override
    public void mult(double factor) {
        for(int i=0;i<elements.length;i++){
            elements[i]*=factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int end = 0;
        end = elements.length <= anotherVector.getSize() ? elements.length : anotherVector.getSize();
        for(int i=0;i<end;i++){
            elements[i]+=anotherVector.get(i);
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        int end = 0;
        end = elements.length <= anotherVector.getSize() ? elements.length : anotherVector.getSize();
        double sum = 0;
        for(int i=0;i<end;i++){
            sum += elements[i]*anotherVector.get(i);
        }
        return sum;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(scalarMult(this));
    }
}
