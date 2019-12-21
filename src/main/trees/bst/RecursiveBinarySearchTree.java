package main.trees.bst;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RecursiveBinarySearchTree {

    private Node root;

    public Node search(Integer element) {
        if(element == null) {
            throw new IllegalArgumentException("Element must not be null.");
        }
        if(root == null) {
            return null;
        }
        return root.search(root, element);
    }

    public void insert(Integer element) {
        if(element == null) {
            throw new IllegalArgumentException("Element must not be null.");
        }
        if(root == null) {
            root = new Node(element);
            return;
        }
        root.insert(root, element);
    }

    public Node remove(Integer element) {
        if(element == null) {
            throw new IllegalArgumentException("Element must not be null.");
        }
        if(root == null) {
            return null;
        }
        final Node search = root.search(root, element);
        if(search == null) {
            return null;
        }
        final Node removed = root.remove(search);
        if(root.equals(removed)) {

            root = null;
        }
        return removed;
    }

    public List<Node> searchAllLeaves() {
        if(root == null) {
            return new ArrayList<>();
        }
        return root.searchAllLeaves(root);
    }

    public String travel(TravelType travelType) {
        if(travelType == null) {
            throw new IllegalArgumentException("Travel type must not be null.");
        }
        if(root == null) {
            return "";
        }
        return root.travel(root, travelType).trim();
    }

    public String insertedTravel(TravelType travelType) {
        if(travelType == null) {
            throw new IllegalArgumentException("Travel type must not be null.");
        }
        if(root == null) {
            return "";
        }
        return root.travel(root, travelType, true).trim();
    }

    public int size() {
        if(root == null) {
            return 0;
        }
        return root.size(root);
    }

    public void clear() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root.height(root);
    }

    public int maxWidth() {
        final Map<Integer, Integer> map = new HashMap<>();
        if(root == null) {
            return 0;
        }
        root.maxWidth(root, 0, map);
        final Integer max = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        return max;
    }

    public boolean isFullBinaryTree() {
        if(root == null) {
            return false;
        }
        return root.isFullBinaryTree(root);
    }

    public int sumAllNodes() {
        if(root == null) {
            return 0;
        }
        return root.sumAllNodes(root);
    }

    public ProportionTuple subTreesProportions() {
        if(root == null) {
            return new ProportionTuple(0, 0);
        }
        final Tuple<Integer> tuple = root.subTreesProportions(root);
        return new ProportionTuple(tuple.getLeft()*1.0 / (tuple.getLeft() + tuple.getRight()), tuple.getRight()*1.0 / (tuple.getLeft() + tuple.getRight()));
    }
}
