package com.shop.data.mapper.daishu;

import com.shop.data.mapper.IntEntity;

public class Address extends IntEntity {
	public final static int DEFAULT_FALSE = 0;
	public final static int DEFAULT_TRUE = 1;
	
	public final static int STATUS_SHOW = 0;
	public final static int STATUS_HIDE = 1;

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

	private int isDefault;
	private int status;
	
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

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
