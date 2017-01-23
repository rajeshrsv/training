package com.training.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	private int addrId;
	private String doorNo;
	private String street;
	private String district;
	private String state;
	private String country;
	private int pinCode;

	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	public int getAddrId() {
		return addrId;
	}

	public Address(String doorNo, String street, String district, String state, String country,
			int pinCode) {
		this.doorNo = doorNo;
		this.street = street;
		this.district = district;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}

	public Address() {
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

}
