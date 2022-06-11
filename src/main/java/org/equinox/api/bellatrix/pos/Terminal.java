package org.equinox.api.bellatrix.pos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.equinox.api.bellatrix.member.BaseMember;

@XmlAccessorType(XmlAccessType.FIELD)
public class Terminal implements Serializable{
	
	private static final long serialVersionUID = 1992806955692419084L;
    
    private int id;
    private String name;
    
    @XmlElement(name="nnsID")
    private String nnsId;
    
    private String pic;
    private String email;
    private String msisdn;
    private String address;
    private String city;
    private String merchantCategoryCode;
    private String postalCode;
    private String nmid;
    private String merchantCriteria;
    private String notificationURL;
    private String terminal;
    
    @XmlElement(name="transferTypeID")
    private int transferTypeId;
	
    private BaseMember member;
    
    public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNnsId() {
		return nnsId;
	}
	
	public void setNnsId(String nnsId) {
		this.nnsId = nnsId;
	}
	
	public String getPic() {
		return pic;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getMerchantCategoryCode() {
		return merchantCategoryCode;
	}
	
	public void setMerchantCategoryCode(String merchantCategoryCode) {
		this.merchantCategoryCode = merchantCategoryCode;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getNmid() {
		return nmid;
	}

	public void setNmid(String nmid) {
		this.nmid = nmid;
	}

	public String getMerchantCriteria() {
		return merchantCriteria;
	}

	public void setMerchantCriteria(String merchantCriteria) {
		this.merchantCriteria = merchantCriteria;
	}

	public String getNotificationURL() {
		return notificationURL;
	}

	public void setNotificationURL(String notificationURL) {
		this.notificationURL = notificationURL;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public int getTransferTypeId() {
		return transferTypeId;
	}
	
	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}

	public BaseMember getMember() {
		return member;
	}

	public void setMember(BaseMember member) {
		this.member = member;
	}
    
}
