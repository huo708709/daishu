package com.shop.data.mapper.daishu;

import java.util.Date;

import com.shop.data.mapper.IntEntity;

public class Customer extends IntEntity {
	
	public static final int STATUS_NORMAL = 1;
	public static final int STATUS_LOCK = 2;

	private String weixinName;
	private Date last_time;
	private Date first_time;
	private String address;
	private String phone;
	private String name;
	private int status;

	public String getWeixinName() {
		return weixinName;
	}

	public void setWeixinName(String weixinName) {
		this.weixinName = weixinName;
	}

	public Date getLast_time() {
		return last_time;
	}

	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}

	public Date getFirst_time() {
		return first_time;
	}

	public void setFirst_time(Date first_time) {
		this.first_time = first_time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
