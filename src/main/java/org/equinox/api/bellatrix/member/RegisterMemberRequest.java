package org.equinox.api.bellatrix.member;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class RegisterMemberRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419025L;
	private String name;
	private String email;
	private int groupId;
	private String msisdn;
	private String uid;
	private ExternalMemberRequestField externalMember;
	
	public RegisterMemberRequest() {
		super(RequestPath.MEMBERS, "registerMembers");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		
		sb.append(Constants.THREE_INDENT).append("<name>").append((name != null) ? name : "").append("</name>\n");
		sb.append(Constants.THREE_INDENT).append("<email>").append((email != null) ? email : "").append("</email>\n");
		sb.append(Constants.THREE_INDENT).append("<groupID>").append(groupId).append("</groupID>\n");
		sb.append(Constants.THREE_INDENT).append("<msisdn>").append((msisdn != null) ? msisdn : "").append("</msisdn>\n");
		sb.append(Constants.THREE_INDENT).append("<uid>").append((uid != null) ? uid : "").append("</uid>\n");
		
		if(externalMember != null) {
			sb.append(Constants.THREE_INDENT).append("<externalMemberFields>\n");
			sb.append(externalMember.getBodyContent());
			sb.append(Constants.THREE_INDENT).append("</externalMemberFields>\n");
		}
		
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public ExternalMemberRequestField getExternalMember() {
		return externalMember;
	}

	public void setExternalMember(ExternalMemberRequestField externalMember) {
		this.externalMember = externalMember;
	}
}
