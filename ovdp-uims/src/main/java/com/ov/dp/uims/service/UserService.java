package com.ov.dp.uims.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ov.dp.orm.jpa.dao.BaseDao;
import com.ov.dp.orm.jpa.service.BaseService;
import com.ov.dp.uims.dao.UserDao;
import com.ov.dp.uims.entity.UserDO;

/**
 * 用户信息服务层
 * 
 * @author overfight
 *
 */
@Service
@Transactional
public class UserService extends BaseService<UserDO, Long> {

	@Autowired
	private UserDao userDao;

	@Override
	protected BaseDao<UserDO, Long> getDao() {
		return userDao;
	}

	/**
	 * 根据帐号查找用户
	 * 
	 * @param account
	 * @return
	 */
	public UserDO findByAccount(String account) {
		return this.userDao.findByAccount(account);
	}

}
