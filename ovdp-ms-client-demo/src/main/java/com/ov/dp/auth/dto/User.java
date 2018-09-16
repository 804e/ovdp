package com.ov.dp.auth.dto;

import com.ov.dp.commom.entity.BaseEntity;

public class User extends BaseEntity<String> {

	public String account;

	public String name;

	public String email;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
