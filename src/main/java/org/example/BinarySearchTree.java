package org.example;

import java.util.NoSuchElementException;

public class BinarySearchTree<E> extends BinaryTree<E>{

    private BinaryTreeNode<E> root;

    public BinarySearchTree(BinaryTreeNode<E> root, BinaryTreeNode<E> root1) {
        super(root);
        root=null;
    }

    public boolean insert(E element){
        if (contains(element)){
            return false;
        }
        root=insert(element,root);
        return true;
    }

    private BinaryTreeNode<E> insert(E element, BinaryTreeNode<E> node) {
        if (node == null) {
            return new BinaryTreeNode<>(element);
        }

        if (element instanceof Comparable) {
            @SuppressWarnings("unchecked")
            Comparable<E> comparableElement = (Comparable<E>) element;
            if (comparableElement.compareTo(node.getElement()) < 0) {
                node.setLeftChild(insert(element, node.getLeftChild()));
            } else {
                node.setRightChild(insert(element, node.getRightChild()));
            }
        } else {
            throw new IllegalArgumentException("Elements must be comparable");
        }

        return node;
    }


    public E findMin() {
        if (root == null) {
            throw new NoSuchElementException("The tree is empty");
        }
        return findMin(root);
    }

    private E findMin(BinaryTreeNode<E> node) {
        if (node.getLeftChild() == null) {
            return node.getElement();
        }
        return findMin(node.getLeftChild());
    }

    public E findMax() {
        if (root == null) {
            throw new NoSuchElementException("The tree is empty");
        }
        return findMax(root);
    }

    private E findMax(BinaryTreeNode<E> node) {
        if (node.getRightChild() == null) {
            return node.getElement();
        }
        return findMax(node.getRightChild());
    }

}



