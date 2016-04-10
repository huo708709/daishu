package com.shop.data.mapper.daishu;

import java.util.Date;

import com.shop.data.mapper.IntEntity;

public class Recharge extends IntEntity {

	public final static int STATUS_NOT_PAY = 0;
	public final static int STATUS_PAY = 1;

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

	private String outTradeNo;
	private String openId;
	private String sign;
	private String detail;
	private String transactionId;
	private double giveAmount;

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
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public double getGiveAmount() {
		return giveAmount;
	}
	public void setGiveAmount(double giveAmount) {
		this.giveAmount = giveAmount;
	}

}
