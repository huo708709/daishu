package com.shop.manager.service.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.manager.mapper.AbstractMapper;
import com.shop.manager.mapper.system.Menu;
import com.shop.manager.mapper.system.MenuMapper;
import com.shop.manager.service.AbstractService;

@Service
public class MenuService extends AbstractService<Menu> {

	@Autowired
	private MenuMapper menuMapper;
	
	public MenuService() {
		super(Menu.class);
	}
	
	/**
	 * 获得菜单的权限情况
	 * @param roleId
	 * @return
	 */
	public List<Map<String, Object>> selectAuthorizeMenu(int roleId) {
		List<Map<String, Object>> menus = this.menuMapper.selectAuthorizeMenu(roleId);
		return menus;
	}
	
	/**
	 * 获得权限内的菜单资源
	 * @param userId
	 * @return
	 */
	public List<Menu> selectPermissionMenu(int userId) {
		List<Menu> menus = this.menuMapper.selectPermissionMenu(userId);
		List<Menu> list = new ArrayList<Menu>();
		for (Menu menu : menus) {
			if (menu.getParentId() == 0) {
				List<Menu> children = new ArrayList<Menu>();
				for (Menu child : menus) {
					if (child.getParentId() == menu.getId()) {
						children.add(child);
					}
				}
				menu.setChildren(children);
				list.add(menu);
			}
		}
		return list;
	}

	/**
	 * 获得权限
	 * @param userId
	 * @return
	 */
	public List<String> selectPermission(int userId) {
		return this.menuMapper.selectPermission(userId);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return this.menuMapper;
	}

}
