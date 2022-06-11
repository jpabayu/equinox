package org.equinox.api.bellatrix.member;

import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class UpdateMemberRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419012L;
	private String name;
	private String address;
	private String dateOfBirth;
	private String placeOfBirth;
	private String sex;
	private String email;
	private Boolean emailVerify;
	private Integer groupId;
	private String idCardNo;
	private String motherMaidenName;
	private String msisdn;
	private String nationality;
	private String work;
	private String uid;
	private String fcmId;
	
	public UpdateMemberRequest() {
		super(RequestPath.MEMBERS, "updateMembers");
		name = null;
		address = null;
		dateOfBirth = null;
		placeOfBirth = null;
		sex = null;
		email = null;
		emailVerify = null;
		groupId = null;
		idCardNo = null;
		motherMaidenName = null;
		msisdn = null;
		nationality = null;
		work = null;
		uid = null;
		fcmId = null;
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		
		if(name != null) {
			sb.append(Constants.THREE_INDENT).append("<name>").append(name).append("</name>\n");
		}
		
		if(address != null) {
			sb.append(Constants.THREE_INDENT).append("<address>").append(address).append("</address>\n");
		}
		
		if(dateOfBirth != null) {
			sb.append(Constants.THREE_INDENT).append("<dateOfBirth>").append(dateOfBirth).append("</dateOfBirth>\n");
		}
		
		if(placeOfBirth != null) {
			sb.append(Constants.THREE_INDENT).append("<placeOfBirth>").append(placeOfBirth).append("</placeOfBirth>\n");
		}
		
		if(sex != null) {
			sb.append(Constants.THREE_INDENT).append("<sex>").append(sex).append("</sex>\n");
		}
		
		if(email != null) {
			sb.append(Constants.THREE_INDENT).append("<email>").append(email).append("</email>\n");
		}
		
		if(emailVerify != null) {
			sb.append(Constants.THREE_INDENT).append("<emailVerify>").append(emailVerify).append("</emailVerify>\n");
		}
		
		if(groupId != null) {
			sb.append(Constants.THREE_INDENT).append("<groupID>").append(groupId).append("</groupID>\n");
		}
		
		if(idCardNo != null) {
			sb.append(Constants.THREE_INDENT).append("<idCardNo>").append(idCardNo).append("</idCardNo>\n");
		}
		
		if(motherMaidenName != null) {
			sb.append(Constants.THREE_INDENT).append("<motherMaidenName>").append(motherMaidenName).append("</motherMaidenName>\n");
		}
		
		if(msisdn != null) {
			sb.append(Constants.THREE_INDENT).append("<msisdn>").append(msisdn).append("</msisdn>\n");
		}
		
		if(nationality != null) {
			sb.append(Constants.THREE_INDENT).append("<nationality>").append(nationality).append("</nationality>\n");
		}
		
		if(work != null) {
			sb.append(Constants.THREE_INDENT).append("<work>").append(work).append("</work>\n");
		}
		
		if(uid != null) {
			sb.append(Constants.THREE_INDENT).append("<uid>").append(uid).append("</uid>\n");
		}
		
		if(fcmId != null) {
			sb.append(Constants.THREE_INDENT).append("<fcmID>").append(fcmId).append("</fcmID>\n");
		}
		
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(Boolean emailVerify) {
		this.emailVerify = emailVerify;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getMotherMaidenName() {
		return motherMaidenName;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFcmId() {
		return fcmId;
	}

	public void setFcmId(String fcmId) {
		this.fcmId = fcmId;
	}
	
	
}
