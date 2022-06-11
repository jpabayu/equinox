package org.equinox.api.bellatrix.virtualaccount;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Originator implements Serializable {
	
	private static final long serialVersionUID = 1992806955692419079L;
	
	private long id;
	private String username;
	private String name;
	
	@XmlElement(name="groupID")
	private int groupId;
	
	private String email;
	private boolean emailVerify;
	private String msisdn;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGroupId() {
		return groupId;
	}
	
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
	
	public String getMsisdn() {
		return msisdn;
	}
	
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}	
}
