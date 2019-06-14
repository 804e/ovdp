package com.ov.dp.orm.jpa.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 审计字段基类
 * 
 * @author overfight
 *
 */
@MappedSuperclass
public class AuditableDO {

    @Column(name = "create_by")
    private BigInteger createdBy;

    @Column(name = "gmt_create")
    private Date creationDate;

    @Column(name = "last_modified_by")
    private BigInteger lastModifiedBy;

    @Column(name = "gmt_modified")
    private Date lastModifiedDate;

    public BigInteger getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigInteger createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigInteger getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(BigInteger lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
