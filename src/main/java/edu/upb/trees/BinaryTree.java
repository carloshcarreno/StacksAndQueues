/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.trees;

import edu.upb.models.ITree;
import edu.upb.models.TreeNode;

/**
 *
 * @author cahuc
 */
public class BinaryTree implements ITree {

    private TreeNode root = null;

    @Override
    public void add(int value) {
        root = addRecursive(value, root);
    }

    public TreeNode addRecursive(int value, TreeNode current) {

        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.getValue()) {
            current.setLeft(addRecursive(value, current.getLeft()));
        } else if (value > current.getValue()) {
            current.setRight(addRecursive(value, current.getRight()));
        } else {
            System.out.println("¡El valor ya existe!");
            return current;
        }

        return current;
    }

    @Override
    public boolean contains(int value) {
        return containsRecursive(value, root);
    }

    public boolean containsRecursive(int value, TreeNode current) {

        if (current == null) {
            return false;
        } else if (current.getValue() == value) {
            return true;
        }

        if (value < current.getValue()) {
            return containsRecursive(value, current.getLeft());
        } else {
            return containsRecursive(value, current.getRight());
        }

        /*
        return value < current.getValue()
                ? containsRecursive(value, current.getLeft())
                : containsRecursive(value, current.getRight());
         */
    }

    @Override
    public void delete(int value) {
        root = deleteRecursive(value, root);
    }

    public TreeNode deleteRecursive(int value, TreeNode current) {

        if (current == null) {
            return null;
        } else if (current.getValue() == value) {

            // Case 1: Doesn't have children
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            // Case 2: It has at least ONE children
            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            // Case 3: Does have 2 children
            int smallestValue = findSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursive(smallestValue, current.getRight()));
            return current;

        }

        if (value < current.getValue()) {
            current.setLeft(deleteRecursive(value, current.getLeft()));
            return current;
        } else {
            current.setRight(deleteRecursive(value, current.getRight()));
            return current;
        }
    }

    private int findSmallestValue(TreeNode current) {
        return current.getLeft() == null
                ? current.getValue()
                : findSmallestValue(current.getLeft());
    }

    public void traverseInOrder(TreeNode current) {

        if (current != null) {
            traverseInOrder(current.getLeft());
            System.out.println("" + current.getValue());
            traverseInOrder(current.getRight());
        }
    }

    public void traversePreOrder(TreeNode current) {

        if (current != null) {
            System.out.println("" + current.getValue());
            traversePreOrder(current.getLeft());
            traversePreOrder(current.getRight());
        }
    }

    public void traversePostOrder(TreeNode current) {

        if (current != null) {
            traversePostOrder(current.getLeft());
            traversePostOrder(current.getRight());
            System.out.println(""+current.getValue());
        }
    }

    @Override
    public int getRootValue() {
        return root.getValue();
    }

}
