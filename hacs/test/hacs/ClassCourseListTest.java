package hacs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sajith
 */
public class ClassCourseListTest {
    
    public ClassCourseListTest() {
    }

    /**
     * Test of findCourseByCourseName method, of class ClassCourseList.
     */
    @Test
    public void testFindCourseByCourseName1() {
        String courseName = "";
        ClassCourseList instance = new ClassCourseList();
        Course expResult = null;
        Course result = instance.findCourseByCourseName(courseName);
        assertEquals(expResult, result);
    }
    @Test
    public void testFindCourseByCourseName2() {
        String courseName = null;
        ClassCourseList instance = new ClassCourseList();
        Course expResult = null;
        Course result = instance.findCourseByCourseName(courseName);
        assertEquals(expResult, result);
    }
    @Test
    public void testFindCourseByCourseName3() {
        String courseName = "SER515";
        ClassCourseList instance = new ClassCourseList();
        Course expResult = null;
        instance.initializeFromFile("CourseInfo.txt");
        Course result = instance.findCourseByCourseName(courseName);
        assertEquals(expResult, result);
    }
    @Test
    public void testFindCourseByCourseName4() {
        String courseName = "CSE870";
        ClassCourseList instance = new ClassCourseList();
        String expResult = courseName;
        instance.initializeFromFile("CourseInfo.txt");
        Course result = instance.findCourseByCourseName(courseName);
        assertEquals(expResult, result.toString());
    }
    
}
