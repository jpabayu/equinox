package org.equinox.api.bellatrix.payment;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.equinox.api.bellatrix.BaseResponse;
import org.w3c.dom.Document;

public class ReversePaymentResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419071L;
	
	public ReversePaymentResponse() {
		super();
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		Document domDocument = getDocument(xmlString);
		XPath xPath = XPathFactory.newInstance().newXPath();
		setStatus(domDocument, xPath);	
	}
}
