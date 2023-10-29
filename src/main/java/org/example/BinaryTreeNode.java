package org.example;

public class BinaryTreeNode<E> {

    private E element;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode(E element) {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("Root");
        BinaryTreeNode<String> leftChild = new BinaryTreeNode<>("Left");
        BinaryTreeNode<String> rightChild = new BinaryTreeNode<>("Right");

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);

        System.out.println("Root element: " + root.getElement());
        System.out.println("Left child element: " + root.getLeftChild().getElement());
        System.out.println("Right child element: " + root.getRightChild().getElement());
    }
}
