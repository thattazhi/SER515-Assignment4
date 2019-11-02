package hacs;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sajith
 */
public class AssignmentTest {
    
    public AssignmentTest() {
    }
    
    /**
     * Test of isOverDue method, of class Assignment.
     */
    @Test
    public void testIsOverDue1() {
        System.out.println("isOverDue");
        Assignment instance = new Assignment();
        instance.setDueDate(new Date());
        boolean expResult = false;
        boolean result = instance.isOverDue();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsOverDue2() {
        System.out.println("isOverDue");
        Assignment instance = new Assignment();
        Date dueDate = new GregorianCalendar(2019, Calendar.OCTOBER, 31).getTime();
        instance.setDueDate(dueDate);
        boolean expResult = true;
        boolean result = instance.isOverDue();
        assertEquals(expResult, result);
    }
 
    @Test
    public void testIsOverDue3() {
        System.out.println("isOverDue");
        Assignment instance = new Assignment();
        instance.setDueDate(new GregorianCalendar(2019, Calendar.NOVEMBER, 30).getTime());
        boolean expResult = false;
        boolean result = instance.isOverDue();
        assertEquals(expResult, result);
    }
}
