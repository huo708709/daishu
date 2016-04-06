package com.shop.data.mapper.website;

import com.shop.data.mapper.IntEntity;

public class SystemConfig extends IntEntity {

	private String recruitmentUrl;

	public String getRecruitmentUrl() {
		return recruitmentUrl;
	}

	public void setRecruitmentUrl(String recruitmentUrl) {
		this.recruitmentUrl = recruitmentUrl;
	}

}
