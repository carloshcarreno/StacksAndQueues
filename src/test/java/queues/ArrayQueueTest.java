/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;

import edu.upb.models.MyException;
import edu.upb.queues.ArrayQueue;
import edu.upb.queues.LinkedQueue;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for BoundedQueue.
 */
public class ArrayQueueTest extends BaseQueueTest {
    private static int CAPACITY = 21;

    @Before
    public void makeBoundedQueue() {
        q = new ArrayQueue(CAPACITY);
    }

    @Test(expected = MyException.class)
    public void givenFullQueue_WhenEnqueueElement_ThenThrowsException() {
        for (int i = 0; i < CAPACITY; i++) {
            q.enqueue("abc");
        }
        q.enqueue("abc");
    }
}