package main.algorithms.sort;

/**
 * Loop invariant:
 * At the start of each iteration of the for loop of lines 1–8, the subarray
 * A[1..j - 1] consists of the elements originally in A[1..j - 1], but in sorted
 * order
 */
public class InsertionSort {

    public void sort(final int[] data) {
        int j;
        for(j = 1; j < data.length; j++) {
            int key = data[j];
            // insert A[j] into the sorted sequence A[1..j-1].
            int i = j - 1;
            while(i >= 0 && data[i] > key) {
                data[i + 1] = data[i];
                i = i - 1;
            }
            data[i + 1] = key;
        }
    }

}
