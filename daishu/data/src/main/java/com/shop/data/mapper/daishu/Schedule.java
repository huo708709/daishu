package com.shop.data.mapper.daishu;

import com.shop.data.mapper.IntEntity;

public class Schedule extends IntEntity {
	private int baojieType;//保洁类型
	private String baojieName;//保洁类型名称
	private int xingqi1;//星期一保洁人数
	private int xingqi2;
	private int xingqi3;
	private int xingqi4;
	private int xingqi5;
	private int xingqi6;
	private int xingqi7;
	public int getBaojieType() {
		return baojieType;
	}
	public void setBaojieType(int baojieType) {
		this.baojieType = baojieType;
	}
	
	public String getBaojieName() {
		return baojieName;
	}
	public void setBaojieName(String baojieName) {
		this.baojieName = baojieName;
	}
	public int getXingqi1() {
		return xingqi1;
	}
	public void setXingqi1(int xingqi1) {
		this.xingqi1 = xingqi1;
	}
	public int getXingqi2() {
		return xingqi2;
	}
	public void setXingqi2(int xingqi2) {
		this.xingqi2 = xingqi2;
	}
	public int getXingqi3() {
		return xingqi3;
	}
	public void setXingqi3(int xingqi3) {
		this.xingqi3 = xingqi3;
	}
	public int getXingqi4() {
		return xingqi4;
	}
	public void setXingqi4(int xingqi4) {
		this.xingqi4 = xingqi4;
	}
	public int getXingqi5() {
		return xingqi5;
	}
	public void setXingqi5(int xingqi5) {
		this.xingqi5 = xingqi5;
	}
	public int getXingqi6() {
		return xingqi6;
	}
	public void setXingqi6(int xingqi6) {
		this.xingqi6 = xingqi6;
	}
	public int getXingqi7() {
		return xingqi7;
	}
	public void setXingqi7(int xingqi7) {
		this.xingqi7 = xingqi7;
	}
	
}
