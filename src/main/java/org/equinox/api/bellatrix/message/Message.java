package org.equinox.api.bellatrix.message;

public class Message {
	
	private int id;
	private String subject;
	private boolean read;
	private String body;
	private String date;
	private String formattedDate;
	private String fromName;
	private String fromUsername;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public boolean isRead() {
		return read;
	}
	
	public void setRead(boolean read) {
		this.read = read;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getFormattedDate() {
		return formattedDate;
	}
	
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
	
	public String getFromName() {
		return fromName;
	}
	
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	
	public String getFromUsername() {
		return fromUsername;
	}
	
	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
	}
}
