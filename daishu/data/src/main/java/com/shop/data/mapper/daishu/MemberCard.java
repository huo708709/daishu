package com.shop.data.mapper.daishu;

import com.shop.data.mapper.IntEntity;

public class MemberCard extends IntEntity {
	
	public final static int MAMA = 1;
	public final static int BABA = 2;
	public final static int BAOBAO = 3;

	private String name;
	private double rechargeAmount;//充值金额
	private double giveAmount;//赠送金额
	private int type;//会员卡类型
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public double getGiveAmount() {
		return giveAmount;
	}
	public void setGiveAmount(double giveAmount) {
		this.giveAmount = giveAmount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
