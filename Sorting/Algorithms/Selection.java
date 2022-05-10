package Sorting.Algorithms;

import Sorting.SortingInterface.SortingAlgorithm;

public class Selection implements SortingAlgorithm {
 
    @Override
    public void sort(int[] arr) {
        // TODO Auto-generated method stub
        for (int i = 0; i < arr.length; ++i) {
            int indexOfMinimumElement = i;

            // find minimum element's index
            for (int j = i; j < arr.length; ++j) {
                if (arr[indexOfMinimumElement] > arr[j]) {
                    indexOfMinimumElement = j;
                }
            }

            /**
             * swap elements
                int temp = arr[indexOfMinimumElement];
                arr[indexOfMinimumElement] = arr[i];
                arr[i] = temp;
             */

             // shift elements to maintain integrity of position of duplicate elements
            int temp = arr[indexOfMinimumElement];
            while (indexOfMinimumElement > i) {
                arr[indexOfMinimumElement] = arr[--indexOfMinimumElement];
            }

            arr[i] = temp;
        }
    }
}
