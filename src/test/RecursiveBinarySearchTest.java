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
        Assert.assertEquals(new Integer(0), recursiveBinarySearch.search(data, 2));
        Assert.assertEquals(new Integer(1), recursiveBinarySearch.search(data, 3));
        Assert.assertEquals(new Integer(2), recursiveBinarySearch.search(data, 5));
        Assert.assertEquals(new Integer(3), recursiveBinarySearch.search(data, 6));
        Assert.assertEquals(new Integer(4), recursiveBinarySearch.search(data, 8));
        Assert.assertEquals(new Integer(5), recursiveBinarySearch.search(data, 9));
        Assert.assertEquals(new Integer(6), recursiveBinarySearch.search(data, 10));
        Assert.assertEquals(new Integer(7), recursiveBinarySearch.search(data, 12));
        Assert.assertEquals(new Integer(8), recursiveBinarySearch.search(data, 13));
        Assert.assertEquals(new Integer(9), recursiveBinarySearch.search(data, 15));
        Assert.assertEquals(new Integer(10), recursiveBinarySearch.search(data, 16));
        Assert.assertEquals(new Integer(11), recursiveBinarySearch.search(data, 17));
        Assert.assertEquals(new Integer(12), recursiveBinarySearch.search(data, 19));
        Assert.assertEquals(new Integer(13), recursiveBinarySearch.search(data, 20));
        Assert.assertEquals(new Integer(14), recursiveBinarySearch.search(data, 22));
    }
}