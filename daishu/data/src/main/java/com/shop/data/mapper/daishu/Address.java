package com.shop.data.mapper.daishu;

import com.shop.data.mapper.IntEntity;

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
