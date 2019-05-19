package com.ov.dp.orm.jpa.support;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

import com.ov.dp.orm.jpa.dao.BaseDaoImpl;

/**
 * BaseDao实例构造工厂
 * 
 * @author overfight
 *
 */
public class BaseDaoFactory extends JpaRepositoryFactory {

	public BaseDaoFactory(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation metadata,
			EntityManager entityManager) {
		JpaEntityInformation<?, ?> entityInformation = getEntityInformation(metadata.getDomainType());
		// custom implementation
		return new BaseDaoImpl(entityInformation, entityManager);
	}

	/* 
	 * (non-Javadoc) 
	 *  
	 * @see 
	 * org.springframework.data.repository.support.RepositoryFactorySupport# 
	 * getRepositoryBaseClass() 
	 */
	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		return BaseDaoImpl.class;
	}

}
