package org.equinox.api.auth;

import java.util.Map;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTDecoder {

	public String decodeJWTHMAC256(Map<String, Object> request) throws Exception {
		DecodedJWT jwt = JWT.decode((String) request.get("token"));
		return jwt.getId();
	}

}
