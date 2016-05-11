package com.shop.data.mapper.website;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.shop.data.mapper.IntEntity;

public class Banner extends IntEntity {

	public static final int STATUS_NORMAL = 0;
	public static final int STATUS_FORBIDDEN = 1;
	
	public static final int TYPE_PC = 1;
	public static final int TYPE_H5 = 2;

	private String title;
	private String description;
	private String url;
	private int status;
	private int type;
	@JSONField(format = "YYYY-MM-dd HH:mm:ss")
	private Date createTime;
	
	private String fileId;
	private int userId;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
