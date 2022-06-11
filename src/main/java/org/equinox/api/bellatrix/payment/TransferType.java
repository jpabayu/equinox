package org.equinox.api.bellatrix.payment;

import java.io.Serializable;

public class TransferType implements Serializable {
	
	private static final long serialVersionUID = 1992806955692419033L;
	
	private int id;
	private int fromAccounts;
    private String name;
    private int toAccounts;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFromAccounts() {
		return fromAccounts;
	}
	
	public void setFromAccounts(int fromAccounts) {
		this.fromAccounts = fromAccounts;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getToAccounts() {
		return toAccounts;
	}
	
	public void setToAccounts(int toAccounts) {
		this.toAccounts = toAccounts;
	}
    
}
