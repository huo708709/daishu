package com.shop.data.mapper.daishu;

import java.util.Date;

import com.shop.data.mapper.IntEntity;

public class Consume extends IntEntity {

	private int customerId;
	/**
	 * 额度
	 */
	private double money;
	/**
	 * 消费时间
	 */
	private Date time;
	/**
	 * 订单
	 */
	private int orderId;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
