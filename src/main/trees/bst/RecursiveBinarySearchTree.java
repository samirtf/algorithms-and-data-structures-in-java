package main.trees.bst;

import java.util.ArrayList;
import java.util.List;

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
        return root.travel(root, travelType);
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
}