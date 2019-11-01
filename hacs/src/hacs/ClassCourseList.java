package hacs;

import java.util.ArrayList;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}

                    /**
                     *  This method initializes the list by reading from the file.
                     * @param theFileName 
                     */
	void initializeFromFile(String theFileName) {
		try {
			BufferedReader file;
			String strCourseName = null;
			file = new BufferedReader(new FileReader("CourseInfo.txt"));
			while ((strCourseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
				add(theCourse);
			}
		} catch (Exception ee) {
			;
		}
	}

                    /**
                     *  This method finds the Course for a given Course Name
                     * @param courseName
                     * @return Course
                     */
	Course findCourseByCourseName(String courseName) {
		int nCourseCount = size();
		for (int i = 0; i < nCourseCount; i++) {
			Course theCourse;
			theCourse = (Course) get(i);
			if (theCourse.courseName.compareTo(courseName) == 0)
				return theCourse;
		}
		return null;
	}

}