package com.fzu.shhtest.domain;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DdMajor", catalog = "classcall")
public class DdMajor {
	@Column(name = "dname", nullable = false)
	private String dname;
	@Id
	@Column(name = "major", nullable = false)
	private int major;
	@Column(name = "state", nullable = false)
	private String state;
	
	
	
	
	
	
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getMajor() {
		return major;
	}
	public void setMajor(int major) {
		this.major = major;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
