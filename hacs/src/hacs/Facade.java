package hacs;

import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 *          Update to Java 8
 */

public class Facade {
	public int userType;
	private Course theSelecteCourse = null;
	private int nCourseLevel = 0;
	ClassCourseList theCourseList;
	Person thePerson;

	public Facade() {
	}

	static public boolean login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.getUserName();
		userinfoItem.userType = login.getUserType();
		return login.isExit();
	}

	// functions for CourseMenu

	/**
	 * When click the add button of the CourseMenu , call this function this
	 * function will new an assignment fill the required information this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the courseMenu need to
	 * refreshed outside the function
	 * 
	 * @param theCourse
	 */
	void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0) {
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}

	/**
	 * When click the view button of the CourseMenu , call this function and pass
	 * the pointer of the Assignment and the person pointer to this function this
	 * function will new an assignment fill the required information this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user
	 * 
	 * @param theAssignment
	 */
	void viewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}

		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}

	// functions for InstructorAssignmentMenu

	/**
	 * This method will grade the given solution
	 * 
	 * @param theSolution
	 */
	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.showMenu(theSolution);
	}

	void reportSolutions(Assignment theAssignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}

	// functions for StudentAssignmentMenu

	void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.getCourseList());
	}

	void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student) /// student
		{
			thePerson = new Student();
		} else /// instructor
		{
			thePerson = new Instructor();
		}
		thePerson.userName = userinfoitem.strUserName;
	}

	/**
	 * Create a course list and initialize it with the file CourseInfo.txt.
	 */
	void createCourseList() {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile("CourseInfo.txt");
	}

	/**
	 * call this function after create user, create course list read the
	 * UserCourse.txt file match the course name with theCouresList attach the
	 * Matched course object to the new create user Facade.thePerson.CourseList
	 */
	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserCourse.txt"));
			String aline, strUserName, strCourseName;
			while ((aline = file.readLine()) != null) {
				strUserName = getUserName(aline);
				strCourseName = getCourseName(aline);
				if (strUserName.compareTo(thePerson.userName) == 0) {
					theSelecteCourse = FindCourseByCourseName(strCourseName);
					if (theSelecteCourse != null) {
						thePerson.addCourse(theSelecteCourse);
					}
				}
			}
		} catch (Exception ee) {
			;
		}
	}

	/**
	 * This method gets the user name from aline UserName:CourseName
	 * 
	 * @param aline
	 * @return
	 */
	private String getUserName(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(0, sep);
	}

	/**
	 * This method gets the CourseName from the UserName:CourseName
	 * 
	 * @param aline
	 * @return
	 */
	private String getCourseName(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(sep + 1, aline.length());
	}

	/**
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelecteCourse, the Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 * 
	 * @return
	 */
	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		theSelecteCourse = theDlg.showDlg(thePerson.courseList);
		thePerson.currentCourse = theSelecteCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/**
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 * 
	 * @return
	 */
	public boolean courseOperation() {
		thePerson.createCourseMenu(theSelecteCourse, nCourseLevel);
		return thePerson.showMenu();//// 0: logout 1 select an other course
	}

	/**
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 * 
	 * @param strCourseName
	 * @return
	 */
	private Course FindCourseByCourseName(String strCourseName) {
		CourseIterator iterator = new CourseIterator(theCourseList);
		return (Course) iterator.next(strCourseName);
	}

}