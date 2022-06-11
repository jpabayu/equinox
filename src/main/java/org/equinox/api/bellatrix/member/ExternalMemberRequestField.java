package org.equinox.api.bellatrix.member;

import java.io.Serializable;
import org.equinox.api.bellatrix.RequestBodyContent;
import org.equinox.api.data.Constants;

public class ExternalMemberRequestField implements Serializable, RequestBodyContent {
	
	private static final long serialVersionUID = 1992806955692419024L;
	
	private String externalId;
	private long parentId;
	private String description;
	private StringBuilder sb;
    
	public ExternalMemberRequestField() {
		sb = new StringBuilder();
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		sb.append(Constants.FOUR_INDENT).append("<externalID>").append(externalId).append("</externalID>\n");
		sb.append(Constants.FOUR_INDENT).append("<parentID>").append(parentId).append("</parentID>\n");
		sb.append(Constants.FOUR_INDENT).append("<description>").append(description).append("</description>\n");
		
		return sb.toString();
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
