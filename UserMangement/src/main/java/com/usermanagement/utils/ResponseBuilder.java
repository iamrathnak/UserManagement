package com.usermanagement.utils;

import java.io.Serializable;

import com.usermanagement.domain.User;

/**
 * 
 * @author rathanakumark
 *
 */
public class ResponseBuilder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String responseMessage;
	private String responseCode;
	private Object data;

	

	public ResponseBuilder(String responseMessage, String responseCode, Object data) {
		this.responseMessage = responseMessage;
		this.responseCode = responseCode;
		this.data = data;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
