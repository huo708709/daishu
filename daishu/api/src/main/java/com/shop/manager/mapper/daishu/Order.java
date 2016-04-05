package com.shop.manager.mapper.daishu;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.shop.manager.mapper.IntEntity;

public class Order extends IntEntity {

	private String orderNo;
	private int customerId;
	private int addressId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "YYYY-MM-dd")
	private Date createTime;
	private int baojieType;
	private int ayiId;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getBaojieType() {
		return baojieType;
	}

	public void setBaojieType(int baojieType) {
		this.baojieType = baojieType;
	}

	public int getAyiId() {
		return ayiId;
	}

	public void setAyiId(int ayiId) {
		this.ayiId = ayiId;
	}

}
