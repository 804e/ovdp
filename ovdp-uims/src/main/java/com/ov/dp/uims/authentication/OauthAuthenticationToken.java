package com.ov.dp.uims.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class OauthAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private String accessToken;

	private static final long serialVersionUID = -1089630833289087771L;

	public OauthAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
