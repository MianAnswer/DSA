package com.dsa;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import com.dsa.Sorting.Algorithms.*;

import org.junit.*;

public class SortingTest {
    private static final int[] arr = { 220, 168, 415, 432, 367, 205, 425, 141, 225, 32, 487, 398, 15, 397, 12,
            1,
            411, 301, 394, 254, 48, 216, 218, 133, 21, 317, 200, 221, 46, 464 };
    private static final int[] sortedCollectionArr = Arrays.copyOf(arr, arr.length);

    @BeforeClass
    public static void init() {
        Arrays.sort(sortedCollectionArr);
    }

    @Test
    public void selectionSort() {
        SortingAlgorithm sortingAlgorithm = new Selection();

        int[] selectionArr = Arrays.copyOf(arr, arr.length);

        sortingAlgorithm.sort(selectionArr);

        assertArrayEquals(sortedCollectionArr, selectionArr);
    }

    @Test
    public void insertionSort() {
        SortingAlgorithm sortingAlgorithm = new Insertion();

        int[] selectionArr = Arrays.copyOf(arr, arr.length);

        sortingAlgorithm.sort(selectionArr);

        assertArrayEquals(sortedCollectionArr, selectionArr);
    }
}
