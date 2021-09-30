/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;

import edu.upb.queues.LinkedQueue;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for LinkedQueue.
 */
public class LinkedQueueTest extends BaseQueueTest {

    @Before
    public void makeLinkedQueue() {
        q = new LinkedQueue();
    }

    @Test
    public void testNothing() {
    }
}