package test;

import main.tree.binarysearchtree.BinarySearchTree;
import main.tree.binarysearchtree.BstNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void setUp() {
        binarySearchTree = new BinarySearchTree();
    }

    @Before
    public void tearDown() {
        binarySearchTree = new BinarySearchTree();
        binarySearchTree.clear();
    }

    @Test
    public void insert() {
        Assert.assertEquals(0, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(2));
        Assert.assertEquals(1, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(3));
        Assert.assertEquals(2, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(55));
        Assert.assertEquals(3, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(5));
        Assert.assertEquals(4, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(6));
        Assert.assertEquals(5, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(8));
        Assert.assertEquals(6, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(9));
        Assert.assertEquals(7, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(10));
        Assert.assertEquals(8, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(12));
        Assert.assertEquals(9, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(13));
        Assert.assertEquals(10, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(15));
        Assert.assertEquals(11, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(16));
        Assert.assertEquals(12, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(17));
        Assert.assertEquals(13, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(19));
        Assert.assertEquals(14, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(20));
        Assert.assertEquals(15, binarySearchTree.size());
        binarySearchTree.insert(new BstNode(22));
        Assert.assertEquals(16, binarySearchTree.size());
    }

    @Test
    public void find() {
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(55));
        binarySearchTree.insert(new BstNode(5));
        binarySearchTree.insert(new BstNode(6));
        binarySearchTree.insert(new BstNode(8));
        binarySearchTree.insert(new BstNode(9));
        binarySearchTree.insert(new BstNode(10));
        binarySearchTree.insert(new BstNode(12));
        binarySearchTree.insert(new BstNode(13));
        binarySearchTree.insert(new BstNode(15));
        binarySearchTree.insert(new BstNode(16));
        binarySearchTree.insert(new BstNode(17));
        binarySearchTree.insert(new BstNode(19));
        binarySearchTree.insert(new BstNode(20));
        binarySearchTree.insert(new BstNode(22));

        Assert.assertEquals(null, binarySearchTree.find(-1));
        Assert.assertEquals(null, binarySearchTree.find(1));
        Assert.assertEquals(new BstNode(55), binarySearchTree.find(55));
        Assert.assertEquals(new BstNode(10), binarySearchTree.find(10));
        Assert.assertEquals(new BstNode(22), binarySearchTree.find(22));
    }

    @Test
    public void size() {
        Assert.assertEquals(true, true);
    }

    @Test
    public void removeOne() {
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(1));
        binarySearchTree.insert(new BstNode(3));
        Assert.assertEquals(new BstNode(1), binarySearchTree.remove(1));
    }

    @Test
    public void removeTwo() {
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(1));
        binarySearchTree.insert(new BstNode(3));
        Assert.assertEquals(new BstNode(2), binarySearchTree.remove(2));
    }

    @Test
    public void removeThree() {
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(1));
        binarySearchTree.insert(new BstNode(3));
        Assert.assertEquals(new BstNode(3), binarySearchTree.remove(3));
    }

    @Test
    public void remove04() {
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(1));
        Assert.assertEquals(new BstNode(1), binarySearchTree.remove(1));
    }

    @Test
    public void remove05() {
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(3));
        Assert.assertEquals(new BstNode(3), binarySearchTree.remove(3));
    }

    @Test
    public void remove06() {
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(1));
        Assert.assertEquals(new BstNode(3), binarySearchTree.remove(3));
    }

    @Test
    public void remove07() {
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(1));
        Assert.assertEquals(new BstNode(2), binarySearchTree.remove(2));
    }

    @Test
    public void remove08() {
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(1));
        Assert.assertEquals(new BstNode(1), binarySearchTree.remove(1));
    }

    @Test
    public void remove09() {
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(4));
        binarySearchTree.insert(new BstNode(5));
        binarySearchTree.insert(new BstNode(7));
        binarySearchTree.insert(new BstNode(6));
        Assert.assertEquals(new BstNode(4), binarySearchTree.remove(4));
    }

    @Test
    public void remove10() {
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(4));
        binarySearchTree.insert(new BstNode(5));
        binarySearchTree.insert(new BstNode(7));
        binarySearchTree.insert(new BstNode(6));
        Assert.assertEquals(new BstNode(5), binarySearchTree.remove(5));
    }

    @Test
    public void remove11() {
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(4));
        binarySearchTree.insert(new BstNode(5));
        binarySearchTree.insert(new BstNode(7));
        binarySearchTree.insert(new BstNode(6));
        Assert.assertEquals(new BstNode(7), binarySearchTree.remove(7));
    }

    @Test
    public void remove12() {
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(4));
        binarySearchTree.insert(new BstNode(5));
        binarySearchTree.insert(new BstNode(7));
        binarySearchTree.insert(new BstNode(6));
        Assert.assertEquals(new BstNode(6), binarySearchTree.remove(6));
    }


    @Test
    public void remove13() {
        binarySearchTree.insert(new BstNode(5));
        binarySearchTree.insert(new BstNode(1));
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(2));
        Assert.assertEquals(new BstNode(1), binarySearchTree.remove(1));
        binarySearchTree.size();
    }

    @Test
    public void remove14() {
        binarySearchTree.insert(new BstNode(5));
        binarySearchTree.insert(new BstNode(1));
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(2));
        binarySearchTree.insert(new BstNode(0));
        Assert.assertEquals(new BstNode(1), binarySearchTree.remove(1));
        binarySearchTree.size();
    }

    @Test
    public void remove15() {
        binarySearchTree.insert(new BstNode(7));
        binarySearchTree.insert(new BstNode(6));
        binarySearchTree.insert(new BstNode(4));
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(5));
        Assert.assertEquals(new BstNode(4), binarySearchTree.remove(4));
        binarySearchTree.size();
    }

    @Test
    public void remove16() {
        binarySearchTree.insert(new BstNode(7));
        binarySearchTree.insert(new BstNode(6));
        binarySearchTree.insert(new BstNode(4));
        binarySearchTree.insert(new BstNode(3));
        binarySearchTree.insert(new BstNode(5));
        Assert.assertEquals(new BstNode(6), binarySearchTree.remove(6));
        binarySearchTree.size();
    }

}