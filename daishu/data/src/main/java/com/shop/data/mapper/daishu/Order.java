package com.shop.data.mapper.daishu;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.shop.data.mapper.IntEntity;

public class Order extends IntEntity {

	private String orderNo;
	private int customerId;
	private String customerName;
	private int addressId;
	private String addressContent;//地址信息
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "YYYY-MM-dd")
	private Date createTime;
	private int baojieType;
	private int ayiId;
	private String ayiName;
	private double price;//订单价格
	private int payType;//支付方式
	private int payStatus;//支付状态
	private int auditStatus;//审核状态
	private String serviceDate;//服务日期
	private int serviceTimeType;//服务时间段类型
	
	
	private String name;//联系人姓名
	private String phone;//联系人电话
	private double area;//服务面积
	private String remark;//备注
	
	
	public final static int AUDIT_STATUS_WAIT = 1; //待审核
	public final static int AUDIT_STATUS_PASS = 2; //审核通过
	public final static int AUDIT_STATUS_NOT_PASS =3; //审核不通过
	
	public final static int PAY_STATUS_WAIT_PAY = 1; //待支付
	public final static int PAY_STATUS_SERVICE = 2; //服务中
	public final static int PAY_STATUS_WAIT_COMMENT =3; //待评价
	public final static int PAY_STATUS_COMMENTED =4; //已评价
	
	public final static int SERVICE_TIME_TYPE_1 = 1; //待支付
	public final static int SERVICE_TIME_TYPE_2 = 2; //服务中
	public final static int SERVICE_TIME_TYPE_3 =3; //待评价
	public final static int SERVICE_TIME_TYPE_4 =4; //已评价
	
	
	public final static int PAY_TYPE_WEIXIN = 1; //支付方式-微信
	public final static int PAY_TYPE_CASH = 2; //支付方式-现金
	public final static int PAY_TYPE_MEMBER =3; //支付方式-会员卡
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

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressContent() {
		return addressContent;
	}

	public void setAddressContent(String addressContent) {
		this.addressContent = addressContent;
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

	public String getAyiName() {
		return ayiName;
	}

	public void setAyiName(String ayiName) {
		this.ayiName = ayiName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public int getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public int getServiceTimeType() {
		return serviceTimeType;
	}

	public void setServiceTimeType(int serviceTimeType) {
		this.serviceTimeType = serviceTimeType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
