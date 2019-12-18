package main.trees.bst;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecursiveBinarySearchTreeTest {

    private RecursiveBinarySearchTree binarySearchTree;

    @Before
    public void setUp() {
        binarySearchTree = new RecursiveBinarySearchTree();
    }

    @After
    public void tearDown() {
        binarySearchTree.clear();
    }

    @Test
    public void search() {
    }

    @Test
    public void insert() {
        Assert.assertEquals(0, binarySearchTree.size());
        binarySearchTree.insert(1);
        Assert.assertEquals(1, binarySearchTree.size());
        binarySearchTree.insert(3);
        Assert.assertEquals(2, binarySearchTree.size());
        binarySearchTree.insert(55);
        Assert.assertEquals(3, binarySearchTree.size());
        binarySearchTree.insert(5);
        Assert.assertEquals(4, binarySearchTree.size());
        binarySearchTree.insert(6);
        Assert.assertEquals(5, binarySearchTree.size());
        binarySearchTree.insert(8);
        Assert.assertEquals(6, binarySearchTree.size());
        binarySearchTree.insert(9);
        Assert.assertEquals(7, binarySearchTree.size());
        binarySearchTree.insert(10);
        Assert.assertEquals(8, binarySearchTree.size());
        binarySearchTree.insert(12);
        Assert.assertEquals(9, binarySearchTree.size());
    }

    @Test
    public void searchAllLeaves() {
    }

    @Test
    public void travel() {
        binarySearchTree.insert(15);
        binarySearchTree.insert(20);
        binarySearchTree.insert(10);
        binarySearchTree.insert(6);
        binarySearchTree.insert(12);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(18);
        binarySearchTree.insert(22);
        Assert.assertEquals("5 6 7 8 10 12 15 18 20 22 ", binarySearchTree.travel(TravelType.INORDER));
    }
}