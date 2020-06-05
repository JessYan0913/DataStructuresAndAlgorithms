package com.java.sort;

import java.util.Arrays;

public class SimpleSort {

    public static void bubbleSort(long[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    long temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(long[] array) {
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            long temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(long[] array) {
        long minValue;
        int j;
        for (int i = 0; i < array.length; i++) {
            minValue = array[i];
            for (j = i; j > 0; j--) {
                if (minValue < array[j - 1]) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = minValue;
        }
    }

    public static void main(String[] args) {
        long[] array = new long[]{1, 332, 323, 12, 5};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
