package org.equinox.api.pojo.payment;

import java.math.BigDecimal;
import org.equinox.api.pojo.BaseRequest;

public class TransferP2PInquiryRequest extends BaseRequest {
	
	private static final long serialVersionUID = 2092806955692419051L;
	
	private String fromMember;
	private String toMember;
	private BigDecimal amount;
	
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
	
}
