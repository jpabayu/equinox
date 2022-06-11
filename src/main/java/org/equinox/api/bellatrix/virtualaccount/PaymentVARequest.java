package org.equinox.api.bellatrix.virtualaccount;

import java.math.BigDecimal;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class PaymentVARequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419080L;
	
	private BigDecimal amount;
	private String fromMember;
	private String paymentCode;
	private String referenceNumber;
	private String traceNumber;
	private String transferTypeId;
	
	public PaymentVARequest() {
		super(RequestPath.VIRTUAL_ACCOUNTS, "paymentVA");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<fromMember>").append(fromMember).append("</fromMember>\n");
		sb.append(Constants.THREE_INDENT).append("<paymentCode>").append(paymentCode).append("</paymentCode>\n");
		sb.append(Constants.THREE_INDENT).append("<amount>").append(amount).append("</amount>\n");
		sb.append(Constants.THREE_INDENT).append("<referenceNumber>").append(referenceNumber).append("</referenceNumber>\n");
		sb.append(Constants.THREE_INDENT).append("<traceNumber>").append(traceNumber).append("</traceNumber>\n");
		sb.append(Constants.THREE_INDENT).append("<transferTypeID>").append(transferTypeId).append("</transferTypeID>\n");
		
		return sb.toString();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFromMember() {
		return fromMember;
	}

	public void setFromMember(String fromMember) {
		this.fromMember = fromMember;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}

	public String getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(String transferTypeId) {
		this.transferTypeId = transferTypeId;
	}
}
