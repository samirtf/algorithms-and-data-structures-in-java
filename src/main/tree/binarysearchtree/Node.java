package main.tree.binarysearchtree;

import java.util.Objects;

public class Node {
    private Node parent;
    private Node left;
    private Node right;
    private Integer value;

    public Node(final Integer value) {
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

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int size() {
        if(isLeaf()) {
            return 1;
        }
        return 1 + (left != null ? left.size() : 0) + (right != null ? right.size() : 0);
    }

    public void insert(final Node node) {
        if(node.getValue() < this.getValue()) {
            if(left == null) {
                left = node;
                node.parent = this;
            } else {
                left.insert(node);
            }
        } else {
            if(right == null) {
                right = node;
                node.parent = this;
            } else {
                right.insert(node);
            }
        }
    }

    public Node deepestLeftLeaf() {
        if(left == null) {
            return this;
        }
        return left.deepestLeftLeaf();
    }

    public Node deepestRightLeaf() {
        if(right == null) {
            return this;
        }
        return right.deepestLeftLeaf();
    }

    public Node find(int element) {
        if(element == getValue()) {
            return this;
        }
        if(element < getValue() && left != null) {
            return left.find(element);
        }
        if(element > getValue() && right != null) {
            return right.find(element);
        }
        return null;
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

    public Node remove(int element) {
//        if (getValue() == element) {
//            if (getRight() != null) {
//                Node deepestLeftLeaf = getRight().deepestLeftLeaf();
//                setValue(deepestLeftLeaf.getValue());
//                if (getRight().getValue().equals(deepestLeftLeaf.getValue())) {
//                    deepestLeftLeaf.getParent().setRight(null);
//                } else {
//                    deepestLeftLeaf.getParent().setLeft(null);
//                }
//            }
//            return this;
//        } else {
//            // recursion
//            getLeft().remove(element)
//        }
//        return remove(element);
        throw new IllegalStateException("Not implemented exception");
    }
}
