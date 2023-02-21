package is.hi.hbv202g.ass5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntStackTest {
    private IntStack stack;

    @Before
    public void testNewStackIsNotFull() {
        stack= new IntStack();
    }

    @Test
    public void testFullStackIsFull(){
        int cap= stack.getCapacity();
        for (int i= 0; i<cap; i++){
            stack.push(i);
        }
        assertTrue(stack.isFull());
    }

    @Test
    public void testAlmostFullStackIsNotFull(){
        int cap= stack.getCapacity();
        for (int i= 1; i<cap; i++){
            stack.push(i);
        }
        assertFalse(stack.isFull());
    }

    @Test
    public void testPopReturnsPushedValue(){
        for (int j=1; j<4; j++){
            stack.push(j);
        }
        for (int k=4; k<1; k--){
            int pop= stack.pop();
            assertEquals(pop,k);
        }
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testPopOnEmptyStack(){
        stack.pop();
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testPushOnFullStack() {
        int cap = stack.getCapacity();
        for (int i = 0; i < cap + 1; i++) {
            stack.push(i);
        }
    }

    @Test
    public void testEmptyStackIsEmpty(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testNonEmptyStackIsEmpty(){
        for (int i = 0; i < 3 + 1; i++) {
            stack.push(i);
        }
        assertFalse(stack.isEmpty());
    }
}
