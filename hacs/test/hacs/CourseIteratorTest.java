package hacs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sajith
 */
public class CourseIteratorTest {
    
    public CourseIteratorTest() {
    }
    
    /**
     * Test of hasNext method, of class CourseIterator.
     */
    @Test(expected = NullPointerException.class)
    public void testHasNext1() {
        CourseIterator instance = new CourseIterator();
        boolean expResult = false;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasNext2() {
        ClassCourseList courseList = new ClassCourseList();
        courseList.initializeFromFile("");
        CourseIterator instance = new CourseIterator(courseList);
        boolean expResult = true;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasNext3() {
        ClassCourseList courseList = new ClassCourseList();
        courseList.initializeFromFile("");
        CourseIterator instance = new CourseIterator(courseList);
        instance.next();
        instance.next();
        instance.next();
        boolean expResult = false;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class CourseIterator.
     */
    @Test(expected = NullPointerException.class)
    public void testNext_0args1() {
        CourseIterator instance = new CourseIterator();
        Object expResult = null;
        Object result = instance.next();
        assertEquals(expResult, result);
    }
    @Test
    public void testNext_0args2() {
        ClassCourseList courseList = new ClassCourseList();
        courseList.initializeFromFile("");
        CourseIterator instance = new CourseIterator(courseList);
        Object expResult = courseList.findCourseByCourseName("CSE870");
        Object result = instance.next();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class CourseIterator.
     */
    @Test
    public void testNext_String1() {
        ClassCourseList courseList = new ClassCourseList();
        courseList.initializeFromFile("");
        CourseIterator instance = new CourseIterator(courseList);
        Object expResult = courseList.findCourseByCourseName("");
        Object result = instance.next("");
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNext_String2() {
        ClassCourseList courseList = new ClassCourseList();
        courseList.initializeFromFile("");
        CourseIterator instance = new CourseIterator(courseList);
        Object expResult = courseList.findCourseByCourseName("CSE870");
        Object result = instance.next("CSE870");
        assertEquals(expResult, result);
    }
    
}
