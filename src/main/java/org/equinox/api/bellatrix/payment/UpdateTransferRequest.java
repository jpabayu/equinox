package org.equinox.api.bellatrix.payment;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class UpdateTransferRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419072L;
	
	private long transferId;
	private String description;
	private String remark;
	private String referenceNumber;
	private String transactionState;
	
	public UpdateTransferRequest() {
		super(RequestPath.PAYMENTS, "updateTransfer");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<transferID>").append(transferId).append("</transferID>\n");
		
		if(description != null) {
			sb.append(Constants.THREE_INDENT).append("<description><![CDATA[").append(description).append("]]></description>\n");
		}
		
		if(remark != null) {
			sb.append(Constants.THREE_INDENT).append("<remark><![CDATA[").append(remark).append("]]></remark>\n");
		}
		
		if(referenceNumber != null) {
			sb.append(Constants.THREE_INDENT).append("<referenceNumber>").append(referenceNumber).append("</referenceNumber>\n");
		}
		
		if(transactionState != null) {
			sb.append(Constants.THREE_INDENT).append("<transactionState>").append(transactionState).append("</transactionState>\n");
		}
		
		return sb.toString();
	}

	public long getTransferId() {
		return transferId;
	}

	public void setTransferId(long transferId) {
		this.transferId = transferId;
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

	public String getTransactionState() {
		return transactionState;
	}

	public void setTransactionState(String transactionState) {
		this.transactionState = transactionState;
	}
	
}
