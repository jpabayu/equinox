package org.equinox.api.bellatrix.interbank;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Bank implements Serializable {
	
	private static final long serialVersionUID = 1992806955692419060L;

 	@XmlElement(name="bankId")
	private int id;
	
 	private String bankCode;
	
 	@XmlElement(name="bankName")
 	private String name;
	
 	@XmlElement(name="transferTypeID")
 	private int transferTypeId;
	
 	@XmlTransient
 	private String logoUrl;
	
 	public Bank() {
 		id = -1;
 		bankCode = null;
 		name = null;
 		transferTypeId = -1;
 		logoUrl = null;
 	}
 	
	public boolean standardizedBankName() {
		if(name.contains("eMoney")) {
	    	name = name.replace("eMoney", "").trim();
	    	return true;
	    }
		
		return false;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBankCode() {
		return bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTransferTypeId() {
		return transferTypeId;
	}
	
	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
}
