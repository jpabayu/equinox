package org.equinox.api.bellatrix.member;

import java.io.Serializable;

public class BaseMember implements Serializable {
	
	private static final long serialVersionUID = 1992806955692419031L;
	protected long id;
	protected String name;
	protected String username;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}