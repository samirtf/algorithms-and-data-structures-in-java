package main.trees.bst;

import java.util.Objects;

public class ProportionTuple {

    private double left;
    private double right;

    public ProportionTuple(double left, double right) {
        this.left = left;
        this.right = right;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProportionTuple that = (ProportionTuple) o;
        return Double.compare(that.left, left) == 0 &&
                Double.compare(that.right, right) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "ProportionTuple{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
