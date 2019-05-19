package com.ov.dp.uims.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.ov.dp.orm.jpa.entity.BaseAuditableDO;

/**
 * 用户实体
 * 
 * @author overfight
 *
 */
@Entity
public class UserDO extends BaseAuditableDO {

	@Column(name = "user_account")
	private String account;

	@Column(name = "user_name")
	private String name;

	@Column(name = "user_password")
	private String password;

	@Column(name = "user_email")
	private String email;

	@Column(name = "mobile_phone")
	private String mobilePhone;

	@Column(name = "is_deleted")
	private boolean deleted;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
