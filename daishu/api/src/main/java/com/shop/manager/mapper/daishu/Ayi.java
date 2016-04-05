package com.shop.manager.mapper.daishu;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.shop.manager.mapper.IntEntity;

public class Ayi extends IntEntity {

	private String name;
	private String phone;
	private String cardNo;
	private String cardPlace;
	private String address;
	private String jobNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format = "YYYY-MM-dd")
	private Date birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardPlace() {
		return cardPlace;
	}
	public void setCardPlace(String cardPlace) {
		this.cardPlace = cardPlace;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
