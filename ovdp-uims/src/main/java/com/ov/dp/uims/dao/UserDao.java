package com.ov.dp.uims.dao;

import com.ov.dp.orm.jpa.dao.BaseDao;
import com.ov.dp.uims.entity.UserDO;

/**
 * 用户信息数据库访问层
 * 
 * @author overfight
 *
 */
public interface UserDao extends BaseDao<UserDO, Long> {

	/**
	 * 根据帐号查找用户
	 * 
	 * @param account
	 * @return
	 */
	public UserDO findByAccount(String account);

}
