package com.shop.data.mapper.system;

import com.shop.data.mapper.IntEntity;

public class Role extends IntEntity {

	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
