package com.ov.dp.orm.jpa.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * BaseDaoFactory实例生成支持类
 * @author overfight
 *
 * @param <T>
 */
public class BaseDaoFactoryBean<T extends JpaRepository<Object, Serializable>>
		extends JpaRepositoryFactoryBean<T, Object, Serializable> {
	
	public BaseDaoFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {

		return new BaseDaoFactory(em);
	}

}
