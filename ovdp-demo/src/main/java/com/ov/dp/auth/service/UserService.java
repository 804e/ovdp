package com.ov.dp.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ov.dp.auth.dao.UserRepository;
import com.ov.dp.auth.entity.UserEntity;
import com.ov.dp.orm.jpa.dao.BaseDao;
import com.ov.dp.orm.jpa.service.BaseService;

@Service
public class UserService extends BaseService<UserEntity, String> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	protected BaseDao<UserEntity, String> getDao() {
		return userRepository;
	}

}
