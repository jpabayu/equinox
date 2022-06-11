package org.equinox.api.bellatrix.member;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Member extends BaseMember  {
	
	private static final long serialVersionUID = 1992806955692419011L;
	
	@XmlElement(name="groupID")
	private int groupId;
	
	private String msisdn;
	private String idCardNo;
	private String address;
	private String dateOfBirth;
	private String placeOfBirth;
	private String nationality;
	private String sex;
	private String email;
	private boolean emailVerify;
	private String motherMaidenName;
	private String work;
	private String kycStatus;
	
	@XmlElement(name="fcmID")
	private String fcmId;
	
	private String uid;
	private String createdDate;

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
	
	public String getIdCardNo() {
		return idCardNo;
	}
	
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
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
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
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
	
	public boolean isEmailVerify() {
		return emailVerify;
	}
	
	public void setEmailVerify(boolean emailVerify) {
		this.emailVerify = emailVerify;
	}
	
	public String getMotherMaidenName() {
		return motherMaidenName;
	}
	
	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}
	
	public String getWork() {
		return work;
	}
	
	public void setWork(String work) {
		this.work = work;
	}
	
	public String getKycStatus() {
		return kycStatus;
	}
	
	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}
	
	public String getFcmId() {
		return fcmId;
	}
	
	public void setFcmId(String fcmId) {
		this.fcmId = fcmId;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
