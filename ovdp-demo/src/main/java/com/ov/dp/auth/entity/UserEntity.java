package com.ov.dp.auth.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ov.dp.orm.jpa.entity.BaseEntity;

@Entity
@Access(AccessType.FIELD)
@Table(name = "auth_user")
public class UserEntity extends BaseEntity<String> {

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
