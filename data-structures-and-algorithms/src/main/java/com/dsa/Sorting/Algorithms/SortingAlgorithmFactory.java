package com.dsa.Sorting.Algorithms;

public class SortingAlgorithmFactory {

    public SortingAlgorithm getSortingAlgorithm(String sortingAlgorithmType) {
        if (sortingAlgorithmType == null) {
            return null;
        }
        if (sortingAlgorithmType.equalsIgnoreCase("BUBBLE")) {
            return new Bubble();

        } else if (sortingAlgorithmType.equalsIgnoreCase("INSERTION")) {
            return new Insertion();

        } else if (sortingAlgorithmType.equalsIgnoreCase("SELECTION")) {
            return new Selection();
        }

        return null;
    }
}
