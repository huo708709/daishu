package com.shop.manager.web.model;

public class ResponseData {
	
	public static final int CODE_SUCCESS = 0;
	public static final int CODE_ERROR = 1;
	
	public static final String ACTION_TOAST = "toast";
	public static final String ACTION_ALERT = "alert";

	public int code = CODE_SUCCESS;
	public String message = "";
	public String action = "";
	public Object data;

	public ResponseData(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	public ResponseData(String message, String action) {
		super();
		this.message = message;
		this.action = action;
	}

	public ResponseData(String message, String action, Object data) {
		super();
		this.message = message;
		this.action = action;
		this.data = data;
	}

	public ResponseData(int code, String message, String action, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.action = action;
		this.data = data;
	}

	public ResponseData(int code, String message, String action) {
		super();
		this.code = code;
		this.message = message;
		this.action = action;
	}
	
}
