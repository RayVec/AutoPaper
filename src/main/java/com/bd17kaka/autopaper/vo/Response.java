package com.bd17kaka.autopaper.vo;

public class Response <T> {

	private Boolean result = true;
	
	private String message = "";
	
	private T data;

	public Response() {
		super();
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public Response<T> fail(String message) {
		this.result = false;
		this.message = message;
		return this;
	}
	
	public Response<T> success(String message) {
		this.result = true;
		this.message = message;
		return this;
	}
	
}
