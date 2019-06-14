package com.ov.dp.orm.jpa.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;

/**
 * DO基类，根据数据库id字段数据类型选择合适的java类型<br/>
 * <table border="1">
 * <tr>
 * <th>mysql字段类型</th>
 * <th>java字段类型</th>
 * </tr>
 * <tr>
 * <td>unsigned int</td>
 * <td>java.math.BigInteger</td>
 * </tr>
 * </table>
 * 
 * @author overfight
 *
 */
@MappedSuperclass
public class BaseDO<ID> extends AuditableDO implements Persistable<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public boolean isNew() {
        return null == this.id;
    }

}
