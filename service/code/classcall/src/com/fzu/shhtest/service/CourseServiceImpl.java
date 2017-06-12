package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.dao.CourseDao;
import com.fzu.shhtest.dao.PersonnelDao;
import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.Personnel;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public int createCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.createCourse(course);
	}

	@Override
	public boolean deleteCourseByName(String cname) {
		// TODO Auto-generated method stub
		return courseDao.deleteCourseByName(cname);
	}

	@Override
	public boolean updateCourse(Course course,String oldcourseName) {
		// TODO Auto-generated method stub
		return courseDao.updateCourse(course,oldcourseName);
	}

	@Override
	public List getAllCourse() {
		// TODO Auto-generated method stub
		return courseDao.getAllCourse();
	}

	@Override
	public Course getCourseByName(String cname) {
		// TODO Auto-generated method stub
		return courseDao.getCourseByName(cname);
	}
}
