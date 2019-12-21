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
        Assert.assertEquals(null, binarySearchTree.search(-1));
        Assert.assertEquals(new Node(5), binarySearchTree.search(5));
        Assert.assertEquals(new Node(18), binarySearchTree.search(18));
        Assert.assertEquals(new Node(22), binarySearchTree.search(22));
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
    public void travelInOrder() {
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
        Assert.assertEquals("5 6 7 8 10 12 15 18 20 22", binarySearchTree.travel(TravelType.INORDER));
    }

    @Test
    public void travelPreOrder() {
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
        Assert.assertEquals("15 10 6 5 7 8 12 20 18 22", binarySearchTree.travel(TravelType.PREORDER));
    }

    @Test
    public void travelPosOrder() {
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
        Assert.assertEquals("5 8 7 6 12 10 18 22 20 15", binarySearchTree.travel(TravelType.POSTORDER));
    }

    @Test
    public void removeRootLeaf() {
        binarySearchTree.insert(15);
        Assert.assertEquals(new Node(15), binarySearchTree.remove(15));
        Assert.assertEquals(0, binarySearchTree.size());
    }

    @Test
    public void removeLeaf() {
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

        Assert.assertEquals(new Node(5), binarySearchTree.remove(5));
        Assert.assertEquals(9, binarySearchTree.size());

        Assert.assertEquals(new Node(8), binarySearchTree.remove(8));
        Assert.assertEquals(8, binarySearchTree.size());

        Assert.assertEquals(new Node(12), binarySearchTree.remove(12));
        Assert.assertEquals(7, binarySearchTree.size());

        Assert.assertEquals(new Node(22), binarySearchTree.remove(22));
        Assert.assertEquals(6, binarySearchTree.size());

        Assert.assertEquals(new Node(7), binarySearchTree.remove(7));
        Assert.assertEquals(5, binarySearchTree.size());

        Assert.assertEquals(new Node(6), binarySearchTree.remove(6));
        Assert.assertEquals(4, binarySearchTree.size());
    }

    @Test
    public void removeOnlyOneChild() {
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

        Assert.assertEquals(new Node(7), binarySearchTree.remove(7));
        Assert.assertEquals(9, binarySearchTree.size());
    }

    @Test
    public void removeRootOnlyOneRightChild() {
        binarySearchTree.insert(15);
        binarySearchTree.insert(16);
        Assert.assertEquals(new Node(15), binarySearchTree.remove(15));
        Assert.assertEquals(1, binarySearchTree.size());
    }

    @Test
    public void removeRootOnlyOneLeftChild() {
        binarySearchTree.insert(15);
        binarySearchTree.insert(14);
        Assert.assertEquals(new Node(15), binarySearchTree.remove(15));
        Assert.assertEquals(1, binarySearchTree.size());
    }

    @Test
    public void removeRootOnlyTwoLeftGrandChild() {
        binarySearchTree.insert(20);
        binarySearchTree.insert(14);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        Assert.assertEquals(new Node(20), binarySearchTree.remove(20));
        Assert.assertEquals(3, binarySearchTree.size());
    }

    @Test
    public void removeRootOnlyOneLeftGrandChild() {
        binarySearchTree.insert(20);
        binarySearchTree.insert(14);
        binarySearchTree.insert(5);
        Assert.assertEquals(new Node(20), binarySearchTree.remove(20));
        Assert.assertEquals(2, binarySearchTree.size());
    }

    @Test
    public void removeRootOnlyTwoRightGrandChild() {
        binarySearchTree.insert(20);
        binarySearchTree.insert(25);
        binarySearchTree.insert(22);
        binarySearchTree.insert(26);
        Assert.assertEquals(new Node(20), binarySearchTree.remove(20));
        Assert.assertEquals(3, binarySearchTree.size());
    }

    @Test
    public void removeRootOnlyOneRightGrandChild() {
        binarySearchTree.insert(20);
        binarySearchTree.insert(25);
        binarySearchTree.insert(26);
        Assert.assertEquals(new Node(20), binarySearchTree.remove(20));
        Assert.assertEquals(2, binarySearchTree.size());
    }

    @Test
    public void removeRootWithTwoChildren() {
        binarySearchTree.insert(20);
        binarySearchTree.insert(19);
        binarySearchTree.insert(26);
        Assert.assertEquals(new Node(20), binarySearchTree.remove(20));
        Assert.assertEquals(2, binarySearchTree.size());
        Assert.assertEquals(Integer.valueOf(26), binarySearchTree.getRoot().getValue());
    }

    @Test
    public void removeRootWithTwoChildren1() {
        binarySearchTree.insert(20);
        binarySearchTree.insert(10);
        binarySearchTree.insert(26);
        binarySearchTree.insert(25);
        Assert.assertEquals(new Node(20), binarySearchTree.remove(20));
        Assert.assertEquals(3, binarySearchTree.size());
        Assert.assertEquals(Integer.valueOf(25), binarySearchTree.getRoot().getValue());

    }

    @Test
    public void removeRootWithTwoChildren2() {
        binarySearchTree.insert(20);
        binarySearchTree.insert(10);
        binarySearchTree.insert(26);
        binarySearchTree.insert(11);
        Assert.assertEquals(new Node(20), binarySearchTree.remove(20));
        Assert.assertEquals(3, binarySearchTree.size());
        Assert.assertEquals(Integer.valueOf(26), binarySearchTree.getRoot().getValue());
    }

    @Test
    public void height1() {
        binarySearchTree.insert(20);
        binarySearchTree.insert(10);
        binarySearchTree.insert(26);
        binarySearchTree.insert(11);
        Assert.assertEquals(3, binarySearchTree.height());
    }

    @Test
    public void height2() {
        binarySearchTree.insert(20);
        binarySearchTree.insert(21);
        binarySearchTree.insert(22);
        binarySearchTree.insert(23);
        binarySearchTree.insert(26);
        binarySearchTree.insert(25);
        binarySearchTree.insert(27);
        Assert.assertEquals(6, binarySearchTree.height());
    }

    @Test
    public void maxWidth() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(20);
        binarySearchTree.insert(70);
        binarySearchTree.insert(10);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(75);
        binarySearchTree.insert(90);
        Assert.assertEquals(4, binarySearchTree.maxWidth());
    }

    @Test
    public void maxWidth2() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(20);
        binarySearchTree.insert(70);
        binarySearchTree.insert(10);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(75);
        binarySearchTree.insert(90);
        binarySearchTree.insert(35);
        binarySearchTree.insert(65);
        Assert.assertEquals(4, binarySearchTree.maxWidth());
    }

    @Test
    public void maxWidth3() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(20);
        binarySearchTree.insert(70);
        binarySearchTree.insert(10);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(75);
        binarySearchTree.insert(90);
        binarySearchTree.insert(35);
        binarySearchTree.insert(65);
        binarySearchTree.insert(5);
        Assert.assertEquals(5, binarySearchTree.maxWidth());
    }

    @Test
    public void maxWidth4() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(20);
        binarySearchTree.insert(70);
        Assert.assertEquals(2, binarySearchTree.maxWidth());
    }

    @Test
    public void maxWidth5() {
        binarySearchTree.insert(50);
        Assert.assertEquals(1, binarySearchTree.maxWidth());
    }

    @Test
    public void maxWidth6() {
        Assert.assertEquals(0, binarySearchTree.maxWidth());
    }

    @Test
    public void maxWidth7() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(70);
        binarySearchTree.insert(80);
        binarySearchTree.insert(75);
        binarySearchTree.insert(90);
        Assert.assertEquals(2, binarySearchTree.maxWidth());
    }

    @Test
    public void isFullBinaryTree1() {
        Assert.assertEquals(false, binarySearchTree.isFullBinaryTree());
    }

    @Test
    public void isFullBinaryTree2() {
        binarySearchTree.insert(50);
        Assert.assertEquals(true, binarySearchTree.isFullBinaryTree());
    }

    @Test
    public void isFullBinaryTree3() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(20);
        binarySearchTree.insert(60);
        Assert.assertEquals(true, binarySearchTree.isFullBinaryTree());
    }

    @Test
    public void isFullBinaryTree4() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(60);
        Assert.assertEquals(false, binarySearchTree.isFullBinaryTree());
    }

    @Test
    public void isFullBinaryTree5() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(20);
        Assert.assertEquals(false, binarySearchTree.isFullBinaryTree());
    }

    @Test
    public void isFullBinaryTree6() {
        binarySearchTree.insert(50);
        binarySearchTree.insert(20);
        binarySearchTree.insert(60);
        binarySearchTree.insert(61);
        Assert.assertEquals(false, binarySearchTree.isFullBinaryTree());
    }

    @Test
    public void isFullBinaryTree7() {
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(15);
        binarySearchTree.insert(25);
        binarySearchTree.insert(35);
        binarySearchTree.insert(45);
        Assert.assertEquals(true, binarySearchTree.isFullBinaryTree());
    }

    @Test
    public void sumAllNodes1() {
        Assert.assertEquals(0, binarySearchTree.sumAllNodes());
    }

    @Test
    public void sumAllNodes2() {
        binarySearchTree.insert(0);
        Assert.assertEquals(0, binarySearchTree.sumAllNodes());
    }

    @Test
    public void sumAllNodes3() {
        binarySearchTree.insert(10);
        Assert.assertEquals(10, binarySearchTree.sumAllNodes());
    }

    @Test
    public void sumAllNodes4() {
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        Assert.assertEquals(15, binarySearchTree.sumAllNodes());
    }

    @Test
    public void sumAllNodes5() {
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        Assert.assertEquals(17, binarySearchTree.sumAllNodes());
    }

    @Test
    public void sumAllNodes6() {
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(20);
        Assert.assertEquals(40, binarySearchTree.sumAllNodes());
    }

    @Test
    public void subTreesProportions1() {
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        Assert.assertEquals(0.5, binarySearchTree.subTreesProportions().getLeft(), 0.001);
        Assert.assertEquals(0.5, binarySearchTree.subTreesProportions().getRight(), 0.001);
    }

    @Test
    public void subTreesProportions2() {
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        Assert.assertEquals(1.0, binarySearchTree.subTreesProportions().getLeft(), 0.001);
        Assert.assertEquals(0.0, binarySearchTree.subTreesProportions().getRight(), 0.001);
    }

    @Test
    public void subTreesProportions3() {
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        Assert.assertEquals(0.75, binarySearchTree.subTreesProportions().getLeft(), 0.001);
        Assert.assertEquals(0.25, binarySearchTree.subTreesProportions().getRight(), 0.001);
    }

    @Test
    public void subTreesProportions4() {
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(9);
        binarySearchTree.insert(10);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        Assert.assertEquals(0.375, binarySearchTree.subTreesProportions().getLeft(), 0.001);
        Assert.assertEquals(0.625, binarySearchTree.subTreesProportions().getRight(), 0.001);
    }

    @Test
    public void subTreesProportions5() {
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(9);
        binarySearchTree.insert(10);
        binarySearchTree.insert(11);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        Assert.assertEquals(0.333, binarySearchTree.subTreesProportions().getLeft(), 0.001);
        Assert.assertEquals(0.666, binarySearchTree.subTreesProportions().getRight(), 0.001);
    }

}