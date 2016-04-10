package com.shop.data.mapper.daishu;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.shop.data.mapper.IntEntity;

public class Comment extends IntEntity {

	private int orderId;
	private String orderNo;
	private int customerId;
	private String customerName;
	private int starLevel;
	private String content;
	@JSONField(format = "YYYY-MM-dd HH:mm:ss")
	private Date createTime;
	
	public static final int START_LEVEL_1 = 1;
	public static final int START_LEVEL_2 = 2;
	public static final int START_LEVEL_3 = 3;
	public static final int START_LEVEL_4 = 4;
	public static final int START_LEVEL_5 = 5;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getStarLevel() {
		return starLevel;
	}
	public void setStarLevel(int starLevel) {
		this.starLevel = starLevel;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
