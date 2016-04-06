package com.shop.data.mapper.system;

import com.shop.data.mapper.IntEntity;

public class UsersRoles extends IntEntity {
	
	private String userId;
	private String roleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
