package com.shop.manager.mapper.system;

import org.apache.ibatis.annotations.Param;

import com.shop.manager.mapper.AbstractMapper;

public interface UserMapper extends AbstractMapper {
	
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	public User findByUsername(@Param("username") String username);
	
	/**
	 * 更新用户状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateStatus(@Param("id") int id, @Param("status") int status);
	
	/**
	 * 分配角色
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	public int assignRoles(@Param("userId") int userId, @Param("roleIds") int[] roleIds);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public int unAssignAllRoles(@Param("userId") int userId);
}
