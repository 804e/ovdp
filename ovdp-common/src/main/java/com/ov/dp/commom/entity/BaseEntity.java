package com.ov.dp.commom.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

@Access(AccessType.FIELD)
@MappedSuperclass
public class BaseEntity {

	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
