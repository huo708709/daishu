package com.shop.manager.mapper.system;

import com.shop.manager.mapper.AbstractMapper;

public interface SystemMapper extends AbstractMapper {
	
	public int insertMenu(Menu menu);
	public int insertFunction(Function function);
	public int insertUser(User user);
	public int insertRole(Role role);
	public int insertUserRole(UsersRoles usersroles);
}
