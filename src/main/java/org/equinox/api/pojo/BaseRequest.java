package org.equinox.api.pojo;

import java.io.Serializable;

public abstract class BaseRequest implements Serializable {
	
	private static final long serialVersionUID = 2092806955692419001L;
	
	protected String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
