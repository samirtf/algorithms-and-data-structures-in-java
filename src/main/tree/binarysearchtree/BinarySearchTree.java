package main.tree.binarysearchtree;

public class BinarySearchTree {

    private BstNode root;

    public void insert(final BstNode node) {
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

    public BstNode find(int element) {
        if(root == null) {
            return null;
        }
        return root.find(element);
    }

    public BstNode remove(int element) {
        if(root == null) {
            return null;
        }
        BstNode foundNode = find(element);
        if(foundNode == null) {
            return null;
        }
        if(foundNode.equals(root)) {
            // todo implement this
        }
        return foundNode.remove();
    }
}
