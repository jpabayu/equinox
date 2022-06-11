package org.equinox.api.auth;

import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTProcessor implements Callable {

	private String issuer;
	private String subject;

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		DateTime dt = new DateTime();
		DateTime added = dt.plusHours(24);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> payload = (Map<String, Object>) eventContext.getMessage().getPayload(Map.class);
		return createJWTHMAC256(getIssuer(), getSubject(), (String) payload.get("username"), (String) payload.get("auth_secret"),
				added.toDate());

	}

	public String createJWTHMAC256(String issuer, String subject, String mid, String secret, Date expired) {
		try {
			String token = JWT.create().withIssuer(issuer).withSubject(subject).withJWTId(mid).withExpiresAt(expired)
					.sign(Algorithm.HMAC256(secret));
			return token;
		} catch (Exception exception) {
			return "0";
		}
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
