package org.equinox.api.bellatrix.access;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.data.Status;
import org.w3c.dom.Document;

public class CredentialStatusResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419005L;
	
	private AccessStatus accessStatus;
	
	public CredentialStatusResponse() {
		super();
	}

	public AccessStatus getAccessStatus() {
		return accessStatus;
	}

	public void setAccessStatus(AccessStatus accessStatus) {
		this.accessStatus = accessStatus;
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		Document domDocument = getDocument(xmlString);
		XPath xPath = XPathFactory.newInstance().newXPath();
		setStatus(domDocument, xPath);
		
		if(!status.getMessage().equals(Status.PROCESSED.name())) return;
		
		accessStatus = new AccessStatus();
		
		Number accessTypeId = (Number) xPath.evaluate("//accessStatus/accessTypeID", domDocument, XPathConstants.NUMBER);
		accessStatus.setAccessTypeId(accessTypeId.intValue());
		
		String blocked = (String) xPath.evaluate("//accessStatus/blocked", domDocument, XPathConstants.STRING);
		accessStatus.setBlocked(Boolean.parseBoolean(blocked));
		
		String expired = (String) xPath.evaluate("//accessStatus/expired", domDocument, XPathConstants.STRING);
		accessStatus.setExpired(Boolean.parseBoolean(expired));
	}
}
