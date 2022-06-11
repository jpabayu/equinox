package org.equinox.api.bellatrix.message;

import org.equinox.api.bellatrix.BaseRequest;
import org.equinox.api.bellatrix.RequestPath;
import org.equinox.api.data.Constants;

public class SendMessageRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1992806955692419085L;
	
	private String fromUsername;
	private String toUsername;
	private String subject;
	private String body;
	
	public SendMessageRequest() {
		super(RequestPath.MESSAGE, "sendMessage");
	}
	
	@Override
	public String getBodyContent() {
		sb.setLength(0);
		sb.append(Constants.THREE_INDENT).append("<fromUsername>").append(fromUsername).append("</fromUsername>\n");
		sb.append(Constants.THREE_INDENT).append("<toUsername>").append(toUsername).append("</toUsername>\n");
		sb.append(Constants.THREE_INDENT).append("<subject>").append(subject).append("</subject>\n");
		sb.append(Constants.THREE_INDENT).append("<body>").append(body).append("</body>\n");
		
		return sb.toString();
	}

	public String getFromUsername() {
		return fromUsername;
	}

	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
	}

	public String getToUsername() {
		return toUsername;
	}

	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
