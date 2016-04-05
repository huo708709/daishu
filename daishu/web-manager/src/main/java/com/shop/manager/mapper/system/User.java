package com.shop.manager.mapper.system;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.shop.manager.mapper.IntEntity;

public class User extends IntEntity {
	
	public static final int STATUS_NORMAL = 0;
	public static final int STATUS_FORBIDDEN = 1;

	private String username;
	private String password;
	private String email;
	private String phone;
	private int status;
	@JSONField(format = "YYYY-MM-dd HH:mm:ss")
	private Date createTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
