package com.shop.manager.mapper.system;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.shop.manager.mapper.UUIDEntity;

public class File extends UUIDEntity {

	private String id;
	private String name;
	private String contentType;
	@JSONField(format = "YYYY-MM-dd HH:mm:ss")
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
