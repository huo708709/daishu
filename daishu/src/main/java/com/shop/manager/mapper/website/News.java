package com.shop.manager.mapper.website;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.shop.manager.mapper.IntEntity;

public class News extends IntEntity {

	public static final int STATUS_NORMAL = 0;
	public static final int STATUS_FORBIDDEN = 1;

	private String title;
	private String digest;
	private String content;
	private String fileId;
	private int status;
	private int userId;
	@JSONField(format = "YYYY-MM-dd HH:mm:ss")
	private Date createTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
