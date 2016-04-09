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
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "YYYY-MM-dd")
	private Date createTime;
	private int baojieType;
	private int ayiId;
	private String ayiName;
	private double price;//订单价格
	private int payStatus;//支付状态
	private int auditStatus;//审核状态

	private String serviceDate;//服务日期
	private String serviceTime;//服务时间
	private String serviceTimeType;//服务时间段类型
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

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getServiceTimeType() {
		return serviceTimeType;
	}

	public void setServiceTimeType(String serviceTimeType) {
		this.serviceTimeType = serviceTimeType;
	}
	
}
