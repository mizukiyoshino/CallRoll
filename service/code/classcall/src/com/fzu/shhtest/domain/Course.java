package com.fzu.shhtest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course", catalog = "classcall")
public class Course {
	@Id
	@Column(name = "courseName")
	//@OneToMany(cascade=CascadeType.ALL)
	private String courseName;
	@Column(name = "dailyWeight")
	private double dailyWeight;
	@Column(name = "finalWeight")
	private double finalWeight;
	@Column(name = "picketLine")
	private int picketLine;
	@Column(name = "ID")
	private String ID;
	@Column(name = "classSession")
	private String classSession;
	@Column(name = "classLocation")
	private String classLocation;
	
	@Column(name = "classDate")
	private int classDate;
	
	@Column(name = "classOrder")
	private String classOrder;
	@Column(name = "shape")
	private String shape;
	/*
	@OneToOne(cascade = CascadeType.ALL)  
    @JoinColumn(name = "classDate") 
	private DdClassDate ddClassDate;
	public DdClassDate getDdClassDate() {
		return ddClassDate;
	}
	public void setDdClassDate(DdClassDate ddClassDate) {
		this.ddClassDate = ddClassDate;
	}
	
	/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name = "courseName", referencedColumnName = "courseName")  // 表示多方需要参考一方的属性为cid
	private List<CallTheRoll> callTheRolls = new ArrayList<CallTheRoll>();  
	public List<CallTheRoll> getCallTheRolls() {
		return callTheRolls;
	}
	public void setCallTheRolls(List<CallTheRoll> callTheRolls) {
		this.callTheRolls = callTheRolls;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name = "courseName", referencedColumnName = "courseName")  // 表示多方需要参考一方的属性为cid
	private List<Question> questions = new ArrayList<Question>(); 
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name = "courseName", referencedColumnName = "courseName")  // 表示多方需要参考一方的属性为cid
	private List<Mark> marks = new ArrayList<Mark>(); 
	public List<Mark> getMarks() {
		return marks;
	}
	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
	*/
		


	

	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getDailyWeight() {
		return dailyWeight;
	}

	public void setDailyWeight(double dailyWeight) {
		this.dailyWeight = dailyWeight;
	}

	public double getFinalWeight() {
		return finalWeight;
	}

	public void setFinalWeight(double finalWeight) {
		this.finalWeight = finalWeight;
	}

	public int getPicketLine() {
		return picketLine;
	}

	public void setPicketLine(int picketLine) {
		this.picketLine = picketLine;
	}

	public String getClassSession() {
		return classSession;
	}

	public void setClassSession(String classSession) {
		this.classSession = classSession;
	}

	public String getClassLocation() {
		return classLocation;
	}

	public void setClassLocation(String classLocation) {
		this.classLocation = classLocation;
	}

	public int getClassDate() {
		return classDate;
	}

	public void setClassDate(int classDate) {
		this.classDate = classDate;
	}

	public String getClassOrder() {
		return classOrder;
	}

	public void setClassOrder(String classOrder) {
		this.classOrder = classOrder;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String toString() {
		return courseName + "    " + dailyWeight + "    " + finalWeight
				+ "    " + picketLine + "    " + ID + "    " + classSession
				+ "    " + classLocation + "    " +  "    "
				+ classOrder + "    " + shape;
	}

}
