package com.freva.projecteuler;

public class ArrayFunctions {
    /**
     * Generates the next lexicographical permutation of array and returns whether such permutation was possible
     * (If this is the last permutation, returns false without changing the array)
     */
    public static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        int j = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;

        if (i <= 0) return false;
        while (array[j] <= array[i - 1])
            j--;

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
        return true;
    }

    public static long sum(int[] numbers) {
        long sum = 0;
        for(Integer number: numbers) {
            sum += number;
        }

        return sum;
    }

    public static int min(int... numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    /**
     * Returns index of the largest element in array
     */
    public static int getIndexOfLargestElement(int array[]) {
        int largestIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[largestIndex]) {
                largestIndex = i;
            }
        }

        return largestIndex;
    }
}
