package com.fzu.shhtest.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mark", catalog = "classcall")
public class Mark {	
	@Column(name = "dailyScore")
	private double dailyScore;
	@Column(name = "finalScore")
	private double finalScore;
	@Column(name = "markreserve")
	private String markreserve;
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
	private courseNameAndID cnameAndID;
	@EmbeddedId
	public courseNameAndID getCnameAndID() {
		return cnameAndID;
	}
	public void setCnameAndID(courseNameAndID cnameAndID) {
		this.cnameAndID = cnameAndID;
	}
	
	
	/*
	private Course course;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	*/
	
	
	
	
	public double getDailyScore() {
		return dailyScore;
	}
	public void setDailyScore(double dailyScore) {
		this.dailyScore = dailyScore;
	}
	public double getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}
	public String getMarkreserve() {
		return markreserve;
	}
	public void setMarkreserve(String markreserve) {
		this.markreserve = markreserve;
	}
	
}
