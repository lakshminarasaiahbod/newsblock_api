package com.newsblock.api.util;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommonResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp = new Date();
	private boolean hasError;
	private boolean hasData;
	@JsonFormat(shape = JsonFormat.Shape.ANY)
	private Object error;
	private Object response;
	private int status;

	public CommonResponse() {
	}

	public void setErrorResponse(Object error, int status) {
		this.hasError = true;
		this.hasData = false;
		this.status = status;
		this.error = error;

	}

	public void setSuccessResponse(Object response) {
		this.hasError = false;
		this.hasData = true;
		this.status = 200;
		this.response = response;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public boolean isHasData() {
		return hasData;
	}

	public void setHasData(boolean hasData) {
		this.hasData = hasData;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "CommonResponseNew [hasError=" + hasError + ", hasData=" + hasData + ", status=" + status + ", error="
				+ error + ", response=" + response + "]";
	}

}
