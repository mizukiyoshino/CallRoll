package com.fzu.shhtest.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question", catalog = "classcall")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "autoid" , nullable = false)
	private long autoid; 
	@Column(name = "attendanceDate", nullable = false)
	private Date attendanceDate;
	@Column(name = "score", nullable = false)
	private Double score;
	@Column(name = "ID", nullable = false)
	private String ID;
	@Column(name = "courseName", nullable = false)
	private String courseName;
	
	/*
	private Course course;
	@ManyToOne
	@JoinColumn(name="courseName") 
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	*/
	
	public long getAutoid() {
		return autoid;
	}
	public void setAutoid(long autoid) {
		this.autoid = autoid;
	}
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
