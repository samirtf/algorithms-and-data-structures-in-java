package test;

import main.binarysearch.IterativeBinarySearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IterativeBinarySearchTest {

    private IterativeBinarySearch iterativeBinarySearch;
    private Integer[] data = {2, 3, 5, 6, 8, 9, 10, 12, 13, 15, 16, 17, 19, 20, 22};

    @Before
    public void setUp() {
        iterativeBinarySearch = new IterativeBinarySearch();
    }

    @Test
    public void search() {
        Assert.assertEquals(Integer.valueOf(0), iterativeBinarySearch.search(data, 2));
        Assert.assertEquals(Integer.valueOf(1), iterativeBinarySearch.search(data, 3));
        Assert.assertEquals(Integer.valueOf(2), iterativeBinarySearch.search(data, 5));
        Assert.assertEquals(Integer.valueOf(3), iterativeBinarySearch.search(data, 6));
        Assert.assertEquals(Integer.valueOf(4), iterativeBinarySearch.search(data, 8));
        Assert.assertEquals(Integer.valueOf(5), iterativeBinarySearch.search(data, 9));
        Assert.assertEquals(Integer.valueOf(6), iterativeBinarySearch.search(data, 10));
        Assert.assertEquals(Integer.valueOf(7), iterativeBinarySearch.search(data, 12));
        Assert.assertEquals(Integer.valueOf(8), iterativeBinarySearch.search(data, 13));
        Assert.assertEquals(Integer.valueOf(9), iterativeBinarySearch.search(data, 15));
        Assert.assertEquals(Integer.valueOf(10), iterativeBinarySearch.search(data, 16));
        Assert.assertEquals(Integer.valueOf(11), iterativeBinarySearch.search(data, 17));
        Assert.assertEquals(Integer.valueOf(12), iterativeBinarySearch.search(data, 19));
        Assert.assertEquals(Integer.valueOf(13), iterativeBinarySearch.search(data, 20));
        Assert.assertEquals(Integer.valueOf(14), iterativeBinarySearch.search(data, 22));
    }
}