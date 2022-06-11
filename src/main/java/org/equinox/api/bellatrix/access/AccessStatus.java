package org.equinox.api.bellatrix.access;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccessStatus implements Serializable {
	
	private static final long serialVersionUID = 1992806955692419006L;
	
	@XmlElement(name="accessTypeID")
	private int accessTypeId;
	
	private boolean blocked;
	private boolean expired;
	
	public int getAccessTypeId() {
		return accessTypeId;
	}
	
	public void setAccessTypeId(int accessTypeId) {
		this.accessTypeId = accessTypeId;
	}
	
	public boolean isBlocked() {
		return blocked;
	}
	
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	public boolean isExpired() {
		return expired;
	}
	
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
}
