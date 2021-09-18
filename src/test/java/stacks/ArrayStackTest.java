/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

import edu.upb.stacks.ArrayStack;
import edu.upb.models.MyException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for BoundedStack.
 */
public class ArrayStackTest extends BaseStackTest {
    private static final int CAPACITY = 40;

    @Before
    public void makeBoundedStack() {
        s = new ArrayStack(CAPACITY);
    }

    @Test(expected = MyException.class)
    public void testPushToFullStack() {
        for (int i = 0; i < CAPACITY; i++) {
            s.push("Element "+i);
        }
        s.push("abc");
    }
}