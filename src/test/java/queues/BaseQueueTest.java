/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;

import edu.upb.models.IQueue;
import edu.upb.models.MyException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Base test for any class that implements the Queue interface.
 */
public abstract class BaseQueueTest {

    /**
     * The queue to use in all the tests: set this in subclasses.
     */
    protected IQueue q;

    @Test
    public void givenEmptyQueue_WhenIsEmpty_ThenIsEmpty() {
        assertTrue(q.isEmpty());
        assertEquals(q.size(), 0);
    }

    @Test
    public void givenEmptyQueue_WhenenqueueElements_ThenIsNotEmptyAndSizeIsCorrect() {
        int numberOfInserts = 6;
        for (int i = 0; i < numberOfInserts; i++) {
            q.enqueue("zzz");
        }
        assertTrue(!q.isEmpty());
        assertEquals(q.size(), numberOfInserts);
    }

    @Test
    public void givenEmptyStack_WhenEnqueueElement_ThenDequeueSameElement() {
        String message = "hello";
        q.enqueue(message);
        assertEquals(message, q.dequeue());
    }

    @Test
    public void givenEmptyStack_WhenEnqueueElement_ThenPeekSameElement() {
        String message = "hello";
        q.enqueue(message);
        int size = q.size();
        assertEquals(q.peek(), message);
        assertEquals(q.size(), size);
    }

    @Test
    public void givenNotEmptyQueue_WhenEnqueueAllElements_ThenQueueIsEmpty() {
        int numberOfRemoves = (int) (Math.random() * 20 + 1);
        for (int i = 0; i < numberOfRemoves; i++) {
            q.enqueue("zzz");
        }
        for (int i = 0; i < numberOfRemoves; i++) {
            q.dequeue();
        }
        assertTrue(q.isEmpty());
        assertEquals(q.size(), 0);
    }

    @Test(expected = MyException.class)
    public void givenAnEmptyQueue_WhenDequeueElement_ThenThrowsException() {
        assertTrue(q.isEmpty());
        q.dequeue();
    }

    @Test(expected = MyException.class)
    public void givenAnEmptyQueue_WhenPeekElement_ThenThrowsException() {
        assertTrue(q.isEmpty());
        q.peek();
    }
}