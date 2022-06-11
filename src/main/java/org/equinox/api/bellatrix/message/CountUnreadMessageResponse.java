package org.equinox.api.bellatrix.message;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.data.Status;
import org.w3c.dom.Document;

public class CountUnreadMessageResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419035L;
	private int unread;

	public CountUnreadMessageResponse() {
		super();
	}

	public int getUnread() {
		return unread;
	}

	public void setUnread(int unread) {
		this.unread = unread;
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		Document domDocument = getDocument(xmlString);
		XPath xPath = XPathFactory.newInstance().newXPath();
		setStatus(domDocument, xPath);
		
		if(!status.getMessage().equals(Status.PROCESSED.name())) return;
		
		this.unread = ((Number) xPath.evaluate("//unread", domDocument, XPathConstants.NUMBER)).intValue();
		
	}
}
