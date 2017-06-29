package com.fzu.shhtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.Personnel;

public class CourseDaoImpl implements CourseDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getSession() {
		if (sessionFactory == null)
			return null;
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int createCourse(Course course) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(course);
		return 0;
	}

	@Override
	public boolean deleteCourseByName(String cname) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Course course = getCourseByName(cname);
		
		session.delete(course);
		return false;
	}

	@Override
	public boolean updateCourse(Course course,String oldcourseName) {
		Session session = getSession();
		session.update(course);
		/*
		Query query = session.createQuery("update Course set courseName=?,ID=?,dailyWeight=?,"
				+ "finalWeight=?,picketLine=?,classSession=?,classLocation=?,classDate=?,classOrder=?,"
				+ "shape=? where courseName=?");	
		query.setString(0, course.getCourseName());
		query.setString(1, course.getID());
		query.setDouble(2, course.getDailyWeight());
		query.setDouble(3, course.getFinalWeight());
		query.setInteger(4, course.getPicketLine());
		query.setString(5, course.getClassSession());
		query.setString(6, course.getClassLocation());
		query.setInteger(7, course.getClassDate());
		query.setString(8, course.getClassOrder());
		query.setString(9, course.getShape());
		query.setString(10, oldcourseName);
		
		query.executeUpdate();
		*/
		return false;
	}

	@Override
	public List getAllCourse() {
		Session session = getSession();
		List list = session.createQuery("from Course").list();
		return list;
	}

	@Override
	public Course getCourseByName(String cname) {
		Session session = getSession();
		Query query = session.createQuery("from Course where courseName=?");
		query.setString(0, cname);
		List<Course> list = (List<Course>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
}
