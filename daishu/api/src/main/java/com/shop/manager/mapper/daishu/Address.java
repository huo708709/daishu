package com.shop.manager.mapper.daishu;

import com.shop.manager.mapper.IntEntity;

public class Address extends IntEntity {

	private int customerId;
	private String content;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
