package com.ov.dp.orm.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ov.dp.orm.jpa.dao.BaseDaoImpl;
import com.ov.dp.orm.jpa.support.BaseDaoFactoryBean;

/**
 * jpa相关配置
 * 
 * @author overfight
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = {
		"com.ov.dp.**.dao.**" }, repositoryBaseClass = BaseDaoImpl.class, repositoryFactoryBeanClass = BaseDaoFactoryBean.class)
@EnableTransactionManagement(proxyTargetClass = true)
public class JpaConfiguration {

}
