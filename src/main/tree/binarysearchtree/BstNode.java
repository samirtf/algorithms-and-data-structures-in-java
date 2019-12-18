package main.tree.binarysearchtree;

import java.util.Objects;

public class BstNode {
    private BstNode parent;
    private BstNode left;
    private BstNode right;
    private Integer value;

    public BstNode(final Integer value) {
        this.value = value;
    }

    public BstNode getParent() {
        return parent;
    }

    public void setParent(BstNode parent) {
        this.parent = parent;
    }

    public BstNode getLeft() {
        return left;
    }

    public void setLeft(BstNode left) {
        this.left = left;
    }

    public BstNode getRight() {
        return right;
    }

    public void setRight(BstNode right) {
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

    public void insert(final BstNode node) {
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

    public BstNode deepestLeft() {
        if(left == null) {
            return this;
        }
        return left.deepestLeft();
    }

    public BstNode deepestRight() {
        if(right == null) {
            return this;
        }
        return right.deepestLeft();
    }

    public BstNode find(int element) {
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

    public boolean isOnlyChild() {
        return (left == null && right != null) || (left != null && right == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BstNode node = (BstNode) o;
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

    public BstNode remove() {
        // 1st case - is leaf
        if(isLeaf()) {
            if(getParent().getRight() != null && getParent().getRight().equals(this)) {
                getParent().setRight(null);
            } else {
                getParent().setLeft(null);
            }
            setParent(null);
        } else if (getLeft() == null || getRight() == null) {
            // 2nd case - one child
            if(getLeft() != null) {
                getLeft().setParent(getParent());
                if(getParent().getLeft() != null && getParent().getLeft().equals(this)) {
                    getParent().setLeft(getLeft());
                } else {
                    getParent().setRight(getLeft());
                }
            } else {
                getRight().setParent(getParent());
                if(getParent().getLeft() != null && getParent().getLeft().equals(this)) {
                    getParent().setLeft(getRight());
                } else {
                    getParent().setRight(getRight());
                }
            }
            setParent(null);
        } else {
            // 3rd case - two children
            BstNode deepestLeft = getRight().deepestLeft();
            if(deepestLeft.isLeaf()) {
                if(getRight().equals(deepestLeft)) {
                    setValue(deepestLeft.getValue());
                    deepestLeft.setValue(null);
                    deepestLeft.setParent(null);
                    setRight(null);
                } else {
                    setValue(deepestLeft.getValue());
                    deepestLeft.getParent().setLeft(null);
                    deepestLeft.setParent(null);
                }
            } else {
                final int deepestInteger = deepestLeft.getValue();
                deepestLeft.remove();
                setValue(deepestInteger);
            }
        }
        return this;
    }
}
