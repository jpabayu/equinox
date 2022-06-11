package org.equinox.api.exception;

@SuppressWarnings("serial")
public class InvalidCRCException extends Exception {
	
	public InvalidCRCException(String errorMessage) {
		super(errorMessage);
	}
	
}
