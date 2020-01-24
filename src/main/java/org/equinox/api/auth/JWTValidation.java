package org.equinox.api.auth;

import java.util.Map;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTValidation {

	private String issuer;

	public String verifyJWTHMAC256(Map<String, Object> credential) throws Exception {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256((String) credential.get("auth_secret"))).withIssuer(getIssuer()).build();
		DecodedJWT jwt = verifier.verify((String) credential.get("token"));
		return jwt.getId();
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
}
