/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.stacks;

import edu.upb.models.MyException;
import edu.upb.models.IStack;

/**
 *
 * @author cahuc
 */
/**
 * An implementation of a stack using a static size array whose
 * capacity is set in its constructor.
 */
public class ArrayStack implements IStack {

    private Object[] array;
    private int size = 0;

    public ArrayStack(int capacity) {
        array = new Object[capacity];
    }

    public void push(Object item) {
        if (size == array.length) {
            throw new MyException("Cannot add to full stack");
        }
        array[size++] = item;
    }

    public Object pop() throws MyException {
        if (size == 0) {
            throw new MyException("Cannot pop from empty stack");
        }
        Object result = array[size - 1];
        array[--size] = null;
        return result;
    }

    public Object peek() throws MyException {
        if (size == 0) {
            throw new MyException("Cannot peek into empty stack");
        }
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
