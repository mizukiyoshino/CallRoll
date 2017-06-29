package com.fzu.shhtest.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DdClassDate", catalog = "classcall")
public class DdClassDate {
	@Column(name = "dname")
	private String dname;
	@Id
	@Column(name = "classDate")
	private int classDate;
	@Column(name = "state")
	private String state;
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public int getClassDate() {
		return classDate;
	}
	public void setClassDate(int classDate) {
		this.classDate = classDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
