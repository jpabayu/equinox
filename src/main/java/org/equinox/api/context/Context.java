package org.equinox.api.context;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class Context {
	
	private static final Logger logger = Logger.getLogger(Context.class);
	
	private String userAgent;
	private String correlationID;
	private String httpMethod;
	private String transactionType;
	private String prefix;
	
	public String getLogPrefix() {
		if(StringUtils.isBlank(prefix)) {
			prefix = "[" + userAgent + " | " + correlationID + " | " + httpMethod + " " + transactionType + "]";
		}
		
		return prefix;
	}
	
	public void logInfo(String message) {
		String logPrefix = getLogPrefix();
		logger.info("[" + logPrefix + " " + message + "]");
	}
	
	public void logWarn(String message) {
		String logPrefix = getLogPrefix();
		logger.warn("[" + logPrefix + " " + message + "]");
	}
	
	public void logError(String message) {
		String logPrefix = getLogPrefix();
		logger.error("[" + logPrefix + " " + message + "]");
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
		this.prefix = null;
	}

	public String getCorrelationID() {
		return correlationID;
	}

	public void setCorrelationID(String correlationID) {
		this.correlationID = correlationID;
		this.prefix = null;
	}
	
	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
}
