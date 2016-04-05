package com.shop.manager.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.system.User;
import com.shop.manager.mapper.system.UserMapper;
import com.shop.manager.service.AbstractService;

@Service
public class UserService extends AbstractService<User> {

	@Autowired
	private UserMapper userMapper;
	
	public UserService() {
		super(User.class);
	}
	
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return this.userMapper.findByUsername(username);
	}
	
	/**
	 * 更新用户状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateStatus(int id, int status) {
		return this.userMapper.updateStatus(id, status);
	}

	/**
	 * 分配角色
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	public int assignRoles(int userId, int[] roleIds) {
		this.userMapper.unAssignAllRoles(userId);
		if (null != roleIds && roleIds.length > 0) {
			return this.userMapper.assignRoles(userId, roleIds);
		}
		return 0;
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.userMapper;
	}

}
