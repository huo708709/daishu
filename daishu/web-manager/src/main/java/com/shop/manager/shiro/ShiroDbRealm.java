package com.shop.manager.shiro;

import java.io.Serializable;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.shop.data.mapper.system.Menu;
import com.shop.data.mapper.system.User;
import com.shop.manager.exception.IncorrectCaptchaException;
import com.shop.manager.web.servlet.SimpleCaptchaServlet;
import com.shop.service.system.MenuService;
import com.shop.service.system.UserService;

public class ShiroDbRealm extends AuthorizingRealm {

	protected static final int INTERATIONS = 1024;
	protected static final int SALT_SIZE = 8;
	protected static final String ALGORITHM = "SHA-1";

	protected boolean useCaptcha = false;

	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;

	/**
	 * 给ShiroDbRealm提供编码信息，用于密码密码比对 描述
	 */
	public ShiroDbRealm() {
		super();
		//		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(ALGORITHM);
		//		matcher.setHashIterations(INTERATIONS);
		//		setCredentialsMatcher(matcher);
	}

	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		if (useCaptcha) {// 验证码检测
			CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;

			String parm = token.getCaptcha();
			String c = (String) SecurityUtils.getSubject().getSession()
					.getAttribute(SimpleCaptchaServlet.CAPTCHA_KEY);
			// 忽略大小写
			if (!parm.equalsIgnoreCase(c)) {
				throw new IncorrectCaptchaException("验证码错误！");
			}
		}

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.findByUsername(token.getUsername());
		if (null != user) {
			if (user.getStatus() == User.STATUS_FORBIDDEN) {// 禁用
				throw new DisabledAccountException();
			}
			List<Menu> menus = this.menuService.selectPermissionMenu(user.getId());
			ShiroUser shiroUser = new ShiroUser(user.getId(),
					user.getUsername(), user, menus);
			return new SimpleAuthenticationInfo(shiroUser, user.getPassword(),
					getName());
		}
		return null;
	}

	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName())
				.iterator().next();
		List<String> permissions = this.menuService.selectPermission(shiroUser.getId());
		if (!permissions.isEmpty()) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addStringPermissions(permissions);
			return info;
		}
		return null;
	}

	public void setUseCaptcha(boolean useCaptcha) {
		this.useCaptcha = useCaptcha;
	}

	public static class HashPassword {
		public String salt;
		public String password;
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {

		private static final long serialVersionUID = -1748602382963711884L;
		private int id;
		private String loginName;
		private User user;
		private List<Menu> menus;

		public ShiroUser() {
		}

		/**
		 * 构造函数
		 * 
		 * @param id
		 * @param loginName
		 * @param email
		 * @param createTime
		 * @param status
		 */
		public ShiroUser(int id, String loginName, User user, List<Menu> menus) {
			this.id = id;
			this.loginName = loginName;
			this.user = user;
			this.menus = menus;
		}

		/**
		 * 返回 id 的值
		 * 
		 * @return id
		 */
		public int getId() {
			return id;
		}

		/**
		 * 返回 loginName 的值
		 * 
		 * @return loginName
		 */
		public String getLoginName() {
			return loginName;
		}

		/**
		 * 返回 user 的值
		 * 
		 * @return user
		 */
		public User getUser() {
			return user;
		}

		public List<Menu> getMenus() {
			return menus;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}
	}

}
