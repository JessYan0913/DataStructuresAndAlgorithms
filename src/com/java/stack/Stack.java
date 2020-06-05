package com.java.stack;

import java.util.Arrays;

public class Stack {

    private long[] array;

    private int top;

    public Stack() {
        array = new long[10];
        top = -1;
    }

    public Stack(int length) {
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        array = new long[length];
        top = -1;
    }

    public void put(long value) {
        if (isFull()) {
            return;
        }
        array[++top] = value;
    }

    public long prop() {
        return array[top--];
    }

    public long showTop() {
        return array[top];
    }

    public int size() {
        return Math.max(top, 0);
    }

    public void show() {
        long[] longs = Arrays.stream(array).limit(top + 1).toArray();
        System.out.println(Arrays.toString(longs));
    }

    public boolean isFull() {
        return top == array.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

}
