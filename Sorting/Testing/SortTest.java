package Sorting.Testing;

import java.util.Arrays;

import Sorting.SortingInterface.SortingAlgorithm;

public class SortTest {
    public static boolean test(SortingAlgorithm sortingAlgorithm) {
        int[] collectionArr = {220, 168, 415, 432, 367, 205, 425, 141, 225, 32, 487, 398, 15, 397, 12, 1, 411, 301, 394, 254, 48, 216, 218, 133, 21, 317, 200, 221, 46, 464};
        int[] selectionArr = Arrays.copyOf(collectionArr, collectionArr.length);

        Arrays.sort(collectionArr);
        System.out.println("Using Arrays.sort = " + Arrays.toString(collectionArr));

        sortingAlgorithm.sort(selectionArr);
        System.out.println("Using selection sort implementation = " + Arrays.toString(selectionArr));

        return Arrays.equals(collectionArr, selectionArr);
    }
}
