package com.shop.data.mapper.daishu;

import com.shop.data.mapper.IntEntity;

public class VipCard extends IntEntity {

	private int customerId;
	/**
	 * 详细地址
	 */
	private String content;
	/**
	 * 街道
	 */
	private String street;
	/**
	 * 区域
	 */
	private String area;

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
