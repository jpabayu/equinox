package org.equinox.api.bellatrix.payment;

import java.math.BigDecimal;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class DoPaymentRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419068L;
	
    private String fromMember;
    private String toMember;
    private BigDecimal amount;
    private String description;
    private String remark;
    private String referenceNumber;
    private String traceNumber;
    private String originator;
    private String status;
    private int transferTypeId;
	
	public DoPaymentRequest() {
		super(RequestPath.PAYMENTS, "doPayment");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		
		sb.append(Constants.THREE_INDENT).append("<fromMember>").append(fromMember).append("</fromMember>\n");
		sb.append(Constants.THREE_INDENT).append("<toMember>").append(toMember).append("</toMember>\n");
		sb.append(Constants.THREE_INDENT).append("<amount>").append(amount).append("</amount>\n");
		
		if(description != null) {
			sb.append(Constants.THREE_INDENT).append("<description><![CDATA[").append(description).append("]]></description>\n");
		}
		
		if(remark != null) {
			sb.append(Constants.THREE_INDENT).append("<remark><![CDATA[").append(remark).append("]]></remark>\n");
		}
		
		if(referenceNumber != null) {
			sb.append(Constants.THREE_INDENT).append("<referenceNumber>").append(referenceNumber).append("</referenceNumber>\n");
		}
		
		if(originator != null) {
			sb.append(Constants.THREE_INDENT).append("<originator>").append(originator).append("</originator>\n");
		}
		
		if(status != null) {
			sb.append(Constants.THREE_INDENT).append("<status>").append(status).append("</status>\n");
		}
		
		sb.append(Constants.THREE_INDENT).append("<traceNumber>").append(traceNumber).append("</traceNumber>\n");
		sb.append(Constants.THREE_INDENT).append("<transferTypeID>").append(transferTypeId).append("</transferTypeID>\n");
		
		return sb.toString();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDescription(String description, String defaultValue) {
		if(description != null) {
			this.description = description;
		} else {
			this.description = defaultValue;
		}
		
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	
	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}
	
}
