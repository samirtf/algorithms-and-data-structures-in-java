package test;

import main.Util;
import main.algorithms.sort.InsertionSort;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {

    final int[] sortedData = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void sortWorstCase() {
        int[] data = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(data);

        Assert.assertArrayEquals(sortedData, data);
    }

    @Test
    public void sortBestCase() {
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(data);

        Assert.assertArrayEquals(sortedData, data);
    }

    @Test
    public void sortRandomCase() {
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        InsertionSort insertionSort = new InsertionSort();
        Util.shuffle(data);
        insertionSort.sort(data);
        Assert.assertArrayEquals(sortedData, data);
    }

}