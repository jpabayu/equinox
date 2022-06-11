package org.equinox.api.bellatrix.member;

import org.equinox.api.bellatrix.BaseResponse;
import org.equinox.api.bellatrix.BellatrixJAXBContext;
import org.equinox.api.bellatrix.BellatrixStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class LoadMemberByUsernameResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1992806955692419010L;
	
	@XmlElement(name="members")
	private Member member;

	public LoadMemberByUsernameResponse() {
		super();
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	@Override
	public void parseResponse(String xmlString) throws Exception {
		BellatrixJAXBContext context = BellatrixJAXBContext.getInstance();
		LoadMemberByUsernameResponse result = context.parseString(
				xmlString, "loadMembersByUsernameResponse", LoadMemberByUsernameResponse.class);
		
		if(result != null) {
        	this.status = result.getStatus();
            this.member = result.getMember();
        } else {
        	this.status = new BellatrixStatus();
        }
	}
}
