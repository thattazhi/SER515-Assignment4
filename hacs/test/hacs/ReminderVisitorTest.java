package hacs;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sajith
 */
public class ReminderVisitorTest {
    
    /**
     * Test of visitFacade method, of class ReminderVisitor.
     */
    @Test(expected = NullPointerException.class)
    public void testVisitFacade1() {
        Facade facade = null;
        ReminderVisitor instance = new ReminderVisitor();
        instance.visitFacade(facade);
    }
    
    @Test
    public void testVisitFacade2() {
        Facade facade = new Facade();
        facade.createCourseList();
        ReminderVisitor instance = new ReminderVisitor();
        instance.visitFacade(facade);
    }

    /**
     * Test of visitCourse method, of class ReminderVisitor.
     */
    @Test(expected = NullPointerException.class)
    public void testVisitCourse1() {
        Course course = null;
        ReminderVisitor instance = new ReminderVisitor();
        instance.visitCourse(course);
    }
    
    @Test
    public void testVisitCourse2() {
        Course course = new Course("", 0);
        ReminderVisitor instance = new ReminderVisitor();
        instance.visitCourse(course);
    }

    /**
     * Test of visitAssignment method, of class ReminderVisitor.
     */
    @Test(expected = NullPointerException.class)
    public void testVisitAssignment1() {
        Assignment assignment = null;
        ReminderVisitor instance = new ReminderVisitor();
        instance.visitAssignment(assignment);
    }
    
    @Test
    public void testVisitAssignment2() {
        Assignment assignment = new Assignment();
        assignment.assName = "SER515";
        assignment.setDueDate(new Date());
        ReminderVisitor instance = new ReminderVisitor();
        instance.m_Reminder = new Reminder();
        instance.visitAssignment(assignment);
    }
    
}
