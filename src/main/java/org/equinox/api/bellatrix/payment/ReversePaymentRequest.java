package org.equinox.api.bellatrix.payment;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class ReversePaymentRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419070L;
	
    private String traceNumber;
	
	public ReversePaymentRequest() {
		super(RequestPath.PAYMENTS, "reversePayment");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		
		sb.append(Constants.THREE_INDENT).append("<traceNumber>").append(traceNumber).append("</traceNumber>\n");
		
		return sb.toString();
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}
	
}
