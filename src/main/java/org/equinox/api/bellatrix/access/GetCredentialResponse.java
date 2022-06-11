package org.equinox.api.bellatrix.access;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.data.Status;
import org.w3c.dom.Document;

public class GetCredentialResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419023L;
	
	private int id;
	private String credential;
	private String internalName;
	private String name;
	private boolean validate;
	
	public GetCredentialResponse() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getInternalName() {
		return internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	@Override
	public void parseResponse(String xmlString) throws Exception {
		Document domDocument = getDocument(xmlString);
		XPath xPath = XPathFactory.newInstance().newXPath();
		setStatus(domDocument, xPath);
		
		if(!status.getMessage().equals(Status.PROCESSED.name())) return;
		
		Number id = (Number) xPath.evaluate("//id", domDocument, XPathConstants.NUMBER);
		this.id = id.intValue();
		
		this.credential = (String) xPath.evaluate("//credential", domDocument, XPathConstants.STRING);
		this.internalName = (String) xPath.evaluate("//internalName", domDocument, XPathConstants.STRING);
		this.name = (String) xPath.evaluate("//name", domDocument, XPathConstants.STRING);
		
		String validate = (String) xPath.evaluate("//validate", domDocument, XPathConstants.STRING);
		this.validate = Boolean.parseBoolean(validate);
	}
}
