package org.equinox.api.qris;

public class ResponseCode {
	private String code;
	private String description;
	private ResponseCodeStatus status;

	public ResponseCode(String code, String description, ResponseCodeStatus status) {
		this.code = code;
		this.description = description;
		this.status = status;
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

	public ResponseCodeStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseCodeStatus status) {
		this.status = status;
	}
}
