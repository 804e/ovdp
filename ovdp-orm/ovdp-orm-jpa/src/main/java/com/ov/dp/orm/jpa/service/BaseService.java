package com.ov.dp.orm.jpa.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ov.dp.orm.jpa.dao.BaseDao;
import com.ov.dp.orm.jpa.entity.BaseDO;

/**
 * 基础数据库访问服务
 * 
 * @author wangweifeng
 *
 * @param <T>
 * @param <ID>
 */
public abstract class BaseService<T extends BaseDO<ID>, ID extends Serializable> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/** 子类设置具体的DAO对象实例 */
	abstract protected BaseDao<T, ID> getDao();

	/**
	 * 创建数据保存数据之前额外操作回调方法 默认为空逻辑，子类根据需要覆写添加逻辑即可
	 * 
	 * @param entity 待创建数据对象
	 */
	protected void preInsert(T entity) {

	}

	/**
	 * 更新数据保存数据之前额外操作回调方法 默认为空逻辑，子类根据需要覆写添加逻辑即可
	 * 
	 * @param entity 待更新数据对象
	 */
	protected void preUpdate(T entity) {

	}

	/**
	 * 数据保存操作
	 * 
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
		getDao().save(entity);
		logger.debug("Saved entity id is {}", entity.getId());
		return entity;
	}

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	public Iterable<T> findAll() {
		return this.getDao().findAll();
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public T findOne(ID id) {
		return this.getDao().findById(id).get();
	}

}
