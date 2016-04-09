package com.shop.data.mapper.daishu;

import java.util.Date;

import com.shop.data.mapper.IntEntity;

public class Recharge extends IntEntity {

	private int customerId;
	/**
	 * 会员卡类型
	 */
	private int type;
	/**
	 * 额度
	 */
	private double money;
	/**
	 * 充值时间
	 */
	private Date time;
	/**
	 * 充值状态 0失败1成功
	 */
	private int status;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
