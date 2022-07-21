package org.equinox.api.pojo.payment;

import java.math.BigDecimal;
import org.equinox.api.pojo.BaseRequest;

public class TransferP2PPaymentConfirmationRequest extends BaseRequest {
	
	private static final long serialVersionUID = 2094806955692419052L;
	
	private String callbackURL;
	private String fromMember;
	private String toMember;
	private BigDecimal amount;
	private String traceNumber;
	private String credential;
	
	public String getCallbackURL() {
		return callbackURL;
	}

	public void setCallbackURL(String callbackURL) {
		this.callbackURL = callbackURL;
	}

	public String getFromMember() {
		return fromMember;
	}
	
	public void setFromMember(String fromMember) {
		this.fromMember = fromMember;
	}
	
	public String getToMember() {
		return toMember;
	}
	
	public void setToMember(String toMember) {
		this.toMember = toMember;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}
	
	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}
}
