package hacs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sajith
 */
public class SolutionTest {
    
    /**
     * Test of isReported method, of class Solution.
     */
    @Test
    public void testIsReported1() {
        Solution instance = new Solution();
        boolean expResult = false;
        boolean result = instance.isReported();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsReported2() {
        Solution instance = new Solution();
        instance.setReported(true);
        boolean expResult = true;
        boolean result = instance.isReported();
        assertEquals(expResult, result);
    }
    
}
