package com.shop.data.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface MenuMapper extends AbstractMapper {
	
	/**
	 * 获得菜单的权限情况
	 * @param roleId
	 * @return
	 */
	public List<Map<String, Object>> selectAuthorizeMenu(@Param("roleId") int roleId);
	
	/**
	 * 获得权限内的菜单资源
	 * @param userId
	 * @return
	 */
	public List<Menu> selectPermissionMenu(@Param("userId") int userId);
	
	/**
	 * 获得权限
	 * @param userId
	 * @return
	 */
	public List<String> selectPermission(@Param("userId") int userId);
}
