/**
 * 
 */
package com.bd17kaka.autopaper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.util.CollectionUtils;

import com.bd17kaka.autopaper.dao.UserMapper;
import com.bd17kaka.autopaper.po.User;
import com.bd17kaka.autopaper.po.example.UserExample;

/**
 * @author Administrator
 *
 */
public abstract class BaseService {
	
	@Resource
	private UserMapper userMapper;
	
	public boolean userNameExist(User user) {
		UserExample example = new UserExample();
		example.or().andNameEqualTo(user.getName());
		if (!CollectionUtils.isEmpty(userMapper.selectByExample(example))) {
			return true;
		}
		return false;
	}

	public boolean userEmailVerify(User user) {
		UserExample example = new UserExample();
		example.or().andEmailEqualTo(user.getEmail()).andEmailVerifyEqualTo(User.EMAIL_VERIFY);
		return !CollectionUtils.isEmpty(userMapper.selectByExample(example));
	}
	
	public Map<Long, User> mapUserByIds(List<Long> userIds) {
		UserExample userExample = new UserExample();
		userExample.or().andIdIn(userIds);
		List<User> listUser = userMapper.selectByExample(userExample);
		if (CollectionUtils.isEmpty(listUser)) return null;
		
		Map<Long, User> mapUser = new HashMap<Long, User>();
		for (User u : listUser) {
			mapUser.put(u.getId(), u);
		}
		return mapUser;
	}
	
}
