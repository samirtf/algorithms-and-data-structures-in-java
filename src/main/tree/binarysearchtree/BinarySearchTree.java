package main.tree.binarysearchtree;

public class BinarySearchTree {

    private Node root;

    public void insert(final Node node) {
        if(root == null) {
            root = node;
            return;
        }
        root.insert(node);
    }

    public void clear() {
        root = null;
    }

    public int size() {
        if(root == null) {
            return 0;
        }
        return root.size();
    }

    public Node find(int element) {
        if(root == null) {
            return null;
        }
        return root.find(element);
    }

    public Node remove(int element) {
        if(root == null) {
            return null;
        }
        Node foundNode = find(element);
        if(foundNode == null) {
            return null;
        }
        if(foundNode.equals(root)) {

        }
        return foundNode.remove(element);
    }
}
