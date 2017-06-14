package com.fzu.shhtest.domain;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Personnel", catalog = "classcall")
public class Personnel {
	@Id
	@Column(name = "ID")
	private String ID;
	@Column(name = "Ppassword")
	private String Ppassword;
	@Column(name = "Pname")
	private String Pname;
	@Column(name = "major")
	private int major;
	@Column(name = "role")
	private int role;
	@Column(name = "pclass")
	private int pclass;

	
	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getPpassword() {
		return Ppassword;
	}


	public void setPpassword(String ppassword) {
		Ppassword = ppassword;
	}


	public String getPname() {
		return Pname;
	}


	public void setPname(String pname) {
		Pname = pname;
	}


	public int getMajor() {
		return major;
	}


	public void setMajor(int major) {
		this.major = major;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public int getPclass() {
		return pclass;
	}


	public void setPclass(int pclass) {
		this.pclass = pclass;
	}


	public String toString() {
		return ID+"   "+Ppassword+"     "+Pname+"    "+"    "+major+"    "+role;
        //return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

}

/*
 * 原则： 数据库的表名都为小写字母、类按驼峰法命名 类的变量与数据库的列表一致
 */