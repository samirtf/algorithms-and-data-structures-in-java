package test;

import main.binarysearch.BinarySearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    private BinarySearch binarySearch;
    private Integer[] data = {2, 3, 5, 6, 8, 9, 10, 12, 13, 15, 16, 17, 19, 20, 22};

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void search() {
        Assert.assertEquals(new Integer(0), binarySearch.search(data, 2));
        Assert.assertEquals(new Integer(1), binarySearch.search(data, 3));
        Assert.assertEquals(new Integer(2), binarySearch.search(data, 5));
        Assert.assertEquals(new Integer(3), binarySearch.search(data, 6));
        Assert.assertEquals(new Integer(4), binarySearch.search(data, 8));
        Assert.assertEquals(new Integer(5), binarySearch.search(data, 9));
        Assert.assertEquals(new Integer(6), binarySearch.search(data, 10));
        Assert.assertEquals(new Integer(7), binarySearch.search(data, 12));
        Assert.assertEquals(new Integer(8), binarySearch.search(data, 13));
        Assert.assertEquals(new Integer(9), binarySearch.search(data, 15));
        Assert.assertEquals(new Integer(10), binarySearch.search(data, 16));
        Assert.assertEquals(new Integer(11), binarySearch.search(data, 17));
        Assert.assertEquals(new Integer(12), binarySearch.search(data, 19));
        Assert.assertEquals(new Integer(13), binarySearch.search(data, 20));
        Assert.assertEquals(new Integer(14), binarySearch.search(data, 22));
    }
}