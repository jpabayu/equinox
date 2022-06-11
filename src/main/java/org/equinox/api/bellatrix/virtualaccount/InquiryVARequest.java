package org.equinox.api.bellatrix.virtualaccount;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class InquiryVARequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419077L;
	
    private String paymentCode;
	
	public InquiryVARequest() {
		super(RequestPath.VIRTUAL_ACCOUNTS, "inquiryVA");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<paymentCode>").append(paymentCode).append("</paymentCode>\n");
		
		return sb.toString();
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
}
