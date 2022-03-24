package org.equinox.api.qris.data;

import java.io.Serializable;

public class QrisInquiryRequest implements Serializable {

	private static final long serialVersionUID = 9045610201602756588L;
	protected String token;
	private String qrData;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getQrData() {
		return qrData;
	}

	public void setQrData(String qrData) {
		this.qrData = qrData;
	}

}
