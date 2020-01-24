package org.equinox.api.data;

import java.io.Serializable;

public class ExternalMembers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7404452719444389518L;
	private Integer parentID;
	private String externalID;
	private String description;

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public String getExternalID() {
		return externalID;
	}

	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
