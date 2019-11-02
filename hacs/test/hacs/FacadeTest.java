/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sajit
 */
public class FacadeTest {
    
    public FacadeTest() {
    }

    /**
     * Test of addAssignment method, of class Facade.
     */
    @Test(expected = NullPointerException.class)
    public void testAddAssignment1() {
        Course theCourse = null;
        Facade instance = new Facade();
        instance.thePerson = new Instructor();
        instance.addAssignment(theCourse);
    }
    
    @Test
    public void testAddAssignment2() {
        Course theCourse = new Course("", 0);
        Facade instance = new Facade();
        instance.thePerson = new Instructor();
        instance.addAssignment(theCourse);
    }

    /**
     * Test of viewAssignment method, of class Facade.
     */
    @Test(expected = NullPointerException.class)
    public void testViewAssignment1() {
        Assignment theAssignment = null;
        Facade instance = new Facade();
        instance.viewAssignment(theAssignment);
    }
    
    @Test
    public void testViewAssignment2() {
        Assignment theAssignment = new Assignment();
        Facade instance = new Facade();
        instance.thePerson = new Student();
        instance.viewAssignment(theAssignment);
    }
    
    @Test
    public void testViewAssignment3() {
        Assignment theAssignment = new Assignment();
        Facade instance = new Facade();
        instance.thePerson = new Instructor();
        instance.viewAssignment(theAssignment);
    }

    /**
     * Test of reportSolutions method, of class Facade.
     */
    @Test(expected = NullPointerException.class)
    public void testReportSolutions1() {
        Assignment theAssignment = null;
        Facade instance = new Facade();
        instance.reportSolutions(theAssignment);
    }
    
    @Test
    public void testReportSolutions2() {
        Assignment theAssignment = new Assignment();
        Facade instance = new Facade();
        instance.reportSolutions(theAssignment);
    }

    /**
     * Test of submitSolution method, of class Facade.
     */
    @Test(expected = NullPointerException.class)
    public void testSubmitSolution1() {
        Assignment theAssignment = null;
        Solution theSolution = null;
        Facade instance = new Facade();
        instance.submitSolution(theAssignment, theSolution);
    }
    
    @Test
    public void testSubmitSolution2() {
        Assignment theAssignment = new Assignment();
        Solution theSolution = null;
        Facade instance = new Facade();
        instance.submitSolution(theAssignment, theSolution);
    }
    
    @Test
    public void testSubmitSolution3() {
        Assignment theAssignment = new Assignment();
        Solution theSolution = new Solution();
        Facade instance = new Facade();
        instance.submitSolution(theAssignment, theSolution);
    }
    
}
