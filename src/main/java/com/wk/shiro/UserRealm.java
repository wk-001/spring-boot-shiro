package com.wk.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wk.entity.User;
import com.wk.service.ResourceService;
import com.wk.service.RoleService;
import com.wk.service.UserService;
import com.wk.utils.ActiverUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 用户认证授权
 * 该类已经在配置文件中声明，项目启动后对象就会添加到IOC容器。所以不需要扫描
 *  对象在IOC容器中存在，对象中的注解就会生效
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ResourceService resourceService;

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = token.getPrincipal().toString();
		QueryWrapper<User> wrapper = new QueryWrapper<User>()
				.eq("user_name",userName);
		User user = userService.getOne(wrapper);
		if (null != user) {
			String pwd = user.getPwd();
			//处理加密盐
			ByteSource salt = ByteSource.Util.bytes(user.getSalt());
			//根据用户ID查询用户所拥有的角色和权限
			List<String> roles = roleService.queryRoleByUserId(user.getId());
			List<String> resources = resourceService.queryResourcesByUserId(user.getId());
			//封装到对象，避免授权时频繁查询数据库
			ActiverUser activerUser = new ActiverUser(user,roles,resources);
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser,pwd,salt,getName());
			return info;
		}else{
			return null;
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiverUser activerUser = (ActiverUser) principals.getPrimaryPrincipal();
		List<String> roles = activerUser.getRoles();
		List<String> permissions = activerUser.getPermissions();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if(null != roles && roles.size()>0){
			info.addRoles(roles);
		}
		if(null != permissions && permissions.size()>0){
			info.addStringPermissions(permissions);
		}
		return info;
	}

}
