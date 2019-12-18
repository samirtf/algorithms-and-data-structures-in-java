package main.trees.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private Node parent;
    private Node left;
    private Node right;
    private Integer value;

    public Node(Integer values) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node search(final Node node, Integer element) {
        if(node == null || element == null) {
            return null;
        }
        if(node.getValue().equals(element)) {
            return node;
        }
        if(element < node.getValue()) {
            return search(node.getLeft(), element);
        }
        return search(node.getRight(), element);
    }

    public void insert(final Node node, Integer element) {
        if(node == null || element == null || node.getValue().equals(element)) {
            return;
        }
        if(element < node.getValue()) {
            if(node.hasLeft()) {
                node.insert(node.getLeft(), element);
            } else {
                final Node newNode = new Node(element);
                newNode.setParent(node);
                node.setLeft(new Node(element));
            }
        } else {
            if(node.hasRight()) {
                node.insert(node.getRight(), element);
            } else {
                final Node newNode = new Node(element);
                newNode.setParent(node);
                node.setRight(new Node(element));
            }
        }
    }

    public void travel(Node node, TravelType travelType) {
        if(travelType == TravelType.INORDER) {
            if(node.hasLeft()) {
                node.travel(node.getLeft(), travelType);
            }
            System.out.println(node.getValue() + " ");
            if(node.hasRight()) {
                node.travel(node.getRight(), travelType);
            }
        } else if (travelType == TravelType.PREORDER) {
            System.out.println(node.getValue() + " ");
            if(node.hasLeft()) {
                node.travel(node.getLeft(), travelType);
            }
            if(node.hasRight()) {
                node.travel(node.getRight(), travelType);
            }
        } else if (travelType == TravelType.POSTORDER) {
            if(node.hasLeft()) {
                node.travel(node.getLeft(), travelType);
            }
            if(node.hasRight()) {
                node.travel(node.getRight(), travelType);
            }
            System.out.println(node.getValue() + " ");
        }
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public List<Node> searchAllLeaves(Node node) {
        List<Node> nodes = new ArrayList<>();
        if(node.isLeaf()) {
            nodes.add(node);
            return nodes;
        }
        if(node.hasLeft()) {
            final List<Node> lefters = node.searchAllLeaves(node.getLeft());
            lefters.forEach(fromLeft -> nodes.add(fromLeft));
        }
        if(node.hasRight()) {
            final List<Node> righters = node.searchAllLeaves(node.getRight());
            righters.forEach(fromRight -> nodes.add(fromRight));
        }
        return nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }
}
