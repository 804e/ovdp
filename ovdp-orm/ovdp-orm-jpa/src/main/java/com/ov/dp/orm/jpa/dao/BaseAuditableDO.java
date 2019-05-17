package com.ov.dp.orm.jpa.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.ov.dp.orm.jpa.entity.BaseDO;

/**
 * 审计字段基类
 * 
 * @author overfight
 *
 */
@MappedSuperclass
public class BaseAuditableDO extends BaseDO {

	@Column(name = "create_by")
	private Long createdBy;

	@Column(name = "gmt_create")
	private Date creationDate;

	@Column(name = "last_modified_by")
	private Long lastModifiedBy;

	@Column(name = "gmt_modified")
	private Date lastModifiedDate;

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
