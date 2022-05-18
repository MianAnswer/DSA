package com.dsa.Sorting.Algorithms;

public class Insertion implements SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            // swap current element to the left until in correct position
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                --j;
            }
        }
    }

}
