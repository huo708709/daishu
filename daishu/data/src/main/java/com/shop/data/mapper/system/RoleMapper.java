package com.shop.data.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shop.data.mapper.AbstractMapper;

public interface RoleMapper extends AbstractMapper {
	
	/**
	 * 
	 * @param user_id
	 * @return
	 */
	public List<Map<String, Object>> selectWithUserId(@Param("userId") int userId);
	
	/**
	 * 
	 * @param roleId
	 * @return
	 */
	public int unAuthorizeAll(@Param("roleId") int roleId);
	
	/**
	 * 
	 * @param roleId
	 * @param functionIds
	 * @return
	 */
	public int authorize(@Param("roleId") int roleId, @Param("functionIds") int[] functionIds);
}
