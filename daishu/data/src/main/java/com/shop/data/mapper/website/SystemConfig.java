package com.shop.data.mapper.website;

import com.shop.data.mapper.IntEntity;

public class SystemConfig extends IntEntity {

	private String recruitmentUrl;
	private String xieyi;
	private String guize;
	private String tel;

	public String getRecruitmentUrl() {
		return recruitmentUrl;
	}

	public void setRecruitmentUrl(String recruitmentUrl) {
		this.recruitmentUrl = recruitmentUrl;
	}

	public String getXieyi() {
		return xieyi;
	}

	public void setXieyi(String xieyi) {
		this.xieyi = xieyi;
	}

	public String getGuize() {
		return guize;
	}

	public void setGuize(String guize) {
		this.guize = guize;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
