package org.equinox.api.bellatrix.member;

import org.apache.commons.lang.StringUtils;
import org.equinox.api.bellatrix.BaseMemberRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class RegisterMemberKycRequest extends BaseMemberRequest {
	
	private static final long serialVersionUID = 1992806955692419027L;
	private String address;
	private String dateOfBirth;
	private String placeOfBirth;
	private int groupId;
	private String idCardNo;
	private String motherMaidenName;
	private String sex;
	private String nationality;
	private String work;
	private String imagePath1;
	private String imagePath2;
	private String imagePath3;
	
	public RegisterMemberKycRequest() {
		super(RequestPath.MEMBERS, "membersKYCRequest");
	}
	
	@Override
	public String getBodyContent() {
		String usernameField = super.getBodyContent();
		sb.setLength(0);
		sb.append(usernameField);
		
		sb.append(Constants.THREE_INDENT).append("<address>").append((address != null) ? address : "").append("</address>\n");
		sb.append(Constants.THREE_INDENT).append("<dateOfBirth>").append((dateOfBirth != null) ? dateOfBirth : "").append("</dateOfBirth>\n");
		sb.append(Constants.THREE_INDENT).append("<placeOfBirth>").append((placeOfBirth != null) ? placeOfBirth : "").append("</placeOfBirth>\n");
		sb.append(Constants.THREE_INDENT).append("<groupID>").append(groupId).append("</groupID>\n");
		sb.append(Constants.THREE_INDENT).append("<idCardNo>").append((idCardNo != null) ? idCardNo : "").append("</idCardNo>\n");
		sb.append(Constants.THREE_INDENT).append("<motherMaidenName>").append((motherMaidenName != null) ? motherMaidenName : "").append("</motherMaidenName>\n");
		sb.append(Constants.THREE_INDENT).append("<sex>").append((sex != null) ? sex : "").append("</sex>\n");
		sb.append(Constants.THREE_INDENT).append("<nationality>").append((nationality != null) ? nationality : "").append("</nationality>\n");
		sb.append(Constants.THREE_INDENT).append("<work>").append((work != null) ? work : "").append("</work>\n");
		
		if(!StringUtils.isEmpty(imagePath1)) {
			sb.append(Constants.THREE_INDENT).append("<imagePath1>").append(imagePath1).append("</imagePath1>\n");
		}
		
		if(!StringUtils.isEmpty(imagePath2)) {
			sb.append(Constants.THREE_INDENT).append("<imagePath2>").append(imagePath2).append("</imagePath2>\n");
		}
		
		if(!StringUtils.isEmpty(imagePath3)) {
			sb.append(Constants.THREE_INDENT).append("<imagePath3>").append(imagePath3).append("</imagePath3>\n");
		}
		
		return sb.toString();
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

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getImagePath1() {
		return imagePath1;
	}

	public void setImagePath1(String imagePath1) {
		this.imagePath1 = imagePath1;
	}

	public String getImagePath2() {
		return imagePath2;
	}

	public void setImagePath2(String imagePath2) {
		this.imagePath2 = imagePath2;
	}

	public String getImagePath3() {
		return imagePath3;
	}

	public void setImagePath3(String imagePath3) {
		this.imagePath3 = imagePath3;
	}
}
