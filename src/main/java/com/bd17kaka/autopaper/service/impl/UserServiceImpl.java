/**
 * 
 */
package com.bd17kaka.autopaper.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bd17kaka.autopaper.dao.KeyValueMapper;
import com.bd17kaka.autopaper.dao.UserMapper;
import com.bd17kaka.autopaper.service.BaseService;
import com.bd17kaka.autopaper.service.UserService;

/**
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Resource
	private KeyValueMapper keyValueMapper;
}
