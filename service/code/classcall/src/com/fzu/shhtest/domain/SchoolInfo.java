package com.fzu.shhtest.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SchoolInfo", catalog = "classcall")
public class SchoolInfo {
	@Id
	@Column(name = "school")
	private String school;
	@Column(name = "college")
	private String college;
	@Column(name = "department")
	private String department;
	@Column(name = "starttime")
	private Date starttime;
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	
}

/*
 * 原则： 数据库的表名都为小写字母、类按驼峰法命名 类的变量与数据库的列表一致
 */









