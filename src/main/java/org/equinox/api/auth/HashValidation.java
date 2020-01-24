package org.equinox.api.auth;

import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class HashValidation implements Callable {

	private Logger logger = Logger.getLogger(HashValidation.class);

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String hashContent = (String) eventContext.getMessage().getInvocationProperty("requestAuthContent");
		String secret = (String) eventContext.getMessage().getInvocationProperty("auth_secret");
		String hash = (String) eventContext.getMessage().getInvocationProperty("requestAuth");

		logger.info("[RequestAuth : secret=" + secret + hashContent + "]");

		String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex("secret=" + secret + hashContent);
		logger.info("[Hash Calculation : " + sha256hex + ", RequestHash : " + hash + "]");
		if (hash.equals(sha256hex)) {
			return "ALLOWED";
		} else {
			return "INVALID_SIGNATURE";
		}
	}

}
