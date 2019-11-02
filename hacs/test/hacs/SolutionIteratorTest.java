package hacs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sajith
 */
public class SolutionIteratorTest {
    
    /**
     * Test of moveToHead method, of class SolutionIterator.
     */
    @Test
    public void testMoveToHead() {
        SolutionIterator instance = new SolutionIterator();
        instance.moveToHead();
        assertEquals(instance.currentSolutionNumber, -1);
    }

    /**
     * Test of hasNext method, of class SolutionIterator.
     */
    @Test(expected = NullPointerException.class)
    public void testHasNext1() {
        SolutionIterator instance = new SolutionIterator();
        boolean expResult = false;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasNext2() {
        SolutionIterator instance = new SolutionIterator();
        instance.solutionlist = new SolutionList();
        boolean expResult = false;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class SolutionIterator.
     */
    @Test (expected = NullPointerException.class)
    public void testNext_0args() {
        SolutionIterator instance = new SolutionIterator();
        Object expResult = null;
        Object result = instance.next();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class SolutionIterator.
     */
    @Test(expected = NullPointerException.class)
    public void testNext_String() {
        String UserName = "";
        SolutionIterator instance = new SolutionIterator();
        Object expResult = null;
        Object result = instance.next(UserName);
        assertEquals(expResult, result);
    }
    
}
