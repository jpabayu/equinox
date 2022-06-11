package org.equinox.api.bellatrix;

import java.io.Serializable;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.apache.commons.lang.StringUtils;
import org.equinox.api.data.Status;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public abstract class BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 1992806955692419003L;
	
	@JsonIgnore
	protected BellatrixStatus status;

	public BellatrixStatus getStatus() {
		return status;
	}

	public void setStatus(BellatrixStatus status) {
		this.status = status;
	}

	//parse xml string using DOM Parser
	protected Document getDocument(String xmlString) throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder domParser = builderFactory.newDocumentBuilder();
		InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlString));
		return domParser.parse(is);
	}
	
	protected void setStatus(Document domDocument, XPath xPath) throws Exception {
		status = new BellatrixStatus();
		status.setMessage((String) xPath.evaluate("//status/message", domDocument, XPathConstants.STRING));
	}
	
	protected void setAndCheckErrorStatus(Document domDocument, XPath xPath) throws Exception {
		status = new BellatrixStatus();
		status.setMessage((String) xPath.evaluate("//faultstring", domDocument, XPathConstants.STRING));
		
		if(StringUtils.isEmpty(status.getMessage())) {
			status.setMessage(Status.PROCESSED.name());
		}
	}
	
	public abstract void parseResponse(String xmlString) throws Exception;
}
