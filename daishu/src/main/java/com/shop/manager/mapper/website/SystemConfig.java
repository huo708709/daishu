package com.shop.manager.mapper.website;

import com.shop.manager.mapper.IntEntity;

public class SystemConfig extends IntEntity {

	private String recruitmentUrl;

	public String getRecruitmentUrl() {
		return recruitmentUrl;
	}

	public void setRecruitmentUrl(String recruitmentUrl) {
		this.recruitmentUrl = recruitmentUrl;
	}

}
