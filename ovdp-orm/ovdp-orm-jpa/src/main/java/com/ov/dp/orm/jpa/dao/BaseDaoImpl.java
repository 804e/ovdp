package com.ov.dp.orm.jpa.dao;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 自定义dao默认方法实现类
 * 
 * @author overfight
 *
 */
@NoRepositoryBean
public class BaseDaoImpl<T, ID> extends SimpleJpaRepository<T, ID> {
	
	protected final EntityManager entityManager;

	public BaseDaoImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}
	
	public BaseDaoImpl(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

}
