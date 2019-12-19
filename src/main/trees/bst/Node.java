package main.trees.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private Node parent;
    private Node left;
    private Node right;
    private Integer value;

    public Node(Integer value) {
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
            return node.search(node.getLeft(), element);
        }
        return node.search(node.getRight(), element);
    }

    public int size(Node node) {
        if(node == null) {
            return 0;
        }
        if(node.isLeaf()) {
            return 1;
        }
        return 1 + (node.hasLeft() ? node.size(node.getLeft()) : 0) + (node.hasRight() ? node.size(node.getRight()) : 0);
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
                node.setLeft(newNode);
            }
        } else {
            if(node.hasRight()) {
                node.insert(node.getRight(), element);
            } else {
                final Node newNode = new Node(element);
                newNode.setParent(node);
                node.setRight(newNode);
            }
        }
    }

    public String travel(Node node, TravelType travelType) {
        String travel = "";
        if(travelType == TravelType.INORDER) {
            if(node.hasLeft()) {
                travel += node.travel(node.getLeft(), travelType);
            }
            travel += node.getValue() + " ";
            if(node.hasRight()) {
                travel += node.travel(node.getRight(), travelType);
            }
        } else if (travelType == TravelType.PREORDER) {
            travel += node.getValue() + " ";
            if(node.hasLeft()) {
                travel += node.travel(node.getLeft(), travelType);
            }
            if(node.hasRight()) {
                travel += node.travel(node.getRight(), travelType);
            }
        } else if (travelType == TravelType.POSTORDER) {
            if(node.hasLeft()) {
                travel += node.travel(node.getLeft(), travelType);
            }
            if(node.hasRight()) {
                travel += node.travel(node.getRight(), travelType);
            }
            travel += node.getValue() + " ";
        }
        return travel;
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

    public Node deepestLeft(Node node) {
        if(node.hasLeft()) {
            return node.deepestLeft(node.getLeft());
        }
        return node;
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

    public Node remove(final Node node) {
        if(node.isLeaf()) {
            if(node.getParent() != null) {
                if(node.getParent().hasLeft() && node.getParent().getLeft().equals(node)) {
                    node.getParent().setLeft(null);
                } else {
                    node.getParent().setRight(null);
                }
            }
            node.setParent(null);
        } else if(node.hasLeft() && node.hasRight()) {
            final Node deepestLeft = node.getRight().deepestLeft(node.getRight());
            final Integer currentValue = node.getValue();
            node.setValue(deepestLeft.getValue());
            deepestLeft.setValue(currentValue);
            return node.remove(deepestLeft);
        } else {
            // only one child
            final Node child = node.hasLeft() ? node.getLeft() : node.getRight();
            if(node.getParent() != null) {
                if(node.getParent().hasLeft() && node.getParent().getLeft().equals(node)) {
                    node.getParent().setLeft(child);
                } else {
                    node.getParent().setRight(child);
                }
                child.setParent(node.getParent());
            } else {
                final Integer currentValue = node.getValue();
                node.setValue(child.getValue());
                if(child.hasLeft()) {
                    node.setLeft(child.getLeft());
                    child.setLeft(null);
                } else {
                    node.setLeft(null);
                }
                if(child.hasRight()) {
                    node.setRight(child.getRight());
                    child.setRight(null);
                } else {
                    node.setRight(null);
                }
                child.setParent(null);
                child.setValue(currentValue);
                return child;
            }
        }
        return node;
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
                "parent=" + (parent != null? parent.getValue() : "") +
                ", left=" + (left != null? left.getValue() : "") +
                ", right=" + (right != null? right.getValue() : "") +
                ", value=" + (value != null? value : "") +
                '}';
    }
}
