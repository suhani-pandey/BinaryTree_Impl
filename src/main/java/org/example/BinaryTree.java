package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryTree<E> {
    private BinaryTreeNode<E> root;

    public BinaryTree(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public boolean contains(E element){
        return root.getElement().equals(element);
    }

    public ArrayList<E> inOrder(){
        ArrayList<E> result=new ArrayList<>();
        printInOrder(root,result);
        if (result.isEmpty()){
            return null;
        }
        else {
            return result;
        }
    }

    private void printInOrder(BinaryTreeNode<E> node, ArrayList<E> result){
        if (node !=null){
            printInOrder(node.getLeftChild(),result);
            result.add(node.getElement());
            printInOrder(node.getRightChild(),result);
        }
    }

    public ArrayList<E>  preOrder(){
        ArrayList<E> result=new ArrayList<>();
        printPreOrder(root,result);
        if (result.isEmpty()){
            return null;
        }
        else {
            return result;
        }
    }

    private void printPreOrder(BinaryTreeNode<E> node, ArrayList<E> result){
        if (node!=null){
            result.add(node.getElement());
            printPreOrder(node.getLeftChild(),result);
            printPreOrder(node.getRightChild(),result);
        }
    }

    public ArrayList<E> postOrder(){
        ArrayList<E> result=new ArrayList<>();
        printPostOrder(root,result);
        if (result.isEmpty()){
            return null;
        }
        else {
            return result;
        }
    }

    private void printPostOrder(BinaryTreeNode<E> node, ArrayList<E> result){
        if (node!=null){
            printPostOrder(node.getLeftChild(),result);
            printPostOrder(node.getRightChild(),result);
            result.add(node.getElement());
        }
    }

    public ArrayList<E> levelOrder() {
        ArrayList<E> result = new ArrayList<>();
        int height = height(root);

        for (int i = 0; i <= height; i++) {
            printLevel(root, i, result);
        }

        return result.isEmpty() ? null : result;
    }

    private void printLevel(BinaryTreeNode<E> node, int level, ArrayList<E> result) {
        if (node == null) {
            return;
        }

        if (level == 0) {
            result.add(node.getElement());
        } else {
            printLevel(node.getLeftChild(), level - 1, result);
            printLevel(node.getRightChild(), level - 1, result);
        }
    }

    public int height(){
        return height(root);
    }

    private int height(BinaryTreeNode<E> node){
        if (node==null){
            return -1;
        }
        else{
            int leftSideHeight= height(node.getLeftChild());
            int rightSideHeight= height(node.getRightChild());

            if (rightSideHeight>leftSideHeight){
                return (rightSideHeight+1);
            }else {
                return (leftSideHeight+1);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.setLeftChild(new BinaryTreeNode<>(2));
        root.setRightChild(new BinaryTreeNode<>(3));
        root.getLeftChild().setLeftChild(new BinaryTreeNode<>(4));
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(5));

        BinaryTree<Integer> binaryTree = new BinaryTree<>(root);

        System.out.println("In-order traversal: " + binaryTree.inOrder());
        System.out.println("Pre-order traversal: " + binaryTree.preOrder());
        System.out.println("Post-order traversal: " + binaryTree.postOrder());
        System.out.println("Level-order traversal: " + binaryTree.levelOrder());
    }
}


