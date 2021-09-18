/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.stacks;

import edu.upb.models.MyException;
import edu.upb.models.Node;
import edu.upb.models.IStack;

/**
 *
 * @author cahuc
 */
public class LinkedStack implements IStack {

    private Node top = null;

    public void push(Object item) {
        top = new Node(item, top);
    }

    public Object pop() {

        if (top == null) {
            throw new MyException("Cannot pop from empty stack");
        }

        Object item = peek();
        top = top.next;
        return item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Object peek() {
        if (top == null) {
            throw new MyException("Cannot peek from empty stack");
        }
        return top.data;
    }

    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = node.next) {
            count++;
        }
        return count;
    }
}
