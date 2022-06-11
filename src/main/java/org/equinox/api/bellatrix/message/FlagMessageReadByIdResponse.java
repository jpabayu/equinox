package org.equinox.api.bellatrix.message;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.equinox.api.bellatrix.BaseResponse;
import org.w3c.dom.Document;

public class FlagMessageReadByIdResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419039L;

	public FlagMessageReadByIdResponse() {
		super();
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		Document domDocument = getDocument(xmlString);
		XPath xPath = XPathFactory.newInstance().newXPath();
		setAndCheckErrorStatus(domDocument, xPath);
		
	}
}
