package com.shop.service.system;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.system.Role;
import com.shop.data.mapper.system.RoleMapper;
import com.shop.service.AbstractService;

@Service
public class RoleService extends AbstractService<Role> {

	@Autowired
	private RoleMapper roleMapper;
	
	public RoleService() {
		super(Role.class);
	}
	
	/**
	 * 
	 * @param user_id
	 * @return
	 */
	public List<Map<String, Object>> selectWithUserId(int userId) {
		return this.roleMapper.selectWithUserId(userId);
	}
	
	/**
	 * 授权
	 * @param roleId
	 * @param functionIds
	 * @return
	 */
	public int authorize(int roleId, int[] functionIds) {
		this.roleMapper.unAuthorizeAll(roleId);
		if (ArrayUtils.isNotEmpty(functionIds)) {
			return this.roleMapper.authorize(roleId, functionIds);
		}
		return 0;
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return this.roleMapper;
	}

}
