package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.Personnel;

public interface CourseService {
	// Ôö
	int createCourse(Course course);

	// É¾
	boolean deleteCourseByName(String cname);

	// ¸Ä
	boolean updateCourse(Course course, String oldcourseName);

	// ²é
	List getAllCourse();
	Course getCourseByName(String cname);
	
	List getAllCourseHql();
	List getCourseByNameHql(String cname);
}
