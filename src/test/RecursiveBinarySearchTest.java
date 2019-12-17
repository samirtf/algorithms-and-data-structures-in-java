package test;

import main.binarysearch.RecursiveBinarySearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecursiveBinarySearchTest {

    private RecursiveBinarySearch recursiveBinarySearch;
    private Integer[] data = {2, 3, 5, 6, 8, 9, 10, 12, 13, 15, 16, 17, 19, 20, 22};

    @Before
    public void setUp() {
        recursiveBinarySearch = new RecursiveBinarySearch();
    }

    @Test
    public void search() {
        Assert.assertEquals(Integer.valueOf(0), recursiveBinarySearch.search(data, 2));
        Assert.assertEquals(Integer.valueOf(1), recursiveBinarySearch.search(data, 3));
        Assert.assertEquals(Integer.valueOf(2), recursiveBinarySearch.search(data, 5));
        Assert.assertEquals(Integer.valueOf(3), recursiveBinarySearch.search(data, 6));
        Assert.assertEquals(Integer.valueOf(4), recursiveBinarySearch.search(data, 8));
        Assert.assertEquals(Integer.valueOf(5), recursiveBinarySearch.search(data, 9));
        Assert.assertEquals(Integer.valueOf(6), recursiveBinarySearch.search(data, 10));
        Assert.assertEquals(Integer.valueOf(7), recursiveBinarySearch.search(data, 12));
        Assert.assertEquals(Integer.valueOf(8), recursiveBinarySearch.search(data, 13));
        Assert.assertEquals(Integer.valueOf(9), recursiveBinarySearch.search(data, 15));
        Assert.assertEquals(Integer.valueOf(10), recursiveBinarySearch.search(data, 16));
        Assert.assertEquals(Integer.valueOf(11), recursiveBinarySearch.search(data, 17));
        Assert.assertEquals(Integer.valueOf(12), recursiveBinarySearch.search(data, 19));
        Assert.assertEquals(Integer.valueOf(13), recursiveBinarySearch.search(data, 20));
        Assert.assertEquals(Integer.valueOf(14), recursiveBinarySearch.search(data, 22));
    }
}