package com.shop.data.mapper.website;

import com.shop.data.mapper.IntEntity;

public class Business extends IntEntity {
	
	/**
	 * 常规保洁
	 */
	public final static int CHANGGUIBAOJIE = 1;
	/**
	 * 精细保洁
	 */
	public final static int JINGXIBAOJIE = 2;
	/**
	 * 深度保洁
	 */
	public final static int SHENDUBAOJIE = 3;
	/**
	 * 擦玻璃
	 */
	public final static int CABOLI = 4;
	/**
	 * 家居开荒
	 */
	public final static int JIAJUKAIHUANG = 5;
	/**
	 * 家电清洗
	 */
	public final static int JIADIANQINGXI = 6;
	/**
	 * 家具护理
	 */
	public final static int JIAJUHULI = 7;
	/**
	 * 干洗
	 */
	public final static int GANXI = 8;

	private String name;
	private String code;
	private String description;
	private int unitId;
	private String unitName;
	private int type;
	private String intro;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
