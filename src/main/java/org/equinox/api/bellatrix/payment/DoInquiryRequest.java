package org.equinox.api.bellatrix.payment;

import java.math.BigDecimal;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class DoInquiryRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419066L;
	
    private String fromMember;
    private String toMember;
    private BigDecimal amount;
    private int transferTypeId;
	
	public DoInquiryRequest() {
		super(RequestPath.PAYMENTS, "doInquiry");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		
		sb.append(Constants.THREE_INDENT).append("<fromMember>").append(fromMember).append("</fromMember>\n");
		sb.append(Constants.THREE_INDENT).append("<toMember>").append(toMember).append("</toMember>\n");
		sb.append(Constants.THREE_INDENT).append("<amount>").append(amount).append("</amount>\n");
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

	public int getTransferTypeId() {
		return transferTypeId;
	}

	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}
	
}
