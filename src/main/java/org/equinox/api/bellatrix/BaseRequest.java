package org.equinox.api.bellatrix;

import java.io.Serializable;

import org.equinox.api.config.Configuration;
import org.equinox.api.config.Key;
import org.equinox.api.data.Constants;

public abstract class BaseRequest implements Serializable, RequestBodyContent {
	
	private static final long serialVersionUID = 1992806955692419001L;
	
	private RequestPath requestPath;
	private String requestName;
	protected String token;
	protected StringBuilder sb;
	
	public BaseRequest(RequestPath requestPath, String requestName) {
		Configuration config = Configuration.getInstance();
		token = config.getString(Key.API_WS_HEADER_TOKEN_NC);
		sb = new StringBuilder();
		this.requestPath = requestPath;
		this.requestName = requestName;
	}
	
	public final String generateRequest() {
		sb.setLength(0);
		sb.append("\n<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.bellatrix.org/\">\n");
		sb.append(Constants.ONE_INDENT).append("<soapenv:Header>\n");
		sb.append(Constants.TWO_INDENT).append("<ser:headerAuth>\n");
		sb.append(Constants.THREE_INDENT).append("<token>").append(token).append("</token>\n");
		sb.append(Constants.TWO_INDENT).append("</ser:headerAuth>\n");
		sb.append(Constants.ONE_INDENT).append("</soapenv:Header>\n");
		sb.append(Constants.ONE_INDENT).append("<soapenv:Body>\n");
		sb.append(Constants.TWO_INDENT).append("<ser:").append(requestName).append(">\n");
		String prefix = sb.toString();
		String body = getBodyContent();
		
		sb.setLength(0);
		sb.append(prefix);
		sb.append(body);
		sb.append(Constants.TWO_INDENT).append("</ser:").append(requestName).append(">\n");
		sb.append(Constants.ONE_INDENT).append("</soapenv:Body>\n");
		sb.append("</soapenv:Envelope>");
		
		return sb.toString();
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRequestPath() {
		return requestPath.getPath();
	}

	public String getRequestName() {
		return requestName;
	}
}
