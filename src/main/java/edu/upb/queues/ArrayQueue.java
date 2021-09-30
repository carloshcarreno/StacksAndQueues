/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.queues;

import edu.upb.models.IQueue;
import edu.upb.models.MyException;

/**
 *
 * @author cahuc
 */
public class ArrayQueue implements IQueue {

    private Object[] array;
    private int size = 0;
    private int head = 0; // index of the current front item, if one exists
    private int tail = 0; // index of next item to be added

    public ArrayQueue(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public void enqueue(Object item) {
        if (size == array.length) {
            throw new MyException("Cannot add to full queue");
        }

        array[tail] = item;
        tail++;
        size++;
    }

    @Override
    public Object dequeue() {
        if (size == 0) {
            throw new MyException("Cannot remove from empty queue");
        }

        Object item = array[head];

        for (int i = 0; i < tail - 1; i++) {
            array[i] = array[i + 1];
        }

        array[tail - 1] = null;
        tail--;
        size--;

        return item;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            throw new MyException("Cannot peek into empty queue");
        }
        return array[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
