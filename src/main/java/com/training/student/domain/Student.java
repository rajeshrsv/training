package com.training.student.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	private int studId;
	private String name;
	private String rollNo;
	private String deptName;

	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	public Address getAddress() {
		return address;
	}

	public Student() {
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	public int getStudId() {
		return studId;
	}

	public Student(String name, String rollNo, String deptName, Address address) {
		this.name = name;
		this.rollNo = rollNo;
		this.deptName = deptName;
		this.address = address;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", rollNo=" + rollNo + ", deptName=" + deptName
				+ ", address=" + address + "]";
	}

}
