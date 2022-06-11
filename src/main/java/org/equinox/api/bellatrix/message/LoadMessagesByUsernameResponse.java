package org.equinox.api.bellatrix.message;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoadMessagesByUsernameResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419037L;
	
	@XmlElement(name="message")
	private LinkedList<Message> messages = new LinkedList<Message>();

	public LoadMessagesByUsernameResponse() {
		super();
	}
	
	public LinkedList<Message> getMessages() {
		return messages;
	}

	public void setMessages(LinkedList<Message> messages) {
		this.messages = messages;
	}

	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		LoadMessagesByUsernameResponse result = context.parseString(
				xmlString, "loadMessageByUsernameResponse", LoadMessagesByUsernameResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
            this.messages = result.getMessages();
        } else {
        	this.status = new BellatrixStatus();
        }
	}
}
