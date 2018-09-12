package com.ov.dp.commom.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ov.dp.commom.dao.BaseRepository;
import com.ov.dp.commom.entity.BaseEntity;

/**
 * 基础数据库访问服务
 * @author wangweifeng
 *
 * @param <T>
 * @param <ID>
 */
public abstract class BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/** 子类设置具体的DAO对象实例 */
	abstract protected BaseRepository<T, ID> getRepository();

	/**
	 * 创建数据保存数据之前额外操作回调方法 默认为空逻辑，子类根据需要覆写添加逻辑即可
	 * @param entity 待创建数据对象
	 */
	protected void preInsert(T entity) {

	}

	/**
	 * 更新数据保存数据之前额外操作回调方法 默认为空逻辑，子类根据需要覆写添加逻辑即可
	 * @param entity 待更新数据对象
	 */
	protected void preUpdate(T entity) {

	}

	/**
	 * 数据保存操作
	 * @param entity
	 * @return
	 */
	@Transactional
	public T save(T entity) {
		if (entity.isNew()) {
			preInsert(entity);
		} else {
			preUpdate(entity);
		}
		getRepository().save(entity);
		logger.debug("Saved entity id is {}", entity.getId());
		return entity;
	}

	/**
	 * 查询所有记录
	 * @return
	 */
	public Iterable<T> findAll() {
		return this.getRepository().findAll();
	}

}
