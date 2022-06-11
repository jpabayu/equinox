package org.equinox.api.bellatrix;

import java.io.Serializable;

import org.equinox.api.data.Status;

public class BellatrixStatus implements Serializable {
	
	private static final long serialVersionUID = 1992806955692419076L;
	
	private String responseCode;
    private String message;
    private String description;
	
    public BellatrixStatus() {
    	message = Status.UNDEFINED_ERROR.name();
    }
    
    public String getResponseCode() {
		return responseCode;
	}
    
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
